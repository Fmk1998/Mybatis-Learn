package com.igeek.mapper;


import java.util.Date;
import java.util.List;


import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.igeek.pojo.User;

public class UserMapperTest {
	private ApplicationContext context;

	@Before
	public void setUp() throws Exception {
		this.context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
	}

	@Test
	public void testQueryUserById() {
		// ��ȡMapper
		UserMapper userMapper = this.context.getBean(UserMapper.class);

		User user = userMapper.queryUserById(1);
		System.out.println(user);
	}

	@Test
	public void testQueryUserByUsername() {
		// ��ȡMapper
		UserMapper userMapper = this.context.getBean(UserMapper.class);

		List<User> list = userMapper.queryUserByUsername("��");

		for (User user : list) {
			System.out.println(user);
		}
	}
	@Test
	public void testSaveUser() {
		// ��ȡMapper
		UserMapper userMapper = this.context.getBean(UserMapper.class);

		User user = new User();
		user.setUsername("�ܲ�");
		user.setSex("1");
		user.setBirthday(new Date());
		user.setAddress("����");

		userMapper.saveUser(user);
		System.out.println(user);
	}
}