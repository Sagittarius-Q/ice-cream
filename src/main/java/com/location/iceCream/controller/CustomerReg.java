package com.location.iceCream.controller;

import com.location.iceCream.model.Seller;
import com.location.iceCream.service.seller.SellerService;

import com.location.iceCream.validation.Validator;
import com.location.iceCream.validation.ValidatorImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.Map;

@Controller
@RequestMapping("/signup")
@RequiredArgsConstructor
public class CustomerReg {
    private final SellerService sellerService;



    @GetMapping
    public String getForm(Map<String,Object> model){
        model.put("userForm", new Seller());
        return "regForm";
    }
    @PostMapping
    public String register(@Valid @ModelAttribute("userForm") Seller seller,BindingResult result,
                           Map<String,Object> model){
        sellerService.save(seller);
        return "home";
    }
}
