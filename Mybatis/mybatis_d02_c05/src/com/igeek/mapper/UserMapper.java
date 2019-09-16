package com.igeek.mapper;

import java.util.List;

import com.igeek.pojo.User;

public interface UserMapper {
	/**
	 * �����û�id��ѯ
	 * 
	 * @param id
	 * @return
	 */
	User queryUserById(int id);

	/**
	 * �����û���ģ����ѯ�û�
	 * 
	 * @param username
	 * @return
	 */
	List<User> queryUserByUsername(String username);

	/**
	 * ����û�
	 * 
	 * @param user
	 */
	void saveUser(User user);
}
