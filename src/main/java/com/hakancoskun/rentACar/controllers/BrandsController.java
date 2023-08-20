package com.hakancoskun.rentACar.controllers;

import com.hakancoskun.rentACar.business.abstracts.BrandService;
import com.hakancoskun.rentACar.entities.concretes.Brand;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//hakancarrenting/api/brands
@RestController
@RequestMapping("/api/brands")
public class BrandsController {

    private BrandService brandService;

    public BrandsController(BrandService brandService) {
        this.brandService = brandService;
    }

    @GetMapping("/getall")
    public List<Brand> getAll() {
        return brandService.getAll();
    }
}
