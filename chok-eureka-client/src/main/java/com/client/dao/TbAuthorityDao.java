package com.client.dao;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.client.entity.TbAuthority;

import chok.devwork.springboot.BaseDao;

@Repository
public class TbAuthorityDao extends BaseDao<TbAuthority,Long>
{
	@Resource//(name = "firstSqlSessionTemplate")
	private SqlSession sqlSession;

	@Override
	protected SqlSession getSqlSession()
	{
		return sqlSession;
	}
	
	@Override
	public Class<TbAuthority> getEntityClass()
	{
		return TbAuthority.class;
	}
}
