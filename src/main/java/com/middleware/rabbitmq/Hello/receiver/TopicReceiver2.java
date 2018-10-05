package com.middleware.rabbitmq.Hello.receiver;

import org.apache.log4j.Logger;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
* @author wudi
* @version 创建时间：2018年10月5日 下午10:01:53
* @ClassName 类名称
* @Description 类描述
*/
@Component
public class TopicReceiver2 {

	private static Logger logger = Logger.getLogger(TopicReceiver2.class);
	
	@RabbitListener(queues="topic.messages")
	@RabbitHandler
	public void process(String hello){
		logger.info("Topic Message Receiver2:"+hello);
	}
}
