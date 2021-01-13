package com.location.iceCream.model;

import com.location.iceCream.config.Role;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;
@Data
@Entity
public class Seller {
    @Id
    @SequenceGenerator(name = "seq_user", allocationSize = 1)
    @GeneratedValue(generator = "seq_user",strategy = GenerationType.SEQUENCE)
    private Long id;
    @Email
    @NotEmpty
    private String email;
    @NotEmpty(message = "Please enter your password..!")
    @Size(min = 4,max = 20,message = "Your password must between 4 and 20 characters ")
    private String password;
    @NotEmpty
    private String username;
    @Enumerated(EnumType.STRING)
    private Role role;
    private String address;
    @OneToMany
    @JoinColumn(name = "seller_iceCream")
    private List<IceCream> iceCreamList;

}
