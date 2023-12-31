package com.menghor.java.development.phoneshopdevelopment.service;

import com.menghor.java.development.phoneshopdevelopment.entity.Brand;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Map;

public interface BrandService {
    Brand create(Brand brand);
    Brand getById(Integer id);
    Brand update(Integer id, Brand brandUpdate);
    List<Brand> getBrands(String name);
    //List<Brand> getBrands(Map<String, String> params);
    Page<Brand> getBrands(Map<String, String> params);
}
