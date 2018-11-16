package com.client.entity;

import java.io.Serializable;

/**
 *
 * @author rico
 * @version 1.0
 * @since 1.0
 */
public class TbMenu implements Serializable
{
	private static final long serialVersionUID = 1L;

	// id db_column: id
	private java.lang.Long id;
	// pid db_column: pid
	private java.lang.Long pid;
	// tcAuthorityId db_column: tc_authority_id
	private java.lang.Long tcAuthorityId;
	// tcAppId db_column: tc_app_id
	private java.lang.Long tcAppId;
	// tcCode db_column: tc_code
	private java.lang.String tcCode;
	// tcName db_column: tc_name
	private java.lang.String tcName;
	// tcOrder db_column: tc_order
	private java.lang.String tcOrder;
	// 级别：0->根节点；1->一级节点；2->次级节点 db_column: tc_level
	private java.lang.String tcLevel;
	// tcUrl db_column: tc_url
	private java.lang.String tcUrl;

	public TbMenu()
	{
	}

	public TbMenu(java.lang.Long id, java.lang.Long pid, java.lang.Long tcAuthorityId, java.lang.Long tcAppId,
			java.lang.String tcCode, java.lang.String tcName, java.lang.String tcOrder, java.lang.String tcLevel)
	{
		this.id = id;
		this.pid = pid;
		this.tcAuthorityId = tcAuthorityId;
		this.tcAppId = tcAppId;
		this.tcCode = tcCode;
		this.tcName = tcName;
		this.tcOrder = tcOrder;
		this.tcLevel = tcLevel;
	}

	public void setId(java.lang.Long value)
	{
		this.id = value;
	}

	public java.lang.Long getId()
	{
		return this.id;
	}

	public void setPid(java.lang.Long value)
	{
		this.pid = value;
	}

	public java.lang.Long getPid()
	{
		return this.pid;
	}

	public void setTcAuthorityId(java.lang.Long value)
	{
		this.tcAuthorityId = value;
	}

	public java.lang.Long getTcAuthorityId()
	{
		return this.tcAuthorityId;
	}

	public void setTcAppId(java.lang.Long value)
	{
		this.tcAppId = value;
	}

	public java.lang.Long getTcAppId()
	{
		return this.tcAppId;
	}

	public void setTcCode(java.lang.String value)
	{
		this.tcCode = value;
	}

	public java.lang.String getTcCode()
	{
		return this.tcCode;
	}

	public void setTcName(java.lang.String value)
	{
		this.tcName = value;
	}

	public java.lang.String getTcName()
	{
		return this.tcName;
	}

	public void setTcOrder(java.lang.String value)
	{
		this.tcOrder = value;
	}

	public java.lang.String getTcOrder()
	{
		return this.tcOrder;
	}

	public void setTcLevel(java.lang.String value)
	{
		this.tcLevel = value;
	}

	public java.lang.String getTcLevel()
	{
		return this.tcLevel;
	}

	public java.lang.String getTcUrl()
	{
		return tcUrl;
	}

	public void setTcUrl(java.lang.String tcUrl)
	{
		this.tcUrl = tcUrl;
	}
	
}
