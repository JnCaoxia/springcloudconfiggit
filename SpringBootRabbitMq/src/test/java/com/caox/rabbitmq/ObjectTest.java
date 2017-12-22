package com.caox.rabbitmq;

import com.caox.model.User;
import com.caox.rabbit.object.ObjectSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ObjectTest {

	@Autowired
	private ObjectSender sender;

	@Test
	// 测试 springboot以及完美的支持对象的发送和接收，不需要格外的配置
	public void sendObject() throws Exception {
		User user=new User();
		user.setName("neo");
		user.setPass("123456");
		sender.send(user);
		sender.get(user);
	}

}