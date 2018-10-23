package org.tsrj.service.event;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Component;
import com.lmax.disruptor.EventFactory;
import com.lmax.disruptor.EventHandler;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.util.DaemonThreadFactory;

@Component
public class EventService {

	private Disruptor<OperateEvent> disruptor;
	private ThreadLocal<List<OperateEvent>> sequenceList = null;

	@SuppressWarnings({ "unchecked" })
	@PostConstruct
	protected void init() {
		sequenceList = new ThreadLocal<List<OperateEvent>>(){
			protected List<OperateEvent> initialValue() {
				return new ArrayList<>();
			};
		};
		EventFactory<OperateEvent> eventFactory = new OperteEventFactory();
		//executor = Executors.newSingleThreadExecutor();
		int ringBufferSize = 8 * 1024; // RingBuffer 大小，必须是 2 的 N 次方；

		disruptor = new Disruptor<OperateEvent>(eventFactory, ringBufferSize,
				DaemonThreadFactory.INSTANCE);
		EventHandler<OperateEvent> eventHandler = new OperateEventHandler();
		disruptor.handleEventsWith(eventHandler);
		disruptor.start();
	}
	
	
	
	/**
	 * 发布操作事件广播 <br />
	 * 将事件添加到线程内缓存起来,当这个web action执行完成后,再调用{@code #publishOperateEvent()}执行发布事件的操作
	 * @param et
	 * @param memberId
	 * @param operateId
	 * @param operateObj
	 */
	public <T> void publishOperateEvent(EventType et, Long memberId, String operateId, T operateObj) {
		OperateEvent event = new OperateEvent();//获取该序号对应的事件对象；
		event.setType(et.getType());
		event.setMemberId(memberId);
		event.setOperateArg(operateObj);
		event.setOperateId(operateId);
		sequenceList.get().add(event);
		//ringBuffer.publish(sequence);//发布事件；
		//publishCurrentThreadOperateEvent();
	}
	
	
	/**
	 * 发布当前各种内的事件发布动作
	 */
	public void publishCurrentThreadOperateEvent(){
		Iterator<OperateEvent> iter =  sequenceList.get().iterator();
		RingBuffer<OperateEvent> ringBuffer = disruptor.getRingBuffer();
		while(iter.hasNext()){
			OperateEvent event = iter.next();
			ringBuffer.publishEvent(new OperateEventTranslator(event));
			System.out.println("==========================事件触发============================");
		}
		sequenceList.remove();
	}
	

	@PreDestroy
	protected void destory() {
		if (disruptor != null) {
			disruptor.shutdown();// 关闭 disruptor，方法会堵塞，直至所有的事件都得到处理；
			//executor.shutdown();// 关闭 disruptor 使用的线程池；如果需要的话，必须手动关闭， disruptor
			// 在 shutdown 时不会自动关闭；
			disruptor = null;
		}
	}
}
