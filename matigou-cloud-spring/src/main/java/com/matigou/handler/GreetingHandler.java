package com.matigou.handler;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.concurrent.atomic.AtomicLong;

@Component
public class GreetingHandler {
    private final AtomicLong counter = new AtomicLong();

    public Mono<ServerResponse> hello(ServerRequest request) {
         return ServerResponse.ok().contentType(MediaType.TEXT_PLAIN)
                 .body(BodyInserters.fromObject("Hello World!"));
     }
}
