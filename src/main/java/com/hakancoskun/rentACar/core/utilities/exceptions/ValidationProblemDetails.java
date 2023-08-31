package com.hakancoskun.rentACar.core.utilities.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ValidationProblemDetails extends ProblemDetails {
    //hangi alanda ne hatası var şeklinde tutacağız
    private Map<String, String> validationErrors;
}
