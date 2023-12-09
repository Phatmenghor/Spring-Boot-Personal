package com.menghor.java.development.phoneshopdevelopment.service;

import com.menghor.java.development.phoneshopdevelopment.entity.Brand;

public interface BrandService {
    Brand create(Brand brand);
    Brand getById(Integer id);
    Brand update(Integer id, Brand brandUpdate);
}
