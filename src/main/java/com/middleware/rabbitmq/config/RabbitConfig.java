package com.middleware.rabbitmq.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
* @author wudi
* @version 创建时间：2018年10月5日 下午8:31:35
* @ClassName 类名称
* @Description RabbitConfig
*/
@Configuration
public class RabbitConfig {

	@Bean
	public Queue Queue(){
		return new Queue("hello");
	}
}
