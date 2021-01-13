package com.location.iceCream.controller;

import com.location.iceCream.service.iceCream.IceCreamService;
import com.location.iceCream.service.seller.SellerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
@RequiredArgsConstructor
@RequestMapping("/home")
public class HomeController {
    private final SellerService sellerService;
    private final IceCreamService iceCreamService;
    @GetMapping
    public String getHomePage(Model model){
        model.addAttribute("list", iceCreamService.getAll());
        return "home";
    }

}
