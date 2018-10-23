package org.tsrj.common.mqutil;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.rocketmq.client.log.ClientLogger;
import com.aliyun.openservices.ons.api.Message;
import com.aliyun.openservices.ons.api.transaction.LocalTransactionChecker;
import com.aliyun.openservices.ons.api.transaction.TransactionStatus;


/**
 *Description:  MQ 发送事务消息本地Check接口实现类
 *Program: mq
 *Date:2017.2.23
 *@author zhognqionghua
 *@version 
 * */
//@Component
public class LocalTransactionCheckerImpl implements LocalTransactionChecker {
	private final static Logger log = ClientLogger.getLog();
	//本地业务实现类
	@Autowired
	AbstractBusinessService businessService;
	//BusinessServiceImpl businessService = new BusinessServiceImpl();
	@Override
	public TransactionStatus check(Message message) {
		
		String msgId = message.getMsgID();
		//消息体使用md5来防止重复消息.
		byte[] msg = message.getBody();
		MD5.getInstance().getMD5String(new String(msg));
		TransactionStatus transactionStatus = TransactionStatus.Unknow;
        try {
			//查询本地事务执行状态
			Boolean isCommit = businessService.checkStatus();
			if (isCommit) {
				//本地事务已成功、提交消息
				System.out.println("回查本地事务,成功");
				transactionStatus = TransactionStatus.CommitTransaction;
			} else {
			//本地事务已失败、回滚消息
			transactionStatus = TransactionStatus.RollbackTransaction;
			}
		} catch (Exception e) {
			log.error("Message Id:{}", msgId, e);
		}
        log.warn("Message Id:{}transactionStatus:{}", msgId, transactionStatus.name());
		return transactionStatus;
	}	   
}
