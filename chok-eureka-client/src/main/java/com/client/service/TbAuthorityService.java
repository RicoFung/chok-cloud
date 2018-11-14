package com.client.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import chok.devwork.springboot.BaseDao;
import chok.devwork.springboot.BaseService;
import com.client.dao.TbAuthorityDao;
import com.client.entity.TbAuthority;

@Service
public class TbAuthorityService extends BaseService<TbAuthority,Long>
{
	@Autowired
	private TbAuthorityDao dao;

	@Override
	public BaseDao<TbAuthority,Long> getEntityDao() 
	{
		return dao;
	}
	
	public List<TbAuthority> queryWithRoleByAppid(String appid)
	{
		return dao.queryWithRoleByAppid(appid);
	}
}
