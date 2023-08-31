package com.hakancoskun.rentACar.dataAccess.abstracts;

import com.hakancoskun.rentACar.entities.concretes.Model;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModelRepository extends JpaRepository<Model,Integer> {
}
