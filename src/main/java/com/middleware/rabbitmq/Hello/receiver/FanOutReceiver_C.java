package com.middleware.rabbitmq.Hello.receiver;

import org.apache.log4j.Logger;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
* @author wudi
* @version 创建时间：2018年10月5日 下午10:24:11
* @ClassName 类名称
* @Description 类描述
*/
@Component
public class FanOutReceiver_C {

	private static final Logger logger = Logger.getLogger(FanOutReceiver_C.class);
			
	
	@RabbitListener(queues="fanout.C")
	@RabbitHandler
	public void process(String hello){
		logger.info("FanoutExchangeC:"+hello);
	}
	
}
