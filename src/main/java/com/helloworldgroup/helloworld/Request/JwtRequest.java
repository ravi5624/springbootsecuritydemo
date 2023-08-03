package com.helloworldgroup.helloworld.Request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class JwtRequest {

    public String email;
    public String password;

}
