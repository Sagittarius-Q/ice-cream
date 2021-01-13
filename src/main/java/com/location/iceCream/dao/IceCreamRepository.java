package com.location.iceCream.dao;

import com.location.iceCream.model.IceCream;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IceCreamRepository extends JpaRepository<IceCream,Long> {
}
