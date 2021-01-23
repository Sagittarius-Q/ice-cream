package com.location.iceCream.controller;

import com.location.iceCream.model.binding.BindingUserDto;
import com.location.iceCream.model.dto.SellerServiceModel;
import com.location.iceCream.service.seller.SellerService;


import lombok.RequiredArgsConstructor;

import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final ModelMapper modelMapper;
    private final SellerService sellerService;
    private final PasswordEncoder passwordEncoder;

    @GetMapping
    public String getFormReg(Model model){
        model.addAttribute("userForm", new BindingUserDto());
        return "regForm";
    }
    @PostMapping("/sign")
    public String confirmReg(@Valid @ModelAttribute("userForm")  BindingUserDto bindingUserDto,
                             BindingResult result, HttpServletRequest req){
        if(result.hasErrors()){
            return "regForm";
        }
        if(!bindingUserDto.getPassword().equals(bindingUserDto.getConfirmPassword())){
            return "regForm";
        }
        SellerServiceModel seller = this.modelMapper.map(bindingUserDto,SellerServiceModel.class);
        sellerService.save(seller);
            return "home";
    }
}
