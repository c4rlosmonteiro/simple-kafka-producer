package com.github.carlosmonteiro.kafka.producer;

import org.apache.avro.specific.SpecificRecordBase;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;

/**
 * @author Carlos Monteiro
 */
public class KafkaMessageProducer<K, V extends SpecificRecordBase> {
    private final KafkaTemplate<K, V> kafkaTemplate;

    public KafkaMessageProducer() {
        final var producerFactory = new DefaultKafkaProducerFactory<K, V>(KafkaConfigurationProperties.getConfigProps());
        this.kafkaTemplate = new KafkaTemplate<>(producerFactory);
    }

    public void send(final ProducerRecord<K, V> record) {
        kafkaTemplate.send(record);
    }
}
