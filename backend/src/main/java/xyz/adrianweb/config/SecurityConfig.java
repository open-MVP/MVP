package xyz.adrianweb.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;
import reactor.core.publisher.Mono;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SecurityConfig {

//  @Autowired
//  private AuthenticationManager authenticationManager;
//
//  @Autowired
//  private SecurityContextRepository securityContextRepository;

  @Bean
  SecurityWebFilterChain configure(ServerHttpSecurity http) {
    String[] patterns = new String[]{"/auth/**", "/documentation.html", "/webjars/swagger-ui/**", "/v3/api-docs/**"};
    return http
            .cors().disable()
            .exceptionHandling()
            .authenticationEntryPoint((swe, e) -> Mono.fromRunnable(() -> {
              swe.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
            })).accessDeniedHandler((swe, e) -> Mono.fromRunnable(() -> {
              swe.getResponse().setStatusCode(HttpStatus.FORBIDDEN);
            }))
            .and()
            .csrf().disable()
//            .authenticationManager(authenticationManager)
//            .securityContextRepository(securityContextRepository)
            .oauth2Login(withDefaults())
            .oauth2Client(withDefaults())
            .authorizeExchange()
            .pathMatchers(patterns).permitAll()
            .pathMatchers(HttpMethod.OPTIONS).permitAll()
            .anyExchange().authenticated()
            .and()
            .build();
  }
}
