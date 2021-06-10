package com.hotel.APIGateway;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@CrossOrigin
public class FallbackController {

    @RequestMapping("/masterFallBack")
    public Mono<String> masterServiceFallBack() {
        return Mono.just("Master Service is taking too long to respond or is down. Please try again later");
    }
    @RequestMapping("/bookingFallBack")
    public Mono<String> bookingServiceFallBack() {
        return Mono.just("Booking Service is taking too long to respond or is down. Please try again later");
    }
  
}