import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

public class MybatisTest {
	private SqlSessionFactory sqlSessionFactory = null;

	@Before
	public void init() throws Exception {
		// 1. ����SqlSessionFactoryBuilder����
		SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();

		// 2. ����SqlMapConfig.xml�����ļ�
		InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");

		// 3. ����SqlSessionFactory����
		this.sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
	}

	@Test
	public void testQueryUserById() throws Exception {
		// 4. ����SqlSession����
		SqlSession sqlSession = sqlSessionFactory.openSession();

		// 5. ִ��SqlSession����ִ�в�ѯ����ȡ���User
		// ��һ��������User.xml��statement��id���ڶ���������ִ��sql��Ҫ�Ĳ�����
		Object user = sqlSession.selectOne("queryUserById", 1);

		// 6. ��ӡ���
		System.out.println(user);

		// 7. �ͷ���Դ
		sqlSession.close();
	}
}