package org.tsrj.common.mqutil;
import com.aliyun.openservices.ons.api.Message;

/**
 *Description:本地业务Service
 *Program: mq
 *Date:2017.2.15
 *@author zhognqionghua
 *@version 
 * */
public abstract class AbstractBusinessService {
	private Boolean flag=false;
	/**
	 * 检查本事务是否执行成功
	 * @author fengli
	 * @return Boolean true:本地业务成功   false：本地业务失败
	 * */
	public Boolean checkStatus() {
		
		return flag;
	}
	/**
	 * 执行本地业务
	 * @author fengli
	 * @param message 
	 * @return Boolean true:本地业务成功   false：本地业务失败
	 * */
	public Boolean execute(Message message) {
		try{	
			//执行本地事务
			serviceExt(message);
			//修改标记
			flag=true;	
			return flag;
		}catch(Exception e){
			e.printStackTrace();
		}
		return flag;
	}
	public abstract void serviceExt(Message message);
}
