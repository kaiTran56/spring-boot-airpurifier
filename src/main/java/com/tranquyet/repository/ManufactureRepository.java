package com.tranquyet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tranquyet.entity.ManufactureEntity;

@Repository
public interface ManufactureRepository extends JpaRepository<ManufactureEntity, Long>{

}
