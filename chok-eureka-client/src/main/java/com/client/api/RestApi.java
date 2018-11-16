package com.client.api;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.client.service.TbAuthorityService;
import com.client.service.TbMenuService;

import chok.devwork.BaseController;

@Scope("prototype")
@Controller
@RequestMapping("/")
public class RestApi extends BaseController<Object>
{
	@Autowired
	private TbMenuService menuService;
	@Autowired
	private TbAuthorityService authorityService;
	
	@RequestMapping(value ="/menu", method = RequestMethod.POST)
	public void menu(@RequestBody Map<String, Object> params)
	{
		try
		{
			result.put("menus", menuService.query(params));
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
	
	@RequestMapping("/authority")
	public void authority()
	{
		try
		{
			result.put("authorities", authorityService.query(req.getParameterValueMap(false, true)));
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
