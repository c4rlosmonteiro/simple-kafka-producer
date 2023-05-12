package com.github.carlosmonteiro.kafka.producer;

import io.confluent.kafka.serializers.AbstractKafkaSchemaSerDeConfig;
import io.confluent.kafka.serializers.KafkaAvroSerializer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Map;

/**
 * @author Carlos Monteiro
 */
public final class KafkaConfigurationProperties {

    public static final String SERVERS_CONFIG_URL = "http://localhost:9092";
    public static final String SCHEMA_REGISTRY_URL = "http://localhost:8081";

    private KafkaConfigurationProperties() {
    }

    public static Map<String, Object> getConfigProps() {
        return Map.of(
                ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, SERVERS_CONFIG_URL,
                ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class,
                ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, KafkaAvroSerializer.class.getName(),
                AbstractKafkaSchemaSerDeConfig.SCHEMA_REGISTRY_URL_CONFIG, SCHEMA_REGISTRY_URL
        );
    }
}
