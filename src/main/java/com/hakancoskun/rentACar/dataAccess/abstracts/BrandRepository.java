package com.hakancoskun.rentACar.dataAccess.abstracts;

import com.hakancoskun.rentACar.entities.concretes.Brand;

import java.util.List;

public interface BrandRepository {
    List<Brand> getAll();
}
