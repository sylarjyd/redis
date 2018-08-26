package cn.jyd.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.jyd.inter.AuthService;

public class TestRedis {
		public static void main(String[] args) {
			ApplicationContext factory=new ClassPathXmlApplicationContext("classpath:spring-application.xml");
			AuthService as = (AuthService)factory.getBean("authService");
			for (int i = 0; i < 10000; i++) {
				String verification = as.verification("asd_"+i);
				System.out.println("asd_"+i+":     "+verification);
			}
//			as.sendMessage("talk", "我是坏人");
			
		}
}
