package cn.enjoyedu.dlq;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.RedeliveryPolicy;
import org.apache.activemq.broker.region.policy.RedeliveryPolicyMap;
import org.apache.activemq.command.ActiveMQDestination;

import javax.jms.*;

/**
 * @author marvin
 * <p>
 * 类说明：
 */
public class DlqConsumer {

    private static final String USERNAME
            = ActiveMQConnection.DEFAULT_USER;//默认连接用户名
    private static final String PASSWORD
            = ActiveMQConnection.DEFAULT_PASSWORD;//默认连接密码
    private static final String BROKEURL
            = ActiveMQConnection.DEFAULT_BROKER_URL;//默认连接地址

    public static void main(String[] args) {
        ActiveMQConnectionFactory connectionFactory;
        ActiveMQConnection connection = null;
        Connection jmsConnection;
        Session session;
        ActiveMQDestination destination;

        MessageConsumer messageConsumer;//消息的消费者

        //实例化连接工厂
        connectionFactory
                = new ActiveMQConnectionFactory(USERNAME, PASSWORD, BROKEURL);
        RedeliveryPolicy queuePolicy = new RedeliveryPolicy();
        queuePolicy.setMaximumRedeliveries(1);

        try {
            //通过连接工厂获取连接
            connection = (ActiveMQConnection) connectionFactory.createConnection();
            //启动连接
            connection.start();
            RedeliveryPolicyMap map = connection.getRedeliveryPolicyMap();

            //创建session
            session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            //创建一个连接HelloWorld的消息队列
            //destination = session.createTopic("TestDlq");
            destination = (ActiveMQDestination) session.createQueue("TestDlq2");
            map.put(destination, queuePolicy);
            //创建消息消费者
            messageConsumer = session.createConsumer(destination);
            messageConsumer.setMessageListener(new MessageListener() {
                public void onMessage(Message message) {
                    try {
                        System.out.println("Accept msg : "
                                + ((TextMessage) message).getText());
                    } catch (JMSException e) {
                        e.printStackTrace();
                    }
                    throw new RuntimeException("测试DLQ抛出异常");
                }
            });


        } catch (JMSException e) {
            e.printStackTrace();
        }

    }
}
