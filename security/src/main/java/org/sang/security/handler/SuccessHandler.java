package org.sang.security.handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

public class SuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler{

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws ServletException, IOException {
//		Object principal=authentication.getPrincipal();
//		response.setContentType("application/json;charset=utf-8");
//		PrintWriter out=response.getWriter();
//		response.setStatus(200);
//		Map<String, Object> map=new HashMap<String, Object>();
//		map.put("status", 200);
//		map.put("msg",principal);
//		ObjectMapper om=new ObjectMapper();
//		out.write(om.writeValueAsString(map));
//		out.flush();
//		out.close();
		response.sendRedirect("/hello");
//		super.onAuthenticationSuccess(request, response, authentication);
	}
}
