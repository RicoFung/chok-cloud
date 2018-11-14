package com.client.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.client.entity.TbUser;
import com.client.service.TbUserService;

import chok.devwork.BaseController;

@Scope("prototype")
@Controller
@RequestMapping("/user")
public class TbUserApi extends BaseController<TbUser>
{
	@Autowired
	private TbUserService service;
	
	@RequestMapping("/getByUsername")
	public void getByUsername() 
	{
		try
		{
			result.put("po", service.getByUsername(req.getString("username")));
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
