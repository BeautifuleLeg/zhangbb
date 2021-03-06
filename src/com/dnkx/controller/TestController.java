package com.dnkx.controller;

import javax.annotation.Resource;
import javax.jms.Destination;
import javax.servlet.http.HttpServletRequest;

import com.dnkx.activemq.ConsumerService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dnkx.activemq.ProductService;
import com.dnkx.pojo.Test;
import com.dnkx.service.TestService;

/**
 * 测试
 * @author 李小拐 2016年11月12日 12:59:52
 *
 */
@Controller
@RequestMapping("/test")
public class TestController {
	
	@Resource
	private TestService testService;


	//队列生产者
	@Resource(name="consumerService")
	private ConsumerService consumerService;
	
	//队列生产者
	@Resource(name="productService")
	private ProductService product;
	//队列名称
//	@Resource(name="dnkxQueueDestination1")
//	private Destination destination;
	
	@RequestMapping("/test.do")
	public String test(HttpServletRequest request) {
//		Test test=testService.getTestById(1);
//		System.out.println("用户名："+test.getName()+"    密码："+test.getPassword());
//		request.setAttribute("name", test.getName());
		request.setAttribute("name", "111");
		return "main";
	}
	@RequestMapping("/test2.do")
	public String test2(HttpServletRequest request) {
		return "datagrid";
	}
	//这里是生产者生产消息的的地方
	@RequestMapping("/test1.do")
	public String test1(HttpServletRequest request) {
//		product.sendMessage(destination, "这是一条mq消息");
//		System.out.println("------发送成功-------------");
		return "index";
	}


	//这里是接受的的地方
	@RequestMapping("/test3.do")
	public String test3(HttpServletRequest request) {
//		consumerService.receive(destination);
//		System.out.println("------成功-------------");
		return "index";
	}
}
