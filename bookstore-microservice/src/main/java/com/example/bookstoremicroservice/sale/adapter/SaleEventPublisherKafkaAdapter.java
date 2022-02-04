package com.example.bookstoremicroservice.sale.adapter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.example.sale.application.business.events.SaleEvent;
import com.example.sale.infrastructure.SaleEventPublisher;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

// ACL: Anti Corruption Layer
@Service
public class SaleEventPublisherKafkaAdapter implements SaleEventPublisher<SaleEvent> {

    private static final Logger logger =
            LoggerFactory.getLogger(SaleEventPublisherKafkaAdapter.class);
    @Value("${bookstore.events.topic}")
    private String topicName;

    private final KafkaTemplate<String, String> kafkaTemplate;
    private final ObjectMapper mapper;

    public SaleEventPublisherKafkaAdapter(KafkaTemplate<String, String> kafkaTemplate, ObjectMapper mapper) {
        this.kafkaTemplate = kafkaTemplate;
        this.mapper = mapper;
    }

    @Override
    public void publishEvent(SaleEvent businessEvent) {
        try {
            var eventAsJson = mapper.writeValueAsString(businessEvent);
            kafkaTemplate.send(topicName, eventAsJson);
        } catch (JsonProcessingException e) {
            logger.error("Error while converting the event to json: {}",
                    e.getMessage());
        }
    }

}
