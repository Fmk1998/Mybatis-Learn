package com.igeek.mapper;

import java.util.List;

import com.igeek.pojo.QueryVo;
import com.igeek.pojo.User;

public interface UserMapper {
	/**
	 * 
	* @Title: queryUserByQueryVo  
	* @Description: TODO(根据包装类查询用户)  
	* @param queryVo
	* @return
	 */
	List<User> queryUserByQueryVo(QueryVo queryVo);
	/**
	 * 
	* @Title: queryUserCount  
	* @Description: TODO(这里用一句话描述这个方法的作用)  
	* @return
	 */
	int queryUserCount();
	/**
	 * 查询所有订单
	 * 
	 * @return
	 */
	List<User> queryUserAll();
	/**
	 * 
	* @Title: queryUserByWhere  
	* @Description: 根据条件查询用户
	* @param user
	* @return
	 */
	List<User> queryUserByWhere(User user);
	
	List<User>  queryUserByIds(QueryVo queryVo);
}
