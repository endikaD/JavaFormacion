package net.techtter.springkafkadocker.springkafkadockerint;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaController {

    private final net.techtter.springkafkadocker.springkafkadockerint.KafkaProducer producer;

    public KafkaController(KafkaProducer producer) {
        this.producer = producer;
    }

    @PostMapping("/publicar")
    public void writeMessageToTopic(@RequestParam("message") String message){
        this.producer.escribirMensaje(message);

    }

}


