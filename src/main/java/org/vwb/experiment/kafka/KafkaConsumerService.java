package org.vwb.experiment.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.listener.ContainerProperties;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {
    private String consumerId;
    @KafkaListener(topics = "vwb-experiment-test-final", groupId = "single_consumer_group")
    public void consumeMessage(ConsumerRecord<String, String> record) {
        String message = record.value();
        int partition = record.partition();
        long offset = record.offset();
        String key = record.key();
        System.out.println("Received message: " + message);
        System.out.println("Partition: " + partition);
        System.out.println("Offset: " + offset);
        System.out.println("key uerId: " + key);
    }
}