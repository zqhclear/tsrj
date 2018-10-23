package org.tsrj.service;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;

/**
 * 
 * @author yusong
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration(locations = {"classpath:/test-spring-mybatis.xml"}) //初始化mybatis相关配置
/*@ContextConfiguration(locations = {"classpath:/spring-mq.xml","classpath:/spring-mybatis.xml"}) //初始化mq,mybatis相关配置*/
@Rollback(false)
public class BaseTestInit extends AbstractTransactionalJUnit4SpringContextTests{
	@Before
	public void myInit(){
		
	}
	
	public void logTest(Object obj){
		logger.debug("测试输出 开始===================");
		logger.debug(JSON.toJSONString(obj));
		logger.debug("测试输出 结束===================");
	}
}
