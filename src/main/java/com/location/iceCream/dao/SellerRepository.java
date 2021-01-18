package com.location.iceCream.dao;

import com.location.iceCream.model.entity.Seller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SellerRepository extends JpaRepository<Seller,Long> {
    public Seller findByUsername(String name);
}
