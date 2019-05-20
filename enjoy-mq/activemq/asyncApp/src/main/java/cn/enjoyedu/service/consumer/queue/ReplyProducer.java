package cn.enjoyedu.service.consumer.queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

/**
 * @author marvin
 * <p>
 *
 * <p>
 * 类说明：消费者端负责应答部分
 */
@Service
public class ReplyProducer {

    @Autowired
    @Qualifier("jmsQueueTemplate")
    private JmsTemplate jmsQueueTemplate;

    public void send(final String consumerMsg, Message produerMessage)
            throws JMSException {

        jmsQueueTemplate.send(produerMessage.getJMSReplyTo(), new MessageCreator() {
            public Message createMessage(Session session) throws JMSException {
                Message msg = session.createTextMessage("ProcessSms already "
                        + "accept msg[ " + consumerMsg + "]");
                return msg;
            }
        });

    }

}
