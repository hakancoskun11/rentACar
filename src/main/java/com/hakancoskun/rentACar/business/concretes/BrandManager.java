package com.hakancoskun.rentACar.business.concretes;

import com.hakancoskun.rentACar.business.abstracts.BrandService;
import com.hakancoskun.rentACar.business.requests.CreateBrandRequest;
import com.hakancoskun.rentACar.business.requests.UpdateBrandRequest;
import com.hakancoskun.rentACar.business.responses.GetAllBrandsResponse;
import com.hakancoskun.rentACar.business.responses.GetByIdBrandResponse;
import com.hakancoskun.rentACar.business.rules.BrandBusinessRules;
import com.hakancoskun.rentACar.core.utilities.mappers.ModelMapperService;
import com.hakancoskun.rentACar.dataAccess.abstracts.BrandRepository;
import com.hakancoskun.rentACar.entities.concretes.Brand;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BrandManager implements BrandService {

    private BrandRepository brandRepository;
    private ModelMapperService modelMapperService;
    private BrandBusinessRules brandBusinessRules;

    public List<GetAllBrandsResponse> getAll() {
        List<Brand> brands = brandRepository.findAll();

//eski format
//        List<GetAllBrandsResponse> brandsResponses = new ArrayList<GetAllBrandsResponse>();
//        for (Brand brand : brands) {
//            GetAllBrandsResponse responseItem = new GetAllBrandsResponse();
//            responseItem.setId(brand.getId());
//            responseItem.setName(brand.getName());
//            brandsResponses.add(responseItem);
//        }


        //Yeni format. Tüm brandleri gez ve her biri için tek tek dönüşüp yap deidk.
    List<GetAllBrandsResponse> brandsResponse = brands.stream()
            .map(brand -> this.modelMapperService.forResponse()
                    .map(brand, GetAllBrandsResponse.class)).collect(Collectors.toList());

    return brandsResponse;
    }


    @Override
    public void add(CreateBrandRequest createBrandRequest) {
        this.brandBusinessRules.checkIfBrandNameExists(createBrandRequest.getName());
        //other business rules like this

        //Kaynak ve dönüştürülmek istenen tip parametre olarak verildi.
        Brand brand = this.modelMapperService.forRequst().map(createBrandRequest,Brand.class);
        this.brandRepository.save(brand);
    }

    @Override
    public GetByIdBrandResponse getById(int id) {
        Brand brand = this.brandRepository.findById(id).orElseThrow();

        GetByIdBrandResponse response
                = this.modelMapperService.forResponse().map(brand, GetByIdBrandResponse.class);

        return response;
    }

    @Override
    public void update(UpdateBrandRequest updateBrandRequest) {
        Brand brand = this.modelMapperService.forRequst().map(updateBrandRequest,Brand.class);
        this.brandRepository.save(brand);
        // buradaki save id de içerdiği için update yapar;
        // add metodunda id olmadığı için insert yapar.
    }

    @Override
    public void delete(int id) {
        this.brandRepository.deleteById(id);
    }
}


