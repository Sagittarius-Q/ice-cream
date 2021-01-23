package com.location.iceCream.controller;

import com.location.iceCream.model.binding.BindingCommentDto;
import com.location.iceCream.model.dto.CommentServiceModel;
import com.location.iceCream.model.dto.IceCreamServiceModel;
import com.location.iceCream.model.viewer.VComment;
import com.location.iceCream.model.viewer.VIceCream;
import com.location.iceCream.service.Comment.CommentService;

import com.location.iceCream.service.iceCream.IceCreamService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.stream.Collectors;


@Controller
@RequiredArgsConstructor
@RequestMapping("/home")
public class HomeController {
    private final CommentService commentService;
    private final ModelMapper modelMapper;
    private final IceCreamService iceCreamService;

    @GetMapping
    public String getHomePage(Model model){
        List<IceCreamServiceModel> iceCreamServiceModel = iceCreamService.getAll();
        List<VIceCream> collect = iceCreamServiceModel
                .stream()
                .map(element -> {
                    VIceCream iceCream = this.modelMapper.map(element, VIceCream.class);
                    iceCream.setImage(new String(element.getImage(),StandardCharsets.UTF_8));
                    return iceCream;
                })
                .collect(Collectors.toList());
        model.addAttribute("list", collect);
        return "home";
    }

    @GetMapping("/{name}")
    public String getCream(@PathVariable String name, Model model){
        IceCreamServiceModel iceCreamServiceModel = iceCreamService.findByIceCreamName(name);
        List<CommentServiceModel> comments = commentService.getByIceCream(name);
        VIceCream vIceCream = this.modelMapper.map(iceCreamServiceModel, VIceCream.class);
        String s = new String(iceCreamServiceModel.getImage(), StandardCharsets.UTF_8);
        vIceCream.setImage(s);
        List<VComment> vComments = comments
                .stream()
                .map(element -> this.modelMapper.map(element,VComment.class))
                .collect(Collectors.toList());
        model.addAttribute("listComments" , vComments);
        model.addAttribute("ice", vIceCream);
        model.addAttribute("comment", new BindingCommentDto());
        model.addAttribute("iceName" , name);
        return "singleIce";
    }

}
