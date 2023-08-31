package com.hakancoskun.rentACar.business.abstracts;

import com.hakancoskun.rentACar.business.requests.CreateModelRequest;
import com.hakancoskun.rentACar.business.responses.GetAllModelResponse;

import java.util.List;

public interface ModelService {
    List<GetAllModelResponse> getAll();
    void add(CreateModelRequest request);
}
