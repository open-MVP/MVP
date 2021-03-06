package xyz.adrianweb.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
public class User {

  private Long id;
  @NotNull
  @NotEmpty
  private String userName;
  @NotNull
  @NotEmpty
  @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
  @Email
  private String email;
  @NotNull
  @NotEmpty
  @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
  private String password;
}
