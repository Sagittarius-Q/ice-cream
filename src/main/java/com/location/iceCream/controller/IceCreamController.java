package com.location.iceCream.controller;


import com.location.iceCream.model.dto.IceCreamServiceModel;
import com.location.iceCream.service.iceCream.IceCreamService;
import com.location.iceCream.service.seller.SellerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.security.Principal;


@Controller
@RequestMapping("/ice")
@RequiredArgsConstructor
public class IceCreamController {
    private final IceCreamService iceCreamService;
    private final SellerService sellerService;

    @GetMapping
    public String getAllIce(Model model, Principal principal){
        model.addAttribute("listIce",sellerService.findByUserName(principal.getName()));
        return "userIce";
    }
    @GetMapping("/add")
    public String getIceForm(){
        return "iceForm";
    }

    @PostMapping("/add")
    public String doSave(@ModelAttribute IceCreamServiceModel iceCreamServiceModel,
                         BindingResult result, Principal principal,MultipartFile photo) throws IOException {
        if(result.hasErrors()){
            return "iceForm";
        }
        iceCreamServiceModel.setOwner(sellerService.findByUserName(principal.getName()));


        return "home";
    }

    @GetMapping("/update/{name}")
    public String updateIceCream(@PathVariable String name){
        return "updateIce";
    }
    @PostMapping("/delete/{name}")
    public String deleteIce(@PathVariable String name, HttpServletRequest httpServletRequest){
        return null;
    }
}
