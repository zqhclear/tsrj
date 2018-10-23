package org.tsrj.service.event;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.IteratorUtils;


public class EventFunctionMemorizer<E extends Event> {
	Map<Integer, List<EventFunction<E>>> memrizer = new HashMap<Integer, List<EventFunction<E>>>();
	
	public void register(Integer type, EventFunction<E> ef){
		List<EventFunction<E>> list = memrizer.get(type);
		if(list ==null){
			list = new ArrayList<>();
			memrizer.put(type, list);
		}
		list.add(ef);
	}
	
	
	@SuppressWarnings("unchecked")
	public Iterator<EventFunction<E>> interatorEventFunction(Integer type){
		List<EventFunction<E>> list = memrizer.get(type);
		if(list==null){
			return IteratorUtils.EMPTY_LIST_ITERATOR;
		}
		return list.iterator();
	}
}
