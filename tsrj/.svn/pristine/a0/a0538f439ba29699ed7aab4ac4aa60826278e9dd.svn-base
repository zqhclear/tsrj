package org.tsrj.service.event;

import java.util.Iterator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lmax.disruptor.EventHandler;


public class OperateEventHandler implements EventHandler<OperateEvent> {

	private Logger LOG = LoggerFactory.getLogger(OperateEventHandler.class);

	@Override
	public void onEvent(OperateEvent event, long sequence, boolean endOfBatch)
			throws Exception {

		Iterator<EventFunction<Event>> efIter = EventFunctionRegisger
				.interatorEventFunction(event);
		while (efIter.hasNext()) {
			EventFunction<Event> ef = efIter.next();
			try {
				ef.invoke(event);
			} catch (Exception e) {
				LOG.error(e.getMessage(), e);
			}
		}
	}

}
