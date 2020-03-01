package com.dq.photomanagement.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dq.photomanagement.bean.Photo;
import com.dq.photomanagement.dao.PhotoMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:applicationContext.xml"})
public class MapperTest {
	
	@Autowired
	PhotoMapper photomapper;
	
	@Test
	public void test() {
		System.out.println(photomapper.selectByPrimaryKey("2"));
		//photomapper.insertSelective(new Photo(1, "the one", "first", "classpath", 123));
		System.out.println(photomapper);
	}

}
