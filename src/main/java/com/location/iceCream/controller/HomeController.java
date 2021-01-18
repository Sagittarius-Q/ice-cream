package com.location.iceCream.controller;

import com.location.iceCream.model.dto.IceCreamServiceModel;
import com.location.iceCream.service.iceCream.IceCreamService;
import com.location.iceCream.service.seller.SellerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequiredArgsConstructor
@RequestMapping("/home")
public class HomeController {
    private final SellerService sellerService;
    private final IceCreamService iceCreamService;

    @GetMapping
    public String getHomePage(Model model){
        model.addAttribute("list", iceCreamService.getAll());
        System.out.println("enter");
        return "home";
    }

    @GetMapping("/{name}")
    public String getCream(@PathVariable String name, Model model){
        IceCreamServiceModel iceCreamServiceModel = iceCreamService.findByIceCreamName(name);
        model.addAttribute("ice", iceCreamServiceModel);
        return "singleIce";
    }

}
