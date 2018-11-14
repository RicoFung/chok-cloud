package com.client.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.client.entity.TbAuthority;
import com.client.service.TbAuthorityService;

import chok.devwork.BaseController;

@Scope("prototype")
@Controller
@RequestMapping("/authority")
public class TbAuthorityApi extends BaseController<TbAuthority>
{
	@Autowired
	private TbAuthorityService service;
	
	@RequestMapping("/queryWithRoleByAppid")
	public void queryWithRoleByAppid()
	{
		try
		{
			result.put("authorities", service.queryWithRoleByAppid(req.getString("appid")));
			printJson(result);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			result.setSuccess(false);
			result.setMsg(e.getMessage());
			printJson(result);
		}
	}
}
