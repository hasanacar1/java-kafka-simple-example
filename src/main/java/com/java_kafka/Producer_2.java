package com.java_kafka;

import java.util.Properties;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

public class Producer_2 {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        Properties props = new Properties();

        props.put("bootstrap.servers", "10.8.128.121:9092");
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        Producer<String,String> producer = new KafkaProducer<>(props);
        for (int i = 0; i < 5; i++) {
        producer.send(new ProducerRecord<String,String>("test4", "hasan", "hasan acar 1234"));
        }
        producer.close();


    }
}
