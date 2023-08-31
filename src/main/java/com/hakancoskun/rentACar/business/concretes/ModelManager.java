package com.hakancoskun.rentACar.business.concretes;

import com.hakancoskun.rentACar.business.abstracts.ModelService;
import com.hakancoskun.rentACar.business.requests.CreateModelRequest;
import com.hakancoskun.rentACar.business.responses.GetAllModelResponse;
import com.hakancoskun.rentACar.core.utilities.mappers.ModelMapperService;
import com.hakancoskun.rentACar.dataAccess.abstracts.ModelRepository;
import com.hakancoskun.rentACar.entities.concretes.Model;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ModelManager implements ModelService {

    private ModelRepository modelRepository;
    private ModelMapperService modelMapperService;
    @Override
    public List<GetAllModelResponse> getAll() {
        List<Model> models = modelRepository.findAll();

        List<GetAllModelResponse> modelsResponse = models.stream()
                .map(model -> this.modelMapperService.forResponse()
                        .map(model, GetAllModelResponse.class)).collect(Collectors.toList());

        return modelsResponse;
    }

    @Override
    public void add(CreateModelRequest request) {
        Model model = this.modelMapperService.forRequst().map(request,Model.class);
        this.modelRepository.save(model);
    }
}
