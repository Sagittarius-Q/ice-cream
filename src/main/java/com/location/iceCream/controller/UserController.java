package com.location.iceCream.controller;

import com.location.iceCream.model.dto.SellerServiceModel;
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

@Controller
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final SellerService sellerService;
    private final PasswordEncoder passwordEncoder;

    @GetMapping
    public String getFormReg(@ModelAttribute(name = "model") SellerServiceModel seller){
        return "regForm";
    }
    @PostMapping
    public String confirmReg(@ModelAttribute SellerServiceModel seller, BindingResult result, HttpServletRequest req){
        if(result.hasErrors()){
            return "regForm";
        }
        System.out.println(seller);
        sellerService.save(seller);
            return "home";
    }
}
