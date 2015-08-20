package com.mobile.blue.buuluu.api.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mobile.blue.buuluu.api.common.exception.FilterException;
import com.mobile.blue.buuluu.api.common.exception.IllegalUserSessionException;
import com.mobile.blue.buuluu.api.common.util.CodeStatus;
import com.mobile.blue.buuluu.api.common.util.I18nUtil;
import com.mobile.blue.buuluu.api.common.util.RequestUtil;
import com.mobile.blue.buuluu.api.service.UserSessionService;
import com.mobile.blue.buuluu.model.AppUserSession;

/**
 * 
 * 
 * @author edwin.zhou
 * 
 */
@Component
public class LoginFilter implements Filter {

	private Log logger = LogFactory.getLog(this.getClass());
	
	@Autowired
	private UserSessionService userSessionService;
	
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		this.logger.info("init");
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
        String userId = request.getParameter("userId");
		
        if (userId.startsWith("000000")) 
			return;
		
		String token = request.getParameter("token");
		
		String uri = RequestUtil.getRequestUri(request);
		if (StringUtils.isEmpty(uri)) {
			throw new FilterException("Get request URI is null.");
		}
		
		
	userSessionService.checkUserSession(userId,token);
		
		
		if(request.getCharacterEncoding() == null){
		  request.setCharacterEncoding("UTF-8"); 
		}
		
		chain.doFilter(request, resp);
	}

	@Override
	public void destroy() {

		this.logger.info("destory");
	}

}
