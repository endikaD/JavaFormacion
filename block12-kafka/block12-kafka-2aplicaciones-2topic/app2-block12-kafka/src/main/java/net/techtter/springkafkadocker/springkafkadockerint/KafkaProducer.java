package net.techtter.springkafkadocker.springkafkadockerint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {

    private static final String TOPIC= "myTopic";

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void escribirMensaje(String msg){

        this.kafkaTemplate.send(TOPIC, msg);
    }

}
