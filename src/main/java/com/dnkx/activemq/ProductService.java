package com.dnkx.activemq;

import javax.annotation.Resource;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

/**
 * 生产者
 * @author 李小拐 2016年11月12日 12:48:35
 *
 */
@Service
public class ProductService {
	
	
//	@Resource(name="jmsTemplate")
//	private JmsTemplate jmsTemplate;
	
	/**
	 * 向指定队列发送消息
	 * @param destination
	 * @param msg
	 */
//	public void sendMessage(Destination destination,final String msg) {
//		System.out.println("向队列--"+destination.toString()+"--发送消息--"+msg);
//		jmsTemplate.send(destination, new MessageCreator() {
//			@Override
//			public Message createMessage(Session session) throws JMSException {
//				return session.createTextMessage(msg);
//			}
//		});
//
//	}
	
	/**
	 * 向默认队列发送消息
	 * @param msg
	 */
//	public void sendMessage(final String msg) {
//		System.out.println("向队列--"+jmsTemplate.getDefaultDestinationName().toString()+"--发送消息--"+msg);
//		jmsTemplate.send(new MessageCreator() {
//			@Override
//			public Message createMessage(Session session) throws JMSException {
//				return session.createTextMessage(msg);
//			}
//		});
//	}
}
