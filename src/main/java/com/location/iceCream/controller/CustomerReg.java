package com.location.iceCream.controller;

import com.location.iceCream.config.PasswordEncoderConfig;
import com.location.iceCream.config.Role;
import com.location.iceCream.model.Seller;
import com.location.iceCream.service.seller.SellerService;


import lombok.RequiredArgsConstructor;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Map;

@Controller
@RequestMapping("/signup")
@RequiredArgsConstructor
public class CustomerReg {
    private final SellerService sellerService;
    private final PasswordEncoder passwordEncoder;



    @GetMapping
    public String getForm(Map<String,Object> model){
        model.put("userForm", new Seller());
        return "regForm";
    }
    @PostMapping
    public String register(@ModelAttribute Seller seller, HttpServletRequest req){

            Seller user = new Seller();
            user.setRole(Role.USER);
            user.setActive(true);
            user.setPassword(passwordEncoder.encode(seller.getPassword()));
            user.setUsername(seller.getUsername());
            sellerService.save(user);
            return "home";
    }
}
