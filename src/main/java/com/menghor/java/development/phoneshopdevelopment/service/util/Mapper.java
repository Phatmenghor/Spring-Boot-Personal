package com.menghor.java.development.phoneshopdevelopment.service.util;

import com.menghor.java.development.phoneshopdevelopment.dto.BrandDTO;
import com.menghor.java.development.phoneshopdevelopment.entity.Brand;

public class Mapper {
    public static Brand toBrand(BrandDTO dto) {
        Brand brand = new Brand();
        //brand.setId(dto.getId());
        brand.setName(dto.getName());
        return brand;
    }

    public static BrandDTO toBrandDTO(Brand brand) {
        BrandDTO brandDTO = new BrandDTO();
        brandDTO.setName(brand.getName());
        return brandDTO;
    }
}
