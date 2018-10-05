package com.middleware.rabbitmq.Hello.receiver;

import org.apache.log4j.Logger;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.middleware.rabbitmq.Hello.HelloSender;

/**
* @author wudi
* @version 创建时间：2018年10月5日 下午8:43:46
* @ClassName 类名称
* @Description 接收者1
*/
@Component
public class HelloReceiver1 {
	
	private static Logger logger = Logger.getLogger(HelloReceiver1.class);
	
	@RabbitListener(queues="hello")
	@RabbitHandler
	public void process(String hello){
		logger.info("Receiver1:"+hello);
	}
	
}
