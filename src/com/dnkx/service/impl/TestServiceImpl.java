package com.dnkx.service.impl;

import javax.annotation.Resource;

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
		return testDao.selectByPrimaryKey(id);
	}

}
