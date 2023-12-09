package com.menghor.java.development.phoneshopdevelopment.repository;

import com.menghor.java.development.phoneshopdevelopment.entity.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Integer> {
}
