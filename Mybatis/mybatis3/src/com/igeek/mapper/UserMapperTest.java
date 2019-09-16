package com.igeek.mapper;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.igeek.pojo.QueryVo;
import com.igeek.pojo.User;

public class UserMapperTest {
	private SqlSessionFactory sqlSessionFactory;

	@Before
	public void init() throws Exception {
		// ����SqlSessionFactoryBuilder
		SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
		// ����SqlMapConfig.xml�����ļ�
		InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
		// ����SqlsessionFactory
		this.sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
	}

	@Test
	public void testQueryUserByQueryVo() {
		// mybatis��spring���ϣ�����֮�󣬽���spring����
		SqlSession sqlSession = this.sqlSessionFactory.openSession();
		// ����Mapper�ӿڵĶ�̬�����������֮�󣬽���spring����
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

		// ʹ��userMapperִ�в�ѯ��ʹ�ð�װ����
		QueryVo queryVo = new QueryVo();
		// ����user����
		User user = new User();
		user.setUsername("��");
		// ���õ���װ������
		queryVo.setUser(user);

		// ִ�в�ѯ
		List<User> list = userMapper.queryUserByQueryVo(queryVo);
		for (User u : list) {
			System.out.println(u);
		}

		// mybatis��spring���ϣ�����֮�󣬽���spring����
		sqlSession.close();
	}
	@Test
	public void testQueryUserCount() {
		// mybatis��spring���ϣ�����֮�󣬽���spring����
		SqlSession sqlSession = this.sqlSessionFactory.openSession();
		// ����Mapper�ӿڵĶ�̬�����������֮�󣬽���spring����
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

		// ʹ��userMapperִ�в�ѯ�û���������
		int count = userMapper.queryUserCount();
		System.out.println(count);

		// mybatis��spring���ϣ�����֮�󣬽���spring����
		sqlSession.close();
	}
	@Test
	public void testQueryAll() {
		// ��ȡsqlSession
		SqlSession sqlSession = this.sqlSessionFactory.openSession();
		// ��ȡOrderMapper
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

		// ִ�в�ѯ
		List<User> list = userMapper.queryUserAll();
		for (User user : list) {
			System.out.println(user);
		}
	}
	@Test
	public void testQueryUserByWhere() {
		// mybatis��spring���ϣ�����֮�󣬽���spring����
		SqlSession sqlSession = this.sqlSessionFactory.openSession();
		// ����Mapper�ӿڵĶ�̬�����������֮�󣬽���spring����
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

		// ʹ��userMapperִ�и���������ѯ�û�
		User user = new User();
		user.setSex("1");
		user.setUsername("��");

		List<User> list = userMapper.queryUserByWhere(user);

		for (User u : list) {
			System.out.println(u);
		}

		// mybatis��spring���ϣ�����֮�󣬽���spring����
		sqlSession.close();
	}
	@Test
	public void testQueryUserByIds() {
		// mybatis��spring���ϣ�����֮�󣬽���spring����
		SqlSession sqlSession = this.sqlSessionFactory.openSession();
		// ����Mapper�ӿڵĶ�̬�����������֮�󣬽���spring����
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

		// ʹ��userMapperִ�и���������ѯ�û�
		QueryVo queryVo = new QueryVo();
		List<Integer> ids = new ArrayList<>();
		ids.add(1);
		ids.add(10);
		ids.add(24);
		queryVo.setIds(ids);

		List<User> list = userMapper.queryUserByIds(queryVo);

		for (User u : list) {
			System.out.println(u);
		}

		// mybatis��spring���ϣ�����֮�󣬽���spring����
		sqlSession.close();
	}
}
