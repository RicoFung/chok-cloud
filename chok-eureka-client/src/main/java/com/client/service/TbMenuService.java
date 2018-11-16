package com.client.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.client.dao.TbMenuDao;
import com.client.entity.TbMenu;

import chok.devwork.springboot.BaseDao;
import chok.devwork.springboot.BaseService;

@Service
public class TbMenuService extends BaseService<TbMenu,Long>
{
	@Autowired
	private TbMenuDao dao;

	@Override
	public BaseDao<TbMenu,Long> getEntityDao() 
	{
		return dao;
	}
	
	@Override
	public List<TbMenu> query(Map<String, Object> param) 
	{
		List<TbMenu> treeNodes = new ArrayList<TbMenu>();
		try
		{
			List<Long> menuIds = new ArrayList<Long>();
			List<TbMenu> menus = new ArrayList<TbMenu>();
			String usercode = param.containsKey("usercode")?param.get("usercode").toString():"";
			// 1. 查找目的菜单
			List<TbMenu> tarquery = dao.query(param);
			for(TbMenu o : tarquery)
			{
				menuIds.add(o.getId());
			}
			// 2. 根据目的菜单递归检索所有父菜单和子菜单
			if ((param.containsKey("menucode") && param.get("menucode").toString().length()>0) || (param.containsKey("menuname") && param.get("menuname").toString().length()>0))
			{
				// 2.1 递归检索父菜单
				List<Long> pids = new ArrayList<Long>(); // 缓存所有父节点id
				for(TbMenu o : tarquery)
				{
					menuIds.addAll(getParentMenus(usercode, o.getPid(), pids));
				}
				// 2.2 递归检索子菜单
				List<Long> cids = new ArrayList<Long>(); // 缓存所有子节点id
				for(TbMenu o : tarquery)
				{
					menuIds.addAll(getChildMenus(usercode, o.getId(), cids));
				}
			}
			// 3. 合并菜单集合
			// 3.1 去重复
			HashSet<Long> set = new HashSet<Long>(menuIds); 
			menuIds.clear(); 
			menuIds.addAll(set); 
			for(Long id : menuIds)
			{
				param.clear();
				param.put("id", id);
				param.put("usercode", usercode);
				menus.add((TbMenu) dao.query(param).get(0));
			}
			// 3.2 格式化为json
			for(int i=0; i<menus.size(); i++)
			{
				TbMenu o = menus.get(i);
				treeNodes.add(o);
			}
			// 3.3 按tc_order排序
			Collections.sort(treeNodes,new Comparator<TbMenu>(){
	            public int compare(TbMenu arg0, TbMenu arg1) {
	                return (arg0.getTcOrder()).compareTo(arg1.getTcOrder());
	            }
	        });
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return treeNodes;
	}
	
	// 递归检索父菜单id集合
	public List<Long> getParentMenus(String usercode, Long pid, List<Long> pids)
	{
		Map<String, Object> m = new HashMap<String, Object>();
		m.put("usercode", usercode);
		m.put("id",pid);
		List<TbMenu> parentMenus = dao.query(m);
		
		if(parentMenus.size()==1)
		{
			pids.add(parentMenus.get(0).getId());
			getParentMenus(usercode, parentMenus.get(0).getPid(), pids);
		}
		return pids;
	}
	
	// 递归检索子菜单id集合
	public List<Long> getChildMenus(String usercode, Long id, List<Long> cids)
	{
		Map<String, Object> m = new HashMap<String, Object>();
		m.put("usercode", usercode);
		m.put("pid",id);
		List<TbMenu> childMenus = dao.query(m);
		
		if(childMenus.size()>0)
		{
			for (int i=0; i<childMenus.size(); i++)
			{
				cids.add(childMenus.get(i).getId());
				getChildMenus(usercode, childMenus.get(i).getId(), cids);
			}
		}
		return cids;
	}
}
