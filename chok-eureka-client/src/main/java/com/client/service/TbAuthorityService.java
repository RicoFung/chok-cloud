package com.client.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.client.dao.TbAuthorityDao;
import com.client.entity.TbAuthority;

import chok.devwork.springboot.BaseDao;
import chok.devwork.springboot.BaseService;

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
}
