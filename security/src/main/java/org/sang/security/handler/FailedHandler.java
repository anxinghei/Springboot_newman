package org.sang.security.handler;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.security.auth.login.AccountExpiredException;
import javax.security.auth.login.CredentialExpiredException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;

import com.fasterxml.jackson.databind.ObjectMapper;

public class FailedHandler extends SimpleUrlAuthenticationFailureHandler{

	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {
		response.setContentType("application/json;charset=utf-8");
		PrintWriter out=response.getWriter();
		response.setStatus(401);
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("Status", 401);
		if(exception instanceof LockedException)
			map.put("msg", "账户被锁定，登录失败");
		else if(exception instanceof BadCredentialsException)
			map.put("msg", "账户名或密码错误，登录失败");
		else if(exception instanceof DisabledException)
			map.put("msg", "账户被禁用，登录失败");
		else 
			map.put("msg", "登录失败");
		ObjectMapper om=new ObjectMapper();
		out.write(om.writeValueAsString(map));
		out.flush();
		out.close();
//		super.onAuthenticationFailure(request, response, exception);
	}
}
