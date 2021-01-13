package com.location.iceCream.controller;


import com.location.iceCream.model.IceCream;
import com.location.iceCream.service.iceCream.IceCreamService;
import com.location.iceCream.service.seller.SellerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;


@Controller
@RequestMapping("/ice")
@RequiredArgsConstructor
public class IceCreamController {
    private final IceCreamService iceCreamService;
    private final SellerService sellerService;

    @GetMapping
    public String getAllIce(Model model,HttpServletRequest httpServletRequest){
        model.addAttribute("listIce",sellerService.findByUserName(httpServletRequest.getUserPrincipal().getName()));
        return "userIce";
    }
    @GetMapping("/add")
    public String getIceForm(Model model){
        model.addAttribute("ice", new IceCream());
        return "iceForm";
    }
    @PostMapping("/add")
    public String doSave(@ModelAttribute("ice") IceCream iceCream, Model model, HttpServletRequest httpServletRequest){
        iceCream.setOwner(sellerService.findByUserName(httpServletRequest.getUserPrincipal().getName()));
        iceCreamService.save(iceCream);
        return "redirect:/ice";
    }
    @GetMapping("/update/{name}")
    public String updateIceCream(@PathVariable String name, Model model, HttpServletRequest httpServletRequest){
        model.addAttribute("ice", iceCreamService.findByUsernameAndIcename(name,
                httpServletRequest.getUserPrincipal().getName()));
        return "updateIce";
    }
    @PostMapping("/delete/{name}")
    public String deleteIce(@PathVariable String name, HttpServletRequest httpServletRequest){
        return null;
    }
}
