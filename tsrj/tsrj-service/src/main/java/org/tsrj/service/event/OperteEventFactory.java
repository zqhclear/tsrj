package org.tsrj.service.event;

import com.lmax.disruptor.EventFactory;

public class OperteEventFactory implements EventFactory<OperateEvent> {

	@Override
	public OperateEvent newInstance() {
		
		return new OperateEvent();
	}

}
