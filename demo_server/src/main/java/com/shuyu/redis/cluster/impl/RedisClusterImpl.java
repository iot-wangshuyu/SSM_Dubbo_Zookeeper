package com.shuyu.redis.cluster.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shuyu.redis.cluster.RedisCluster;
import com.shuyu.utils.GsonUtil;
import com.shuyu.utils.JedisClusterFactory;

import redis.clients.jedis.JedisCluster;

/**
 * @ClassName: RedisClusterImpl 
 * @Description: TODO
 * @author shuyu.wang
 * @date 2017年11月2日 下午4:57:37 
 * @version V1.0
 */
@Service
public class RedisClusterImpl implements RedisCluster {

	private JedisCluster jedisCluster;

	private static final String RETURN_OK = "OK";

	@Autowired
	public RedisClusterImpl(JedisClusterFactory jedisClusterFactory) {
		jedisCluster = jedisClusterFactory.getJedisCluster();

	}

	@Override
	public boolean exists(String key) {
		Boolean exists = jedisCluster.exists(key);
		return exists;
	}

	@Override
	public void delete(String key) {
		jedisCluster.del(key);

	}

	@Override
	public void setex(String key, int seconds, String value) {
		jedisCluster.setex(key, seconds, value);

	}

	@Override
	public void setString(String key, String value) {
		jedisCluster.set(key, value);

	}

	@Override
	public String getString(String key) {
		return jedisCluster.get(key);
	}

	@Override
	public <T> boolean setBean(String key, Object bean) {
		String set = jedisCluster.set(key, GsonUtil.GsonString(bean));
		if (!set.isEmpty() && (RETURN_OK).equals(set)) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public <T> T getBean(Class<T> cls, String key) {
		T bean = null;
		Boolean exists = jedisCluster.exists(key);
		if (exists) {
			String string = jedisCluster.get(key);
			if (string != null && !string.equals("")) {
				bean = GsonUtil.GsonToBean(string, cls);
			}
		}
		return bean;
	}

	@Override
	public <T> boolean setList(String key, List<T> list) {
		String set = jedisCluster.set(key, GsonUtil.GsonString(list));
		if (!set.isEmpty() && (RETURN_OK).equals(set)) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public <T> List<T> getList(Class<T> cls, String key) {
		List<T> list = null;
		Boolean exists = jedisCluster.exists(key);
		if (exists) {
			String string = jedisCluster.get(key);
			if (string != null && !string.equals("")) {
				list = GsonUtil.GsonToList(string, cls);
			}
		}
		return list;
	}
	
	

	@Override
	public <T> List<Map<String, T>> getListMap(Class<T> cls, String key) {
		List<Map<String, T>> list = null;
		Boolean exists = jedisCluster.exists(key);
		if (exists) {
			String string = jedisCluster.get(key);
			if (string != null && !string.equals("")) {
				list = GsonUtil.GsonToListMaps(string);
			}
		}
		return list;
	}

	@Override
	public <T> boolean setMap(String key, Map<String, T> map) {
		String set = jedisCluster.set(key, GsonUtil.GsonString(map));
		if (!set.isEmpty() && (RETURN_OK).equals(set)) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public <T> Map<String, T> getMap(String key) {
		Map<String, T> map = null;
		Boolean exists = jedisCluster.exists(key);
		if (exists) {
			String string = jedisCluster.get(key);
			if (string != null && !string.equals("")) {
				map = GsonUtil.GsonToMaps(string);
			}
		}
		return map;
	}

}
