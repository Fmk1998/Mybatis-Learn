package com.igeek.mapper;

import java.util.List;

import com.igeek.pojo.QueryVo;
import com.igeek.pojo.User;

public interface UserMapper {
	/**
	 * 
	* @Title: queryUserByQueryVo  
	* @Description: TODO(���ݰ�װ���ѯ�û�)  
	* @param queryVo
	* @return
	 */
	List<User> queryUserByQueryVo(QueryVo queryVo);
	/**
	 * 
	* @Title: queryUserCount  
	* @Description: TODO(������һ�仰�����������������)  
	* @return
	 */
	int queryUserCount();
	/**
	 * ��ѯ���ж���
	 * 
	 * @return
	 */
	List<User> queryUserAll();
	/**
	 * 
	* @Title: queryUserByWhere  
	* @Description: ����������ѯ�û�
	* @param user
	* @return
	 */
	List<User> queryUserByWhere(User user);
	
	List<User>  queryUserByIds(QueryVo queryVo);
}
