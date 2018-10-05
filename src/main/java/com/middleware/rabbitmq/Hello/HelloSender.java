package com.middleware.rabbitmq.Hello;

import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.middleware.rabbitmq.model.User;

/**
* @author wudi
* @version 创建时间：2018年10月5日 下午8:39:03
* @ClassName 类名称
* @Description 发送者
*/
@Component
public class HelloSender {

	private static Logger logger = Logger.getLogger(HelloSender.class);
	@Autowired
	private AmqpTemplate rabbitTemplate;
	
	public void send(){
		String context = "hello "+new Date();
		logger.info("Sender: "+context);
		this.rabbitTemplate.convertAndSend("hello", context);
	}
	
	
	/**
	 * 发送入参信息
	 * @param context
	 */
	public void send(String context){
		this.rabbitTemplate.convertAndSend("hello",context);
	}
	
	
	/**
	 * 发送用户
	 * @param user
	 */
	public void send(User user){
		this.rabbitTemplate.convertAndSend("object", user);
	}
	
	
	public void send1() {
	    String context = "hi, i am message 1";
	    System.out.println("Sender : " + context);
	    this.rabbitTemplate.convertAndSend("exchange", "topic.message", context);
	}
	 
	public void send2() {
	    String context = "hi, i am messages 2";
	    System.out.println("Sender : " + context);
	    this.rabbitTemplate.convertAndSend("exchange", "topic.messages", context);
	}
	
	public void sendFanOutExchange() {
        String context = "hi, fanout msg ";
        System.out.println("Sender : " + context);
        this.rabbitTemplate.convertAndSend("fanoutExchange","", context);
}


	
	
}
