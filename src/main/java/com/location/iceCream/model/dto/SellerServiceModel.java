package com.location.iceCream.model.dto;

import com.location.iceCream.config.Role;
import lombok.Data;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;
@Data
public class SellerServiceModel {
    private Long id;
    @NotEmpty
    @Email(message = "Email should be valid")
    private String email;
    @NotEmpty
    @Size(min = 4, max = 10, message
            = "Password must be between 4 and 10 characters")
    private String password;
    private boolean active;
    @NotEmpty
    @Size(min = 5, max = 50, message
            = "About Me must be between 5 and 50 characters")
    private String username;
    private Role role;
    private String address;
    private List<IceCreamServiceModel> iceCreamList;

}
