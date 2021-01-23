package com.location.iceCream.model.binding;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

@Data
public class BindingUserDto {
    @Email(message = "Email should be valid")
    private String email;
    @Size(min = 4, max = 10, message
            = "Password must be between 4 and 10 characters")
    private String password;
    private String confirmPassword;
    @Size(min = 2, max = 20, message =
            "Username must be between 2 and 20 characters")
    private String username;
    private String address;
}
