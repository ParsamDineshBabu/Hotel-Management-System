package com.hotel.APIGateway;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;


@RestController
@CrossOrigin
public class GatewayController {

	@RequestMapping("/masterdown")
	public Mono<String> masterServiceFallBack() {
		return Mono.just("Master Service is taking too long to respond or is down. Please try again later");
	}
	@RequestMapping("/bookingdown")
	public Mono<String> bookingServiceFallBack() {
		return Mono.just("Booking Service is taking too long to respond or is down. Please try again later");
	}
	@RequestMapping("/rolesdown")
	public Mono<String> rolesServiceFallBack() {
		return Mono.just("Roles Service is taking too long to respond or is down. Please try again later");
	}
	@RequestMapping("/authdown")
	public Mono<String> authServiceFallBack() {
		return Mono.just("Auth Service is taking too long to respond or is down. Please try again later");
	}


}