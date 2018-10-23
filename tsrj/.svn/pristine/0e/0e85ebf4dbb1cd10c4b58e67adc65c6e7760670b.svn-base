package org.tsrj.service;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;
import org.tsrj.service.mq.RabbitMQService;
import org.tsrj.service.mq.model.RabbitMessage;

public class RabbitMQTest extends BaseTestInit {

    @Resource
    private RabbitMQService rabbitMQService;

    @Test
    public void testOne(){
        String message = "this is a first queue";
        String exchange="testExchange";////交换器
        String routeKey="testQueue";//队列
        String methodName="test";//调用的方法
        /* 参数 */
        Map<String,Object> param=new HashMap<String, Object>();
        param.put("data", message);

        RabbitMessage msg=new RabbitMessage(exchange,routeKey, methodName, param);
        rabbitMQService.sendMessage(msg);
    }
}
