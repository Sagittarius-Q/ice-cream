package com.location.iceCream.service.seller;

import com.location.iceCream.config.Role;
import com.location.iceCream.dao.SellerRepository;
import com.location.iceCream.model.dto.SellerServiceModel;
import com.location.iceCream.model.entity.Seller;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SellerServiceImpl implements SellerService{
    private final SellerRepository sellerRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void save(SellerServiceModel sellerServiceModel) {
        sellerServiceModel.setRole(Role.USER);
        sellerServiceModel.setActive(true);
        Seller seller = modelMapper.map(sellerServiceModel,Seller.class);
        seller.setPassword(passwordEncoder.encode(sellerServiceModel.getPassword()));
        sellerRepository.save(seller);
    }
    @Override
    public SellerServiceModel findByUserName(String userName) {
        Seller seller = sellerRepository.findByUsername(userName);
        return modelMapper.map(seller,SellerServiceModel.class);
    }
    @Override
    public List<SellerServiceModel> findAll() {
        return null;
    }
}
