package cn.enjoyedu.selfserial;

import cn.enjoyedu.config.BusiConst;
import cn.enjoyedu.vo.DemoUser;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

/**
 * @author marvin
 * <p>
 * 类说明：发送消息--未来某个时候get发送结果
 */
public class SelfSerialProducer {

    private static KafkaProducer<String, DemoUser> producer = null;

    public static void main(String[] args) {

        /*消息生产者*/
        //TODO
        try {
            /*待发送的消息实例*/
            ProducerRecord<String, DemoUser> record;
            try {

                record = new ProducerRecord<String, DemoUser>(
                        BusiConst.SELF_SERIAL_TOPIC, "user01",
                        new DemoUser(1, "mark"));
                producer.send(record);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } finally {
            producer.close();
        }
    }


}
