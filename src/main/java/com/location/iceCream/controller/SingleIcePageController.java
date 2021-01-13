package com.location.iceCream.controller;

import com.location.iceCream.model.IceCream;
import com.location.iceCream.service.iceCream.IceCreamService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/home/{name}")
@RequiredArgsConstructor
public class SingleIcePageController {
    private final IceCreamService iceCreamService;
    @GetMapping
    public String getSingleIce(@PathVariable String name , Model model){
        model.addAttribute("ice", iceCreamService.findByIceCreamName(name));
        return "singleIce";
    }
}
