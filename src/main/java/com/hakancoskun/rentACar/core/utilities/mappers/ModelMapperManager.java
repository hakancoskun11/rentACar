package com.hakancoskun.rentACar.core.utilities.mappers;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ModelMapperManager implements ModelMapperService{

    private ModelMapper modelMapper;

//    Birisinde gevşek maphleme birisinde standart mapleme kulllandık.
//    veritabanıyla her şeyin bir karşılığı olacak yoksa hata ver diyorsak standart;
//    tüm alanlar maplenmek zorunda değilse gevşek mapleme kullanıyoruz.
//    setAmbiguityIgnored(true) belirsizlik olduğunda ignore et dedik.
//    anlamı maplemelerde nested yapılarda onları ignore et kontrolü ben devralacağım demek.

    //Burada sadece mapleme türünün standart mı gevşek mi olacağını belirttik.

    @Override
    public ModelMapper forResponse() {
        this.modelMapper.getConfiguration()
                .setAmbiguityIgnored(true)
                .setMatchingStrategy(MatchingStrategies.LOOSE);

        return this.modelMapper;
    }

    @Override
    public ModelMapper forRequst() {
        this.modelMapper.getConfiguration()
                .setAmbiguityIgnored(true)
                .setMatchingStrategy(MatchingStrategies.STANDARD);

        return this.modelMapper;
    }
}
