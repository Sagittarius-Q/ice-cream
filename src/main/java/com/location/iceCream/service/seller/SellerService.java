package com.location.iceCream.service.seller;

import com.location.iceCream.model.dto.SellerServiceModel;

import java.util.List;

public interface SellerService {
    public void save(SellerServiceModel sellerServiceModel);
    public SellerServiceModel findByUserName(String userName);
    public List<SellerServiceModel> findAll();

}
