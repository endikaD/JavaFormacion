package net.techtter.springkafkadocker.springkafkadockerint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {

    private static final String TOPIC= "my_topic";

    @Autowired
    private KafkaTemplate<String, Persona> kafkaTemplate;

    public void escribirMensaje(Persona persona){

        this.kafkaTemplate.send(TOPIC, persona);
    }

}
