package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.amqp.RabbitAutoConfiguration;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@SpringBootConfiguration
@SpringBootApplication(exclude={RedisAutoConfiguration.class,RabbitAutoConfiguration.class})
@RequestMapping(value="/demo")
public class MySpringBoots {
    @RequestMapping(value="/hello")
	public @ResponseBody String  helloSpringBoot(){
		return "hello springboot VS hello world===";
	}
    
    @RequestMapping(value="/visitPage")
    public String visitPage(){
    	return "visit";
    }
    
    @RequestMapping(value="/getData")
    public @ResponseBody User getData(User u){
    	System.out.println("传递的人员信息是："+ u);
    	u.setUserName("张文秀");
    	return u;
    	
    }
    
    
    
	
	
}
