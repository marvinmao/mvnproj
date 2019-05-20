package cn.enjoyedu.topic;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author marvin
 * <p>
 * 类说明：
 */
@Component
@RabbitListener(queues = "sb.info.user")
public class TopicUserMessageReceiver {

    @RabbitHandler
    public void process(String msg) {
        System.out.println("TopicUserMessageReceiver  : " + msg);
    }

}