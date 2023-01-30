package com.java_kafka;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

public class Consumer_2 {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        Properties props = new Properties();

        props.put("bootstrap.servers", "10.8.128.121:9092");
        props.put(ConsumerConfig.GROUP_ID_CONFIG, "data_consumer");
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");

        KafkaConsumer<String,String> consumer = new KafkaConsumer<String, String>(props);

        consumer.subscribe(Arrays.asList("test4"));
        System.out.println("Consumer Hazır");

        while(true){
            ConsumerRecords<String,String> records = consumer.poll(Duration.ofMillis(100));
            for(ConsumerRecord<String,String> record:records){
                System.out.printf("offset = %d,  key = %s, value = %s\n",record.offset(), record.key(), record.value());
            }
        }



    }
}
