package org.tsrj.service.mq.impl;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;
import org.tsrj.common.domain.ResultBody;
import org.tsrj.service.mq.RabbitMQService;
import org.tsrj.service.mq.model.RabbitMessage;

public class RabbitMQserviceImpl implements RabbitMQService {

	private static final Logger LOG = LoggerFactory.getLogger(RabbitMQserviceImpl.class);
    @Resource
    private RabbitTemplate rabbitTemplate;

    @Override
    public ResultBody sendMessage(RabbitMessage msg) {
        ResultBody result = new ResultBody<>();
        try {
            System.out.println(rabbitTemplate.getConnectionFactory().getHost());
            System.out.println(rabbitTemplate.getConnectionFactory().getPort());
            //发送信息
            rabbitTemplate.convertAndSend(msg.getExchange(), msg.getRouteKey(), msg);
            return result;
        } catch (Exception e) {
        	LOG.error("rabbit发送失败,原因：", e);
        	e.printStackTrace();
        }
        result.setData("发送失败，请稍后重试。");
        return result;
    }

    @Override
    public ResultBody consumeMessage(RabbitMessage message) {
        /*byte[] body = message.getBody();
        System.out.println("receive msg : " + new String(body));
        channel.basicAck(message.getMessageProperties().getDeliveryTag(), false); //确认消息成功消费*/
        return null;
    }
}
