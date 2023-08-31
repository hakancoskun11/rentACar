package com.hakancoskun.rentACar.controllers;

import com.hakancoskun.rentACar.business.abstracts.ModelService;

import com.hakancoskun.rentACar.business.requests.CreateModelRequest;
import com.hakancoskun.rentACar.business.responses.GetAllModelResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/models")
@AllArgsConstructor
public class ModelsController {

    private ModelService modelService;

    @GetMapping()
    public List<GetAllModelResponse> getAll() {
        return modelService.getAll();
    }

    @PostMapping()
    @ResponseStatus(code= HttpStatus.CREATED)
    public void add(@RequestBody @Valid CreateModelRequest request) {
        this.modelService.add(request);
    }
}
