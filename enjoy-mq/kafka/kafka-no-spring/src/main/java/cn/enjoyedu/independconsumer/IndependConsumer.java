package cn.enjoyedu.independconsumer;

import cn.enjoyedu.config.KafkaConst;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.util.Properties;

/**
 * @author marvin
 * <p>
 * 类说明：
 */
public class IndependConsumer {

    private static KafkaConsumer<String, String> consumer = null;
    public static final String SINGLE_CONSUMER_TOPIC = "single-consumer";

    public static void main(String[] args) {
        Properties properties = new Properties();
        properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,
                KafkaConst.LOCAL_BROKER);
        properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,
                StringDeserializer.class.getName());
        properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,
                StringDeserializer.class.getName());

        /*独立消息消费者*/
        //TODO
        try {

            while (true) {
                ConsumerRecords<String, String> records
                        = consumer.poll(1000);
                for (ConsumerRecord<String, String> record : records) {
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
