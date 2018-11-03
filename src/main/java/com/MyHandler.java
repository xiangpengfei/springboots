package com;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class MyHandler extends WebMvcConfigurerAdapter{
  @Override
public void addInterceptors(InterceptorRegistry registry) {
	// TODO Auto-generated method stub
HandlerInterceptor cp=	new HandlerInterceptor() {
		
		@Override
		public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
				throws Exception {
			// TODO Auto-generated method stub
			System.out.println("处理器映射器映射成功之后，开始执行prehandle======");
			return true;
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
	};
	
	registry.addInterceptor(cp).addPathPatterns("/**");
}
}
