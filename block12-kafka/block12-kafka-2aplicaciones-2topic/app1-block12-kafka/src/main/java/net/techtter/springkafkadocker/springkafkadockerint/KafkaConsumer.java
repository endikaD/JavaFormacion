package net.techtter.springkafkadocker.springkafkadockerint;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    @KafkaListener(topics="myTopic", groupId="my_group_id2")
    public void obtenerMensaje(String message){

        System.out.println(message);

    }
}
