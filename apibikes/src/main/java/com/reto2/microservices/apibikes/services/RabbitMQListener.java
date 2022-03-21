package com.reto2.microservices.apibikes.services;
import com.reto2.microservices.apibikes.dto.EndReservationDTO;
import com.reto2.microservices.apibikes.dto.ReservationDTO;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class RabbitMQListener{

    public static final String QUEUE = "${reto2.microservices.apireservations.rabbitmq.queue}";
    private final BikesService bikesService;

     
    @RabbitListener(queues = QUEUE)
    public void listener(ReservationDTO message) {
        System.out.println(message);
        System.out.println("create");
        bikesService.updateState(message.getBikeId(), false);
    }

    @RabbitListener(queues = QUEUE)
    public void listenerEnd(EndReservationDTO message) {
        System.out.println(message);
        System.out.println("End");
        bikesService.updateState(message.getBikeId(), true);
    }
}
