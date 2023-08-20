package com.hakancoskun.rentACar.controllers;

import com.hakancoskun.rentACar.business.abstracts.BrandService;
import com.hakancoskun.rentACar.business.requests.CreateBrandRequest;
import com.hakancoskun.rentACar.business.responses.GetAllBrandsResponse;
import org.springframework.web.bind.annotation.*;

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
    public List<GetAllBrandsResponse> getAll() {
        return brandService.getAll();
    }

    @PostMapping("/add")
    public void add(@RequestBody CreateBrandRequest request) {
        this.brandService.add(request);
    }

}
