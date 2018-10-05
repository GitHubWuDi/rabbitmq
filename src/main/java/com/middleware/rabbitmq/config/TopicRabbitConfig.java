package com.middleware.rabbitmq.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
* @author wudi
* @version 创建时间：2018年10月5日 下午9:47:37
* @ClassName 类名称
* @Description TopicRabbitConfig
*/
@Configuration
public class TopicRabbitConfig {

	private final static String message = "topic.message";
	private final static String messages = "topic.messages";
	
	@Bean
	public Queue queueMessage(){
		 return new Queue(TopicRabbitConfig.message);
	}
	
	@Bean
	public Queue queueMessages(){
		 return new Queue(TopicRabbitConfig.messages);
	}
	
	@Bean
    public TopicExchange exchange() {
        return new TopicExchange("exchange");
    }
	
    @Bean
    public Binding bindingExchangeMessage(Queue queueMessage,TopicExchange exchange){
    	return BindingBuilder.bind(queueMessage).to(exchange).with("topic.message") ; //只能匹配topic.message
    }
    
    @Bean
    public Binding bindingExchangeMessages(Queue queueMessages, TopicExchange exchange){
    	return BindingBuilder.bind(queueMessages).to(exchange).with("topic.#");   //可以同时匹配两个队列
    }
    

	
}
