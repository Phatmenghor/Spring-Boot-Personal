package com.menghor.java.development.phoneshopdevelopment.repository;

import com.menghor.java.development.phoneshopdevelopment.entity.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Integer>, JpaSpecificationExecutor<Brand> {
    List<Brand> findByNameLike(String name);
    List<Brand> findByNameContaining(String name);
}
