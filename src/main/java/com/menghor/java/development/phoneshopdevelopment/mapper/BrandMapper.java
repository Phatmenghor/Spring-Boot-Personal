package com.menghor.java.development.phoneshopdevelopment.mapper;

import com.menghor.java.development.phoneshopdevelopment.dto.BrandDTO;
import com.menghor.java.development.phoneshopdevelopment.entity.Brand;
import org.mapstruct.Mapper;

@Mapper
public interface BrandMapper {
    Brand toBrand(BrandDTO dto);
}
