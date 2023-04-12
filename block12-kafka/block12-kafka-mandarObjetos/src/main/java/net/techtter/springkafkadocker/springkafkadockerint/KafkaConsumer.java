package net.techtter.springkafkadocker.springkafkadockerint;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    @KafkaListener(topics="my_topic", groupId="my_group_id")
    public void obtenerMensaje(Persona persona){

        System.out.println(persona);

    }
}
