package com.igeek.mapper;

import java.util.List;

import com.igeek.pojo.User;

public interface UserMapper {
	/**
	 * ����id��ѯ
	 * 
	 * @param id
	 * @return
	 */
	User queryUserById(int id);

	/**
	 * �����û�����ѯ�û�
	 * 
	 * @param username
	 * @return
	 */
	List<User> queryUserByUsername(String username);

	/**
	 * �����û�
	 * 
	 * @param user
	 */
	void saveUser(User user);
}
