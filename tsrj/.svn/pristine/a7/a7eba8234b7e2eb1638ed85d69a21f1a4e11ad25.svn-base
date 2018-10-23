package org.tsrj.service.event.function;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.tsrj.service.event.EventFunction;
import org.tsrj.service.event.OperateEvent;

@Component
public class MemberRegisterFunction implements EventFunction<OperateEvent> {
	
	private static Logger logger = LoggerFactory.getLogger(MemberRegisterFunction.class);
	
	@Override
	public void invoke(OperateEvent e) throws Exception {
		logger.info("用户注册事件执行");
	}

}
