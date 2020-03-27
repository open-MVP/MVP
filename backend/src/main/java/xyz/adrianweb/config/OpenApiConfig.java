package xyz.adrianweb.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

  @Bean
  public OpenAPI customOpenAPI(@Value("${app.version}") String appVersion) {
    return new OpenAPI()
            .components(new Components().addSecuritySchemes("basicScheme",
                    new SecurityScheme().type(SecurityScheme.Type.HTTP).scheme("basic")))
            .info(new Info().title("OPEN MVP API").version(appVersion)
                    .license(new License().name("Apache 2.0").url("https://github.com/open-MVP/MVP")));
  }

  @Bean
  public GroupedOpenApi modelOpenApi() {
    String[] paths = {"/**"};
    String[] packagedToMatch = {"xyz.adrianweb.domain"};
    return GroupedOpenApi.builder()
            .setGroup("Backend API")
            .pathsToMatch(paths)
            .packagesToScan(packagedToMatch)
            .build();
  }
}
