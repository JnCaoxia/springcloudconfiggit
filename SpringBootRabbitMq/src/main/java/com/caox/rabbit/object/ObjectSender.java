package com.caox.rabbit.object;

import com.caox.model.User;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ObjectSender {

	@Autowired
	private AmqpTemplate rabbitTemplate;

	// 发送者 ： 支持对象的发送和接收，不需要格外的配置。
	public void send(User user) {
		System.out.println("Sender object: " + user.toString());
		this.rabbitTemplate.convertAndSend("object", user);
	}

	public void get(User user){
		System.out.println("Receiver object: " + user.toString());
		this.rabbitTemplate.receiveAndConvert("object");
	}

}