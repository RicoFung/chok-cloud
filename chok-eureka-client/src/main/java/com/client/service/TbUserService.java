package com.client.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.client.dao.TbUserDao;
import com.client.entity.TbUser;

import chok.devwork.springboot.BaseDao;
import chok.devwork.springboot.BaseService;

@Service
public class TbUserService extends BaseService<TbUser,Long>
{
	@Autowired
	private TbUserDao dao;

	@Override
	public BaseDao<TbUser,Long> getEntityDao() 
	{
		return dao;
	}
	
	public TbUser getByUsername(String username)
	{
		return dao.getByUsername(username);
	}
}
