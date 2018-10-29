package com.test.mail;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.study.mail.MailUtil;


@RunWith(SpringJUnit4ClassRunner.class)//@RunWith(SpringJUnit4ClassRunner.class) 来启动 Spring 对测试类的支持
@ContextConfiguration("/spring.xml")//@ContextConfiguration 注释标签来指定 Spring 配置文件或者配置类的位置
public class MailTest {
	private static final Logger log = LoggerFactory.getLogger(MailTest.class);
	
	@Autowired
	private MailUtil mailUtil;
	
	@Test
	public void sendSingleTest(){
		log.info("sendSingleTest");
		mailUtil.send("1074543006@qq.com", "不是垃圾", "请注意查收");
	}

	@Test
	public void sendMassTest(){
		log.info("sendMassTest");
		List<String> recipients=new ArrayList<String>();
		recipients.add("1074543006@qq.com");
		recipients.add("13593490824@163.com");
		mailUtil.send(recipients, "不是垃圾", "请注意查收2");
	}

}
