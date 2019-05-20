package cn.enjoyedu.selfserial;

import cn.enjoyedu.config.BusiConst;
import cn.enjoyedu.vo.DemoUser;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.util.Collections;

/**
 * @author marvin
 * <p>
 * 类说明：
 */
public class SelfSerialConsumer {

    private static KafkaConsumer<String, DemoUser> consumer = null;

    public static void main(String[] args) {

        /*消息消费者*/
        //TODO
        try {
            consumer.subscribe(Collections.singletonList(BusiConst.SELF_SERIAL_TOPIC));
            while (true) {
                ConsumerRecords<String, DemoUser> records
                        = consumer.poll(500);
                for (ConsumerRecord<String, DemoUser> record : records) {
                    System.out.println(String.format(
                            "主题：%s，分区：%d，偏移量：%d，key：%s，value：%s",
                            record.topic(), record.partition(), record.offset(),
                            record.key(), record.value()));
                    //do our work
                }
            }
        } finally {
            consumer.close();
        }
    }


}
