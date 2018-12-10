package com.dnkx.activemq.listener;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.apache.activemq.store.journal.JournalTransactionStore.Tx;
/**
 * 消息监听器
 * @author 李小拐 2016年11月12日 12:49:04
 *
 */
public class QueueMessageListener implements MessageListener{

	@Override
	public void onMessage(Message message) {
		
		TextMessage tm = (TextMessage) message;
		try {
			System.out.println("收到的消息-----"+tm.getText());
		} catch (JMSException e) {
			e.printStackTrace();
		}
		
	}

}
