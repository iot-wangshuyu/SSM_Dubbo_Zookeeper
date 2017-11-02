package com.shuyu.redis.cluster;

import java.util.List;
import java.util.Map;

public interface RedisCluster {

	boolean exists(String key);

	void delete(String key);

	void setex(String key, int seconds, String value);

	void setString(String key, String value);

	String getString(String key);

	/**
	 * 存储实体类
	 * @param key
	 * @param bean
	 */
	<T> boolean setBean(String key, Object bean);

	/**
	 * 获取实体类
	 * 
	 * @param key
	 * @return T
	 */
	<T> T getBean(Class<T> cls,String key);

	/**
	 * 存储 list
	 * @param key
	 * @param list
	 */
	<T> boolean setList(String key, List<T> list);

	/**
	 * 获取list
	 * @param key
	 * @return list
	 */
	<T> List<T> getList(Class<T> cls,String key);
	
	/**
	 * 获取listMap
	 * @param key
	 * @return list
	 */
	<T> List<Map<String, T>> getListMap(Class<T> cls,String key);

	/**
	 * 存储 map
	 * @param key
	 * @param map
	 */
	<T> boolean setMap(String key, Map<String, T> map);

	/**
	 * 获取map
	 * @param key
	 * @return Map
	 */
	<T> Map<String, T> getMap(String key);

}
