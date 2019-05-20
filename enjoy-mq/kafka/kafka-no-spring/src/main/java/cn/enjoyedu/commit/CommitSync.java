package cn.enjoyedu.commit;

import cn.enjoyedu.config.BusiConst;
import cn.enjoyedu.config.KafkaConst;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.util.Collections;
import java.util.Properties;

/**
 * @author marvin
 * <p>
 * 类说明：手动提交当偏移量，生产者使用KafkaConProducer
 */
public class CommitSync {

    public static void main(String[] args) {
        /*消息消费者*/
        Properties properties = KafkaConst.consumerConfig("CommitSync",
                StringDeserializer.class,
                StringDeserializer.class);
        /*取消自动提交*/
        //TODO

        KafkaConsumer<String, String> consumer
                = new KafkaConsumer<String, String>(properties);
        try {
            consumer.subscribe(Collections.singletonList(
                    BusiConst.CONSUMER_COMMIT_TOPIC));
            while (true) {
                ConsumerRecords<String, String> records
                        = consumer.poll(500);
                for (ConsumerRecord<String, String> record : records) {
                    System.out.println(String.format(
                            "主题：%s，分区：%d，偏移量：%d，key：%s，value：%s",
                            record.topic(), record.partition(), record.offset(),
                            record.key(), record.value()));
                    //do our work
                }
                //TODO
            }
        } finally {
            consumer.close();
        }
    }
}
