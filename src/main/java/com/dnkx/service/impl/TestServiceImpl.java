package com.dnkx.service.impl;

import javax.annotation.Resource;

import com.dnkx.dao.TestMapper;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dnkx.pojo.Test;
import com.dnkx.service.TestService;

@Service("testService")
public class TestServiceImpl implements TestService{

	@Autowired
	private TestMapper testDao;


	public Test getTestById(Integer id) {
		return null;
	}

	public int insert(Test re) {
		int record = 	testDao.insertRe(re);
		return re.getId();
	}


}
