package xyz.adrianweb.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import xyz.adrianweb.domain.User;

@Repository
public interface UserRepository extends ReactiveMongoRepository<User,String> {
  Mono<User> findById(Long id);
  Flux<User> findAllByUserName(String userName);
}
