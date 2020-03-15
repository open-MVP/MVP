package xyz.adrianweb.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;
import xyz.adrianweb.domain.User;
import xyz.adrianweb.domain.UserDTO;
import xyz.adrianweb.repository.UserRepository;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Slf4j
@Validated
@RestController
@RequestMapping(path="api/user", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

  private final UserRepository userRepository;

  public UserController(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @GetMapping("/{userId}")
  Mono<User> getById(@PathVariable @NotBlank @Size(min = 1) Long userId) {
    return userRepository.findById(userId);
  }

  @PostMapping("/register")
  Mono<User> createUser(@Valid UserDTO userDTO) {
    User user = new User();
    user.setEmail(userDTO.getEmail());
    return userRepository.save(user);
  }
}
