package com.location.iceCream.model.dto;

import com.location.iceCream.config.Role;
import com.location.iceCream.model.entity.IceCream;
import lombok.Data;


import java.util.List;
@Data
public class SellerServiceModel {
    private Long id;
    private String email;
    private String password;
    private boolean active;
    private String username;
    private Role role;
    private String address;
    private List<IceCreamServiceModel> iceCreamList;

}
