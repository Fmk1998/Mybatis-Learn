package com.igeek;

import java.io.InputStream;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.igeek.mapper.UserMapper;
import com.igeek.pojo.User;

public class UserMapperTest {
	private SqlSessionFactory sqlSessionFactory;

	@Before
	public void init() throws Exception {
		// ����SqlSessionFactoryBuilder
		SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
		// ����SqlMapConfig.xml�����ļ�
		InputStream inputStream = Resources.getResourceAsStream("mybatis.xml");
		// ����SqlsessionFactory
		this.sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
	}

	@Test
	public void testQueryUserById() {
		// ��ȡsqlSession����spring���Ϻ���spring����
		SqlSession sqlSession = this.sqlSessionFactory.openSession();

		// ��sqlSession�л�ȡMapper�ӿڵĴ������
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		// ִ�в�ѯ����
		User user = userMapper.queryUserById(1);
		System.out.println(user);

		// ��spring���Ϻ���spring����
		sqlSession.close();
	}

	@Test
	public void testQueryUserByUsername() {
		// ��ȡsqlSession����spring���Ϻ���spring����
		SqlSession sqlSession = this.sqlSessionFactory.openSession();

		// ��sqlSession�л�ȡMapper�ӿڵĴ������
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		// ִ�в�ѯ����
		List<User> list = userMapper.queryUserByUsername("��");
		for (User user : list) {
			System.out.println(user);
		}

		// ��spring���Ϻ���spring����
		sqlSession.close();
	}

	@Test
	public void testSaveUser() {
		// ��ȡsqlSession����spring���Ϻ���spring����
		SqlSession sqlSession = this.sqlSessionFactory.openSession();

		// ��sqlSession�л�ȡMapper�ӿڵĴ������
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		// �����������
		User user = new User();
		user.setUsername("����");
		user.setBirthday(new Date());
		user.setSex("1");
		user.setAddress("���");
		// ִ�в�ѯ����
		userMapper.saveUser(user);
		System.out.println(user);


		// ��spring���Ϻ���spring����
		sqlSession.commit();
		sqlSession.close();
	}
}
