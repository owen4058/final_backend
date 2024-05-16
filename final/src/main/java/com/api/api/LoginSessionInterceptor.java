package com.api.api;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.api.api.member.Member;

@Component
public class LoginSessionInterceptor implements HandlerInterceptor {

	@Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
		Member member = null;
		
		HttpSession session = request.getSession();
		
		member = (Member) session.getAttribute("loginMember");
		if (request.getMethod().equalsIgnoreCase("GET")) {
			return true;
		}
		
		if(member!=null && member.getUser_email()!= null){	
			return true;
		}else{
			return false;
		}

    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
            ModelAndView modelAndView) throws Exception {
        // TODO Auto-generated method stub

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        // TODO Auto-generated method stub

    }

}
