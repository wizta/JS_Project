package com.wizta.springphonebook;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class BaseInterceptor extends HandlerInterceptorAdapter {
	
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
		String controllerName = "";
		String actionName = "";
		try {
			if( handler instanceof HandlerMethod ) {
			// there are cases where this handler isn't an instance of HandlerMethod, so the cast fails.
			HandlerMethod handlerMethod = (HandlerMethod) handler;
			//controllerName = handlerMethod.getBean().getClass().getSimpleName().replace("Controller", "");
			controllerName  = handlerMethod.getBeanType().getSimpleName().replace("Controller", "");
			actionName = handlerMethod.getMethod().getName();
		}
		
		
		if (controllerName==null || actionName==null) {
			
		}else if (controllerName.equals("BasicError")) {
			//System.out.println("controller-name: " + controllerName);
		}else if ((controllerName.equals("Receive")) || (controllerName.equals("Movement"))) {
			//System.out.println("controller-name: " + controllerName);
		}else
		
		{
			modelAndView.addObject("controllerName", controllerName );
			modelAndView.addObject("actionName", actionName );
		}
		} catch(Exception ex) {
			//System.out.println(ex.getMessage());
		}
		
		
		
	}

}
