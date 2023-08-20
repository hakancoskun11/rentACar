package com.hakancoskun.rentACar.business.abstracts;

import com.hakancoskun.rentACar.business.requests.CreateBrandRequest;
import com.hakancoskun.rentACar.business.responses.GetAllBrandsResponse;
import java.util.List;

public interface BrandService {
    List<GetAllBrandsResponse> getAll();
    void add(CreateBrandRequest request);

}
