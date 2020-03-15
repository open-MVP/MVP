package xyz.adrianweb.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("api/")
public class HealthCheckController {

  @GetMapping("healthCheck")
  Mono<String> healthCheck(){
    return Mono.just("UP");
  }

}
