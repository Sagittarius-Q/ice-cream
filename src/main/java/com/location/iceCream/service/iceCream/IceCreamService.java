package com.location.iceCream.service.iceCream;

import com.location.iceCream.model.dto.IceCreamServiceModel;
import com.location.iceCream.model.dto.SellerServiceModel;

import java.io.IOException;
import java.util.List;

public interface IceCreamService {
    public void save(IceCreamServiceModel iceCream) throws IOException;
    public IceCreamServiceModel findByIceCreamName(String name);
    public IceCreamServiceModel findByUserAndIce(SellerServiceModel seller, String name);
    public List<IceCreamServiceModel> getAll();
}
