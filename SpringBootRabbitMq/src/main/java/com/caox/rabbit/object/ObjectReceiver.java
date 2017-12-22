package com.caox.rabbit.object;

import com.caox.model.User;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "object")
public class ObjectReceiver {

    // 接收者  支持对象的发送和接收，不需要格外的配置。
    @RabbitHandler
    public void process(User user) {
        System.out.println("=========================Receiver object : " + user.toString() + "=========================");
    }

}
