package com.example.electro.listener;

import com.example.electro.entity.Appliance;
import com.example.electro.repository.ApplianceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Service
public class KafkaConsumer {

    @Autowired
    private ApplianceRepo applianceRepo;

    @KafkaListener(topics = "heartbeat_topic")
    public void consume(String message) {
        System.out.println("Consumed message: " + message);
        String[] split = message.split(",");
        try {
            applianceRepo.updateLastOnline(Timestamp.valueOf(LocalDateTime.parse(split[1])),split[0]);
        } catch (Exception | Error e) {
            System.out.println(e);
        }
    }

}
