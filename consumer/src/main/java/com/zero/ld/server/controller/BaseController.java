package com.zero.ld.server.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @date 2018年6月5日 下午10:34:48
 * @author zero
 */
public abstract class BaseController {
	protected final Logger logger = LoggerFactory.getLogger(getClass());
	
	private static final String UNKNOW = "unknown";
	
	/**
	 * Get client address
	 * @param request
	 * @return
	 */
	protected String getRemoteAddress(HttpServletRequest request) {
		String remote = request.getHeader("X-Real-IP");
		if(StringUtils.isBlank(remote) || UNKNOW.equalsIgnoreCase(remote)) {
			remote = request.getHeader("HTTP_CLIENT_IP");
			if(StringUtils.isBlank(remote) || UNKNOW.equalsIgnoreCase(remote)) {
				remote = request.getHeader("WL-Proxy-Client-IP");
				if(StringUtils.isBlank(remote) || UNKNOW.equalsIgnoreCase(remote)) {
					remote = request.getHeader("Proxy-Client-IP");
					if(StringUtils.isBlank(remote) || UNKNOW.equalsIgnoreCase(remote)) {
						remote = request.getHeader("X-Forwarded-For");
						if(StringUtils.isBlank(remote) || UNKNOW.equalsIgnoreCase(remote)) {
							remote = request.getRemoteAddr();
						} else {
							remote = remote.split(",")[0];
						}
					}
				}
				
			}
		}
		return remote;
	}
}
