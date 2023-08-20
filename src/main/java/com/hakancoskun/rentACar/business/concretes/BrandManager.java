package com.hakancoskun.rentACar.business.concretes;

import com.hakancoskun.rentACar.business.abstracts.BrandService;
import com.hakancoskun.rentACar.dataAccess.abstracts.BrandRepository;
import com.hakancoskun.rentACar.entities.concretes.Brand;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandManager implements BrandService {

    private BrandRepository brandRepository;

    public BrandManager(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    public List<Brand> getAll() {
        return brandRepository.getAll();
    }
}
