package com.location.iceCream.service.iceCream;


import com.location.iceCream.dao.IceCreamRepository;
import com.location.iceCream.model.dto.IceCreamServiceModel;
import com.location.iceCream.model.dto.SellerServiceModel;

import com.location.iceCream.model.entity.IceCream;
import com.location.iceCream.model.entity.Seller;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class IceCreamServiceImpl implements IceCreamService{
    private final IceCreamRepository iceCreamRepository;
    private final ModelMapper modelMapper;


    @Override
    public void save(IceCreamServiceModel iceCream) {
        ModelMapper modelMapper = new ModelMapper();
        IceCream ice = modelMapper.map(iceCream, IceCream.class);
        iceCreamRepository.save(ice);
    }

    @Override
    public IceCreamServiceModel findByIceCreamName(String name) {
        IceCream ice = iceCreamRepository.findByName(name);
        return modelMapper.map(ice,IceCreamServiceModel.class);
    }

    @Override
    public IceCreamServiceModel findByUserAndIce(SellerServiceModel seller, String name) {
        Seller seller1 = modelMapper.map(seller, Seller.class);
        IceCream iceCream = iceCreamRepository.findByOwnerAndName(seller1, name);
        return modelMapper.map(iceCream, IceCreamServiceModel.class);
    }

    @Override
    public List<IceCreamServiceModel> getAll() {
        List<IceCream> iceCreams = iceCreamRepository.findAll();
        return iceCreams
                .stream()
                .map(element -> modelMapper.map(element,IceCreamServiceModel.class))
                .collect(Collectors.toList());
    }
}
