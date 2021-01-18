package com.location.iceCream.model.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.location.iceCream.config.Role;
import lombok.Data;

import javax.persistence.*;
import java.util.List;
@Data
@Entity
public class Seller {
    @Id
    @SequenceGenerator(name = "seq_user", allocationSize = 1)
    @GeneratedValue(generator = "seq_user",strategy = GenerationType.SEQUENCE)
    private Long id;
    private String email;
    private String password;
    private boolean active;
    private String username;
    @Enumerated(EnumType.STRING)
    private Role role;
    private String address;
    @JsonManagedReference
    @OneToMany(fetch = FetchType.LAZY)
    private List<IceCream> iceCreamList;

}
