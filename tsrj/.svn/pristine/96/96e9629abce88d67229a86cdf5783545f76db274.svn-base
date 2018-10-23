package org.tsrj.common.redis;

import org.tsrj.common.utils.StrUtils;

/**
 * Redis Key
 * @author xiaohaizi
 * @date   2017年3月10日 上午10:51:21
 */
public class RedisKey {

	/**
	 * 用户库
	 */
	private static final int MEMBER_DB = 0;

	
	public enum Key {
		/** 系统配置参数 */
		SYS_CONFIG("sys:config", MEMBER_DB),
		MEMBER_INCR("m:incr", MEMBER_DB),
		MEMBER_HMSET("m:hmset", MEMBER_DB),
		/**
		 * 微信
		 */
		WECHAT_BIND_REWARD("wechat:bind:prompt:", MEMBER_DB),
		/**
		 * request的token化
		 */
		TOKENIZE_REQUEST("tokenize:request", MEMBER_DB);
		
		private String key;
		
		private int db;
		
		private ThreadLocal<Integer> secondsLocal = new ThreadLocal<Integer>(){
			protected Integer initialValue() {
				return new Integer(0);
			};
		};
		
		private ThreadLocal<StringBuilder> appendLocal = new ThreadLocal<StringBuilder>(){
			protected StringBuilder initialValue() {
				return new StringBuilder();
			};
		};

		Key(String key, int db) {
			this.key = key;
			this.db = db;
		}

		public String getKey() {
			if(StrUtils.isNotBlank(appendLocal.get().toString())){
				String dynKey = key+appendLocal.get().toString();
				appendLocal.get().setLength(0);
				return dynKey;
			}
			return key;
		}
		
		/**
		 * 此方法注意：
		 *   请勿重复append，比如key.append();key.append();
		 * 正确用法：
		 *   1.key.append(":a:b:c");
		 *   2.key.append(":a").append(":b").append(":c"); 推荐使用该方法  
		 * @param key
		 * @return      
		 * StringBuilder
		 */
		public StringBuilder append(String key){
			return appendLocal.get().append(key);
		}

		public void setKey(String key) {
			this.key = key;
		}

		public int getDb() {
			return db;
		}

		public void setDb(int db) {
			this.db = db;
		}
		
		public int getSeconds() {
			int _seconds = this.secondsLocal.get();
			if(_seconds > 0){
				this.secondsLocal.set(0);
			}
			return _seconds;
		}

		public void setSeconds(int seconds) {
			this.secondsLocal.set(seconds);
		}
	}

}
