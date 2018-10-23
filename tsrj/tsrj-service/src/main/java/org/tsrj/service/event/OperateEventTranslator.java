package org.tsrj.service.event;

import com.lmax.disruptor.EventTranslator;

public class OperateEventTranslator implements EventTranslator<OperateEvent>{

	
	private OperateEvent operateEvent;
	
	OperateEventTranslator(OperateEvent operateEvent){
		this.operateEvent = operateEvent;
	}
	
	
	@Override
	public void translateTo(OperateEvent event, long sequence) {
		if(operateEvent!=null){
			event.setMemberId(operateEvent.getMemberId());
			event.setOperateArg(operateEvent.getOperateArg());
			event.setOperateId(operateEvent.getOperateId());
			event.setType(operateEvent.getType());
		}
	}

}
