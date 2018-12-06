package com.dnkx.activemq;

import javax.annotation.Resource;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.TextMessage;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

/**
 * 消费者
 * @author 李小拐 2016年11月12日 12:48:13
 *
 */
@Service
public class ConsumerService {
		
//	@Resource(name="jmsTemplate")
//	private JmsTemplate jmsTemplate;
	
	/**
	 * 接收消息
	 * @param destination
	 * @return
	 */
//	public TextMessage receive(Destination destination) {
//		TextMessage tm=(TextMessage)jmsTemplate.receive(destination);
//		try {
//			System.out.println("从队列--"+destination.toString()+"--接收到消息---"+tm.getText());
//		} catch (JMSException e) {
//			e.printStackTrace();
//		}
//		return tm;
//	}
}
