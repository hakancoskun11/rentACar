package com.hakancoskun.rentACar.dataAccess.abstracts;

import com.hakancoskun.rentACar.entities.concretes.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BrandRepository extends JpaRepository<Brand,Integer> {

}
