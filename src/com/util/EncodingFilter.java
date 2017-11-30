package com.util;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class EncodingFilter implements Filter {

	private String encoding = "UTF-8";

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain arg2) throws IOException, ServletException {
		request.setCharacterEncoding(encoding);
		response.setCharacterEncoding(encoding);
		// 传递控制到下一个过滤器
		arg2.doFilter(request, response);

	}

	public void init(FilterConfig filterConfig) throws ServletException {
		String s = filterConfig.getInitParameter("Encoding");
		if (s != null) {
			encoding = s;
		}

	}

	public void destroy() {

	}
}
