package com;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.amqp.RabbitAutoConfiguration;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.embedded.jetty.ServletContextInitializerConfiguration;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dao.EmpMapper;

@Controller
@SpringBootConfiguration
@SpringBootApplication(exclude={RedisAutoConfiguration.class,RabbitAutoConfiguration.class})
@RequestMapping(value="/demos")
@EnableScheduling
@EnableCaching
public class MySpringBoot extends SpringBootServletInitializer {
	@Resource
	EmpMapper em;
	 
	/* @Autowired
	 private StringRedisTemplate stringRedisTemplate;*/

	     

	    @Autowired
	  private  RedisTemplate redisTemplate;
	
    @RequestMapping(value="/hello")
	public @ResponseBody String  helloSpringBoot(){
    	System.out.println("===================");
		return "All men are created equal";
	}
    
   @RequestMapping(value="/visitPage")
    public String visitPage(){
    	return "visit";
    }
    
    @RequestMapping(value="/getData")
    public @ResponseBody User getData(@RequestBody User u){
    	System.out.println("传递的人员信息是："+ u);
    	u.setUserName("张文秀");
    	return u;
    	
    }
    
    
    @RequestMapping(value="/emp")
    public void empInfo(){
    	List<Emp> emp = em.empInfo();
    	System.out.println(emp);
    	ValueOperations ops = redisTemplate.opsForValue();
    	ops.set("向鹏飞", "18");
    	ops.set("湖北", "天门");
    	ops.set("北京时间", new Date());
    	redisTemplate.opsForValue().set("emp", emp);
    	HashMap<String, List> map = new HashMap<String,List>();
    	map.put("map", emp);
    	ops.set("ttt", map);
    }
    
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                      
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
    	// TODO Auto-generated method stub
    	return builder.sources(MySpringBoot.class);
    }
    
    
    public static void main(String[] args) {
		SpringApplication sa = new SpringApplication(MySpringBoot.class);
		sa.run(args);
	}
	
	
}
