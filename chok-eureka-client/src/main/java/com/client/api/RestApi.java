package com.client.api;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.client.service.TbAuthorityService;
import com.client.service.TbMenuService;

import chok.devwork.BaseController;

@Scope("prototype")
@Controller
@RequestMapping("/")
public class RestApi extends BaseController<Object>
{
	@Autowired
	private TbMenuService		menuService;
	@Autowired
	private TbAuthorityService	authorityService;

	@RequestMapping(value = "/menu", method = RequestMethod.POST)
//	FORM提交，支持 headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
	public void menu(@RequestParam Map<String, Object> params)
	{
		try
		{
			result.put("menus", menuService.query(params));
			printJson(result);
		}
		catch (Exception e)
		{
			e.printStackTrace();
			result.setSuccess(false);
			result.setMsg(e.getMessage());
			printJson(result);
		}
	}
//	JSON提交，支持 headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
//	public void menu(@RequestBody Map<String, Object> params)
//	{
//		try
//		{
//			result.put("menus", menuService.query(params));
//			printJson(result);
//		}
//		catch (Exception e)
//		{
//			e.printStackTrace();
//			result.setSuccess(false);
//			result.setMsg(e.getMessage());
//			printJson(result);
//		}
//	}

	@RequestMapping("/authority")
	public void authority()
	{
		try
		{
			result.put("authorities", authorityService.query(req.getParameterValueMap(false, true)));
			printJson(result);
		}
		catch (Exception e)
		{
			e.printStackTrace();
			result.setSuccess(false);
			result.setMsg(e.getMessage());
			printJson(result);
		}
	}

	@RequestMapping(value = "/test", method = RequestMethod.POST)
	public void test()
	{
		result.setMsg("test");
		printJson(result);
	}

	@RequestMapping(value = "/csrf-token", method = RequestMethod.GET)
	public @ResponseBody String getCsrfToken(HttpServletRequest request)
	{
		CsrfToken token = (CsrfToken) request.getAttribute(CsrfToken.class.getName());
		return token.getToken();
	}
}
