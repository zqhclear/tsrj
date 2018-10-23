package org.tsrj.common.redis;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tsrj.common.redis.RedisKey.Key;
import org.tsrj.common.utils.PropertyUtil;
import org.tsrj.common.utils.StrUtils;

import com.alibaba.fastjson.JSONObject;
import com.xiaoleilu.hutool.util.StrUtil;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class RedisClient {

	/* 获取锁的循环次数 */
	private static final int GET_LOCK_NUM = 100;



	private static Logger logger = LoggerFactory.getLogger(RedisClient.class);
	private RedisClient() {
	}

	static class CachePool {
		JedisPool pool;
		private static final CachePool cachePool = new CachePool();

		public static CachePool getInstance() {
			return cachePool;
		}

		private CachePool() {
			JedisPoolConfig config = new JedisPoolConfig();
			config.setMaxIdle(Integer.parseInt(PropertyUtil.getProperty("redis.maxIdle")));
			config.setMaxWaitMillis(Integer.parseInt(PropertyUtil.getProperty("redis.maxWaitMillis")));
			config.setMaxTotal(Integer.parseInt(PropertyUtil.getProperty("redis.maxTotal")));
			pool = new JedisPool(config, PropertyUtil.getProperty("redis.address"), Integer.parseInt(PropertyUtil.getProperty("redis.port")), Integer.parseInt(PropertyUtil.getProperty("redis.timeout")), PropertyUtil.getProperty("redis.password"));
			
		}

		public Jedis getJedis() {
			Jedis jedis = null;
			try {
				jedis = pool.getResource();
			} catch (Exception e) {
				logger.error("redis连接异常", e);
			}
			return jedis;
		}

		public JedisPool getJedisPool() {
			return this.pool;
		}

	}

	public static Jedis getJedis() {
		return CachePool.getInstance().getJedis();
	}

	public static JedisPool getJedisPool() {
		return CachePool.getInstance().getJedisPool();
	}

	/**
	 * 设置对象属性值
	 * @param key
	 * @param field
	 * @param value
	 */
	public static void hset(RedisKey.Key key, String field, String value) {
		Jedis jedis = getJedis();
		try {
			jedis.select(key.getDb());
			jedis.hset(key.getKey(), field, value);
		} finally {
			jedis.close();
		}
	}
	
	/**
	 * 获得对象属性值
	 * @param key
	 * @param field
	 */
	public static String hget(RedisKey.Key key, String field){
		Jedis jedis = getJedis();
		try {
			jedis.select(key.getDb());
			return jedis.hget(key.getKey(), field);
		} finally {
			jedis.close();
		}
	}
	
	/**
	 * getSet方法
	 * @param key
	 * @param obj
	 * @return
	 */
	public static Object getSet(RedisKey.Key key, List list){
		Jedis jedis = getJedis();
		try {
			jedis.select(key.getDb());
			Object obj = jedis.getSet(key.getKey(), JSONObject.toJSONString(list));
			return obj;
		} finally {
			jedis.close();
		}
	}

	/**
	 * 设置字符数据
	 * @param key
	 * @param value
	 * @return
	 */
	public static void set(RedisKey.Key key, String value){
		Jedis jedis = getJedis();
		try {
			String _key = key.getKey();
			jedis.select(key.getDb());
			jedis.set(_key, value);
			int seconds = key.getSeconds();
			if(seconds > 0){
				jedis.expire(_key, seconds);
			}
		} finally {
			jedis.close();
		}
	}

	/**
	 * 设置字符数据
	 * @param key
	 * @param value
	 * @param
	 * @param
	 * @return
	 */
	public static void set(String key, String value,Integer timeout){
		Jedis jedis = getJedis();
		try {
			jedis.select(0);
			jedis.set(key, value);
			if(timeout > 0){
				jedis.expire(key, timeout);
			}
		} finally {
			jedis.close();
		}
	}

	/**
	 * 获得字符数据
	 * @param
	 * @param
	 * @return
	 */
	public static String get(RedisKey.Key key){
		Jedis jedis = getJedis();
		try {
			jedis.select(key.getDb());
			return jedis.get(key.getKey());
		} finally {
			jedis.close();
		}
	}

	/**
	 * 获得字符数据
	 * @param
	 * @param
	 * @return
	 */
	public static String get(String key){
		Jedis jedis = getJedis();
		try {
			jedis.select(0);
			return jedis.get(key);
		} finally {
			jedis.close();
		}
	}

	/**
	 * 将一个或多个值插入到列表头部
	 * @param key
	 * @param
	 * @param value
	 */
	public static void lpush(RedisKey.Key key, String... value){
		Jedis jedis = getJedis();
		try {
			jedis.select(key.getDb());
			jedis.lpush(key.getKey(), value);
		} finally {
			jedis.close();
		}
	}
	/**
	 * 获取list的长度
	 * @param key
	 */
	public static Long llen(RedisKey.Key key){
		Jedis jedis = getJedis();
		try {
			jedis.select(key.getDb());
			return jedis.llen(key.getKey());
		} finally {
			jedis.close();
		}
	}

	/**
	 * 移除并返回列表的第一个元素
	 * @param key
	 * @return
	 */
	public static String lpop(RedisKey.Key key){
		Jedis jedis = getJedis();
		try {
			jedis.select(key.getDb());
			return jedis.lpop(key.getKey());
		} finally {
			jedis.close();
		}
	}
	/**
	 * 获取list指定索引位置的元素
	 * @param key
	 * @param index
	 * @return
	 */
	public static String lindex(RedisKey.Key key, long index){
		Jedis jedis = getJedis();
		try {
			jedis.select(key.getDb());
			return jedis.lindex(key.getKey(), index);
		} finally {
			jedis.close();
		}
	}
	/**
	 * 对list进行截取
	 * @param key
	 * @param start
	 * @param end
	 * @return
	 */
	public static String ltrim(RedisKey.Key key, long start, long end){
		Jedis jedis = getJedis();
		try {
			jedis.select(key.getDb());
			return jedis.ltrim(key.getKey(), start, end);
		} finally {
			jedis.close();
		}
	}

	/**
	 * 增加指定的数字，相当于java的i+=1
	 * @param key
	 * @param value
	 * void
	 */
	public static void incrBy(RedisKey.Key key, long value){
		Jedis jedis = getJedis();
		try {
			jedis.select(key.getDb());
			jedis.incrBy(key.getKey(), value);
		} finally {
			jedis.close();
		}
	}
	
	/**
	 * 
	 * 递增数字，仅仅对数字类型的键有用，相当于Java的i++运算
	 * @param key
	 * @return
	 * long
	 */
	public static long incr(RedisKey.Key key){
		Jedis jedis = getJedis();
		try {
			jedis.select(key.getDb());
			String _key = key.getKey();
			long value = jedis.incr(_key);
			int seconds = key.getSeconds();
			if(seconds > 0){
				jedis.expire(_key, seconds);
			}
			return value;
		} finally {
			jedis.close();
		}
	}
	
	/**
	 * 
	 * 递减数字，仅仅对数字类型的键有用，相当于Java的i++运算
	 * @param key
	 * @return
	 * long
	 */
	public static long decr(RedisKey.Key key){
		Jedis jedis = getJedis();
		try {
			jedis.select(key.getDb());
			String _key = key.getKey();
			long value = jedis.decr(_key);
			int seconds = key.getSeconds();
			if(seconds > 0){
				jedis.expire(_key, seconds);
			}
			return value;
		} finally {
			jedis.close();
		}
	}
	
	/**
	 * 一次赋值多个字段
	 * @param key
	 * @param data
	 * @return      
	 * String
	 */
	public static String hmset(RedisKey.Key key, Map<String, String> data){
		Jedis jedis = getJedis();
		try {
			jedis.select(key.getDb());
			return jedis.hmset(key.getKey(), data);
		} finally {
			jedis.close();
		}
	}
	
	/**
	 * 
	 * 一次取所有字段的值
	 * @param key
	 * @return
	 * Map<String,String>
	 */
	public static Map<String, String> hgetall(RedisKey.Key key){
		Jedis jedis = getJedis();
		try {
			jedis.select(key.getDb());
			return jedis.hgetAll(key.getKey());
		} finally {
			jedis.close();
		}
	}

	/**
	 * 获取所有的field的key
	 * @param key
	 * @return
	 */
	public static Set<String> hkeys(Key key) {
		Jedis jedis = getJedis();
		try {
			jedis.select(key.getDb());
			return jedis.hkeys(key.getKey());
		} finally {
			jedis.close();
		}
	}

	/**
	 * 设置List对象
	 * @param key
	 * @param list      
	 * void
	 */
	public static void setList(RedisKey.Key key, List list){
		String data = JSONObject.toJSONString(list);
		set(key, data);
	}
	
	/**
	 * 设置Object对象
	 * @param key
	 * @param obj      
	 * void
	 */
	public static void setObject(RedisKey.Key key, Object obj){
		String data = JSONObject.toJSONString(obj);
		set(key, data);
	}

	/**
	 * 设置Object对象
	 * @param key
	 * @param obj
	 * void
	 */
	public static void setObject(String key, Object obj,Integer timeout){
        Object json = JSONObject.toJSON(obj);
        set(key, json.toString(),timeout);
	}

	/**
	 * 获得List对象
	 * @param key
	 * @param cls
	 * @return      
	 * List<T>
	 */
	public static <T> List<T> getList(RedisKey.Key key, Class<T> cls){
		String data = get(key);
		if (StrUtils.isNotBlank(data)) {
			return JSONObject.parseArray(data, cls);
		}
		return null;
	}


	/**
	 * 获得Object对象
	 * @param key
	 * @param cls
	 * @return      
	 * List<T>
	 */
	public static <T> T getObject(RedisKey.Key key, Class<T> cls){
		String data = get(key);
		if (StrUtils.isNotBlank(data)) {
			return JSONObject.parseObject(data, cls);
		}
		return null;
	}

	/**
	 * 获得Object对象
	 * @param key
	 * @param
	 * @return
	 * List<T>
	 */
	public static Object getObject(String key){
		String data =  get(key);
		if (StrUtils.isNotBlank(data)) {
			return JSONObject.parseObject(data);
		}
		return null;
	}

	/**
	 * 删除给定的一个key
	 * @param key
	 * @return
	 * long
	 */
	public static long del(RedisKey.Key key){
		Jedis jedis = getJedis();
		try {
			jedis.select(key.getDb());
			return jedis.del(key.getKey());
		} finally {
			jedis.close();
		}
	}

	/**
	 * 删除给定的一个key
	 * @param key
	 * @return
	 * long
	 */
	public static long del(String key){
		Jedis jedis = getJedis();
		try {
			jedis.select(0);
			return jedis.del(key);
		} finally {
			jedis.close();
		}
	}

	/**
	 * 删除哈希表 key 中的一个或多个指定域，不存在的域将被忽略。
	 * @param key
	 * @param fields
	 * @return      
	 * long
	 */
	public static long hdel(RedisKey.Key key, String ...fields){
		Jedis jedis = getJedis();
		try {
			jedis.select(key.getDb());
			return jedis.hdel(key.getKey(), fields);
		} finally {
			jedis.close();
		}
	}
	
	public static long getIncr(RedisKey.Key key){
		String value = get(key);
		if(StrUtils.isNotEmpty(value)){
			return Long.parseLong(value);
		}
		return 0;
	}
	
	/**
	 * 增加指定的数字，相当于java的i+=value
	 * @param key
	 * @param value
	 * void
	 */
	public static Double incrByFloat(RedisKey.Key key, double value){
		Jedis jedis = getJedis();
		try {
			jedis.select(key.getDb());
			int seconds = key.getSeconds();
			String _key = key.getKey();
			Double ret = jedis.incrByFloat(_key, value);
			if(seconds > 0){
				jedis.expire(_key, seconds);
			}
			return ret;
		} finally {
			jedis.close();
		}
	}

	/**
	 * setnx
	 * @param key
	 * @param value
	 */
	public static boolean setnx(RedisKey.Key key, String value){
		Jedis jedis = getJedis();
		try {
			String _key = key.getKey();
			jedis.select(key.getDb());
			Long setnx = jedis.setnx(_key, value);
			if(setnx > 0){
				int seconds = key.getSeconds();
				if(seconds > 0){
					jedis.expire(_key, seconds);
				}
				return true;
			}else {
				return false;
			}
		} finally {
			jedis.close();
		}
	}
	/**
	 * setnx
	 * @param key
	 * @param value
	 */
	public static String getAndSet(RedisKey.Key key, String value){
		Jedis jedis = getJedis();
		try {
			String _key = key.getKey();
			jedis.select(key.getDb());
			String getSet = jedis.getSet(_key, value);
			if(StrUtil.isNotBlank(getSet)){
				int seconds = key.getSeconds();
				if(seconds > 0){
					jedis.expire(_key, seconds);
				}
				return getSet;
			}else {
				return null;
			}
		} finally {
			jedis.close();
		}
	}

	/**
     * 获取分布式锁
     * @param keyFormat
     * @param keyValues
     * @return
     */
    public static boolean getDistributedLock(String keyFormat,String... keyValues){
    	Jedis jedis = getJedis();
        String key = format(keyFormat, keyValues);

        try {
            String value=String.valueOf(System.currentTimeMillis());
            //获取分布式锁最多可以获取GET_LOCK_NUM次，循环GET_LOCK_NUM次没有获得，则获取锁失败
            int getLockNum = 0;
            while (true && getLockNum <= GET_LOCK_NUM){
                Long getLock = jedis.setnx(key, value);
                if(getLock > 0){
                    //获取锁成功
                    logger.debug(Thread.currentThread().getName() + "  获取锁成功。");
                    return true;
                }else {
                    //获取锁失败
                	logger.debug(Thread.currentThread().getName() + "  获取锁失败。");
                    while (true){
                        Object t1Object = jedis.get(key);
                        long t1,t2 = 0;
                        if(t1Object != null){
                            t1 = Long.parseLong(t1Object.toString());
                            if(System.currentTimeMillis() - t1 > 3000){
                                //锁过期
                            	logger.debug(Thread.currentThread().getName() + "  锁过期了。");
                                Object t2Object = jedis.getSet(key, System.currentTimeMillis()+"");
                                if(t2Object != null){
                                    t2 = Long.parseLong(t2Object.toString());
                                    if(t1 == t2){
                                        //获得锁
                                    	logger.debug(Thread.currentThread().getName() + "  获取锁成功。");
                                        return true;
                                    }else {
                                        //在这之前已经有其他客户端获取锁，等待重试
                                    	logger.debug(Thread.currentThread().getName() + " 来晚了，锁被别人抢了。");
                                        try {
                                            Thread.sleep(50);
                                            getLockNum++;
                                        } catch (InterruptedException e) {
                                            e.printStackTrace();
                                        }
                                    }
                                }else {
                                    //锁被释放，可以获得锁
                                	logger.debug(Thread.currentThread().getName() + "  锁被释放，可以获取锁。");
                                	getLockNum++;
                                    break;
                                }
                            }else {
                                //锁正在有效期被其他客户端使用，等待重试
                            	logger.debug(Thread.currentThread().getName() + "  锁正在被使用，请等待。");
                                try {
                                    Thread.sleep(50);
                                    getLockNum++;
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }
                        }else {
                            //锁被释放，可以进行获取锁操作
                        	logger.debug(Thread.currentThread().getName()+"  锁被释放了，重新获取。");
                        	getLockNum++;
                            break;
                        }
                    }
                }
            }
            return false;
        }catch (Exception ex){
        	logger.error(ex.getMessage(),ex);
            return false;
        }
    }

    /**
     * 释放fenbushisuo
     * @param keyFormat
     * @param keyValues
     * @return
     */

    public static boolean releaseDistributedLock(String keyFormat,String... keyValues){
    	try{
    		Jedis jedis = getJedis();
        	String key = format(keyFormat, keyValues);
            jedis.del(key);
            logger.info(Thread.currentThread().getName() + " 分布式锁释放成功。");
            return true;
    	}catch(Exception e){
    		logger.info(Thread.currentThread().getName() + " 分布式锁释放异常 : " + e);
    		return false;
    	}
    }

    /**
     * 格式化Key
     */
    public static String format(String formatKey, String... keyValues) {
        if (keyValues == null || keyValues.length == 0) {
            return formatKey;
        }
        StringBuilder key = new StringBuilder();
        char[] chars = formatKey.toCharArray();
        int index = -1;
        boolean inmark = false;
        boolean firstinmark = false;
        for (int i = 0; i < chars.length; i++) {
            char ch = chars[i];
            if (ch == '{') {
                index++;
                inmark = true;
                firstinmark = true;
            } else if (ch == '}') {
                inmark = false;
            } else if (inmark) {
                if (firstinmark) {
                    firstinmark = false;
                    key.append(keyValues[index]);
                }
            } else {
                key.append(chars[i]);
            }
        }
        return key.toString();
    }
}
