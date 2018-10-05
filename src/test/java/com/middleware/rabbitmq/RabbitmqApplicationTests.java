package com.middleware.rabbitmq;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.middleware.rabbitmq.Hello.HelloSender;
import com.middleware.rabbitmq.model.User;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitmqApplicationTests {

	@Autowired
	private HelloSender helloSender;
	
	@Test
	public void hello() {
		helloSender.send();
	}
	
	/**
	 * 接收端注册两个receiver，receiver1和recevier2，一个发送端
	 * 结论：一个发送者，N个接受者,经过测试会均匀的将消息发送到N个接收者中
	 * @throws InterruptedException
	 */
	@Test
	public void oneToMany() throws InterruptedException{
		for (int i = 0; i < 100; i++) {
			helloSender.send();
			Thread.sleep(1000*1);
		}
	}
	
	
	/**
	 * 多个发送者
	 * 多个接收者
	 * 结论：和一对多一样，接收端仍然会均匀接收到消息
	 * @throws InterruptedException 
	 */
	@Test
	public void manyTomany() throws InterruptedException{
		for (int i = 0; i < 100; i++){
			helloSender.send(String.valueOf(i));
			helloSender.send(String.valueOf(i));
			Thread.sleep(1000*1);
		}
	}

	
	@Test
	public void sendTopic(){
		//helloSender.send1();
		helloSender.send2();
	}
	
	
	@Test
	public void sendFanOut(){
		helloSender.sendFanOutExchange();
	}
	
	

}
