package com.tranquyet.repository;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tranquyet.entity.CategoryEntity;
import com.tranquyet.entity.ManufactureEntity;
import com.tranquyet.entity.ProductEntity;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
		List<ProductEntity> findByName(String name, PageRequest page);

		ProductEntity findOneById(Long id);
		
		List<ProductEntity> findByCategory(CategoryEntity entity);
		
		List<ProductEntity> findByManufacture(ManufactureEntity entity);
		
}
