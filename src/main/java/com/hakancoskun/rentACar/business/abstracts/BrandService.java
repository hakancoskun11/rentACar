package com.hakancoskun.rentACar.business.abstracts;

import com.hakancoskun.rentACar.business.requests.CreateBrandRequest;
import com.hakancoskun.rentACar.business.requests.UpdateBrandRequest;
import com.hakancoskun.rentACar.business.responses.GetAllBrandsResponse;
import com.hakancoskun.rentACar.business.responses.GetByIdBrandResponse;

import java.util.List;

public interface BrandService {
    List<GetAllBrandsResponse> getAll();
    GetByIdBrandResponse getById(int id);
    void add(CreateBrandRequest request);
    void update(UpdateBrandRequest updateBrandRequest);
    void delete(int id);

}
