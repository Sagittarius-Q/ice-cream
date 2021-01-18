package com.location.iceCream.dao;

import com.location.iceCream.model.entity.IceCream;
import com.location.iceCream.model.entity.Seller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IceCreamRepository extends JpaRepository<IceCream,Long> {
    public IceCream findByName(String name);
    public IceCream findByOwnerAndName(Seller owner, String name);
}
