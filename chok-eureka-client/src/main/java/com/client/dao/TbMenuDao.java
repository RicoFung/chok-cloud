package com.client.dao;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.client.entity.TbMenu;

import chok.devwork.springboot.BaseDao;

@Repository
public class TbMenuDao extends BaseDao<TbMenu,Long>
{
	@Resource//(name = "firstSqlSessionTemplate")
	private SqlSession sqlSession;

	@Override
	protected SqlSession getSqlSession()
	{
		return sqlSession;
	}
	
	@Override
	public Class<TbMenu> getEntityClass()
	{
		return TbMenu.class;
	}
}
