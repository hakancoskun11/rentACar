package com.hakancoskun.rentACar.dataAccess.concretes;

import com.hakancoskun.rentACar.dataAccess.abstracts.BrandRepository;
import com.hakancoskun.rentACar.entities.concretes.Brand;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InMemoryBrandRepository implements BrandRepository {

    // inmemory
    List<Brand> brands;

    public InMemoryBrandRepository() {
       brands = new ArrayList<Brand>();
       brands.add(new Brand(1,"BMW"));
       brands.add(new Brand(2,"Mercedes"));
       brands.add(new Brand(3,"Audi"));
       brands.add(new Brand(4,"Fiat"));
       brands.add(new Brand(5,"Porche"));
    }
    @Override
    public List<Brand> getAll() {
        return brands;
    }
}
