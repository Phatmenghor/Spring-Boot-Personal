package com.menghor.java.development.phoneshopdevelopment.service.impl;

import com.menghor.java.development.phoneshopdevelopment.entity.Brand;
import com.menghor.java.development.phoneshopdevelopment.exception.ResourceNotFoundException;
import com.menghor.java.development.phoneshopdevelopment.repository.BrandRepository;
import com.menghor.java.development.phoneshopdevelopment.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class BrandServiceImpl implements BrandService {
    @Autowired
    private BrandRepository brandRepository;

    @Override
    public Brand create(Brand brand) {
        return brandRepository.save(brand);
    }

    @Override
    public Brand getById(Integer id) {
        return brandRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Brand", id));
    }

    @Override
    public Brand update(Integer id, Brand brandUpdate) {
        Brand brand = getById(id);
        brand.setName(brandUpdate.getName()); // @TODO improve update
        return brandRepository.save(brand);
    }

}
