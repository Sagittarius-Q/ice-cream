package com.location.iceCream.controller;

import com.location.iceCream.model.binding.BindingCommentDto;
import com.location.iceCream.model.dto.CommentServiceModel;
import com.location.iceCream.model.dto.IceCreamServiceModel;
import com.location.iceCream.service.Comment.CommentService;
import com.location.iceCream.service.iceCream.IceCreamService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.Date;

@Controller
@RequestMapping("/comment")
@RequiredArgsConstructor
public class CommentController {
    private final ModelMapper modelMapper;
    private final IceCreamService iceCreamService;
    private final CommentService commentService;
    @PostMapping
    public String addComment(@Valid @ModelAttribute BindingCommentDto bindingCommentDto,
                             BindingResult result){
        if(result.hasErrors()) {
         return "redirect:/home/";
        }
        CommentServiceModel commentServiceModel = this.modelMapper.map(bindingCommentDto, CommentServiceModel.class);
        commentServiceModel.setDate(new Date());
        System.out.println(commentServiceModel.getIceCreamName());
        commentService.save(commentServiceModel);
        return "redirect:/home/" + bindingCommentDto.getIceCreamName();
    }

}
