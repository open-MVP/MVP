package xyz.adrianweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;
import xyz.adrianweb.domain.User;
import xyz.adrianweb.repository.UserRepository;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@RestController
@RequestMapping("api/user")
public class UserController {

  @Autowired
  private UserRepository userRepository;

  @GetMapping("/{userId}")
  Mono<User> getById(@PathVariable @NotBlank @Size(min = 1) Long userId){
    return userRepository.findById(userId);
  }
}
