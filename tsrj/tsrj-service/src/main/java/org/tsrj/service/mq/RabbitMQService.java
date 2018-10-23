package org.tsrj.service.mq;

import org.tsrj.common.domain.ResultBody;
import org.tsrj.service.mq.model.RabbitMessage;

public interface RabbitMQService {

    public ResultBody sendMessage(RabbitMessage message);

    public ResultBody consumeMessage(RabbitMessage message);
}
