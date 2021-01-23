package com.location.iceCream.controller;


import com.location.iceCream.model.binding.BindingIceCreamDto;
import com.location.iceCream.model.dto.IceCreamServiceModel;
import com.location.iceCream.service.iceCream.IceCreamService;
import com.location.iceCream.service.seller.SellerService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.Principal;
import java.util.Base64;


@Controller
@RequestMapping("/ice")
@RequiredArgsConstructor
public class IceCreamController {
    private final IceCreamService iceCreamService;
    private final SellerService sellerService;
    private final ModelMapper modelMapper;

    @GetMapping
    public String getAllIce(Model model, Principal principal){
        model.addAttribute("listIce",sellerService.findByUserName(principal.getName()));
        return "userIce";
    }
    @GetMapping("/add")
    public String getIceForm(Model model){
        model.addAttribute("iceForm", new BindingIceCreamDto());
        return "iceForm";
    }

    @PostMapping("/add")
    public String doSave(@Valid @ModelAttribute("iceForm") BindingIceCreamDto bindingIceCreamDto,
                         BindingResult result, Principal principal,MultipartFile photo) throws IOException {
        if(result.hasErrors()){
            return "iceForm";
        }
        IceCreamServiceModel iceCreamServiceModel = this.modelMapper
                .map(bindingIceCreamDto, IceCreamServiceModel.class);
        iceCreamServiceModel.setOwner(sellerService.findByUserName(principal.getName()));
        byte[] img = Base64.getEncoder().encodeToString(bindingIceCreamDto.getImage().getBytes()).getBytes(StandardCharsets.UTF_8);
        iceCreamServiceModel.setImage(img);
        iceCreamService.save(iceCreamServiceModel);
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
