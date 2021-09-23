package com.uefa.cl.framework.interceptors;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class HttpHandler implements HandlerInterceptor {


	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object handler) throws Exception {
		String requestPath = req.getServletPath();// Servlet Path : /user/1 path after api path
		String queryString = req.getQueryString();// Query String : name='ufuk'&surname='doganca'

		if (!requestPath.startsWith("/login") && 
				!requestPath.contains("download") && 
				!requestPath.startsWith("/ws") && 
				!requestPath.startsWith("/error") &&
				!requestPath.startsWith("/public") &&
				!requestPath.startsWith("/swagger") && 
				!requestPath.startsWith("/v3/api-docs")) {
		}

		if (queryString == null) queryString = "";
		System.out.println("REQUEST : " + requestPath + "/" + queryString);
		return HandlerInterceptor.super.preHandle(req, res, handler);
	}
}
