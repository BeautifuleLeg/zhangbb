package com.dnkx.service.impl;

import javax.annotation.Resource;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.dnkx.dao.TestDao;
import com.dnkx.pojo.Test;
import com.dnkx.service.TestService;

@Service("testService")
public class TestServiceImpl implements TestService{

	@Resource
	private TestDao testDao;
	
	
	@Override
	public Test getTestById(Integer id) {
		System.out.println("测试");
		return null;
	}

}
