package com.hakancoskun.rentACar.business.concretes;

import com.hakancoskun.rentACar.business.abstracts.BrandService;
import com.hakancoskun.rentACar.business.requests.CreateBrandRequest;
import com.hakancoskun.rentACar.business.responses.GetAllBrandsResponse;
import com.hakancoskun.rentACar.dataAccess.abstracts.BrandRepository;
import com.hakancoskun.rentACar.entities.concretes.Brand;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BrandManager implements BrandService {

    private BrandRepository brandRepository;

    public BrandManager(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    public List<GetAllBrandsResponse> getAll() {
        List<Brand> brands = brandRepository.findAll();
        List<GetAllBrandsResponse> brandsResponses = new ArrayList<GetAllBrandsResponse>();

        for (Brand brand : brands) {
            GetAllBrandsResponse responseItem = new GetAllBrandsResponse();
            responseItem.setId(brand.getId());
            responseItem.setName(brand.getName());
            brandsResponses.add(responseItem);
        }

        return brandsResponses;
    }

    @Override
    public void add(CreateBrandRequest request) {

//        Entity, request, response gibi nesneler new'lenebilir.
//        Onlar bir bağımlılık sebebi değildir.

        Brand brand = new Brand();
        brand.setName(request.getName());
        this.brandRepository.save(brand);
    }
}
