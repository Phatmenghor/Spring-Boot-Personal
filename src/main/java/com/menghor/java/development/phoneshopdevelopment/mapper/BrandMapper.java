package com.menghor.java.development.phoneshopdevelopment.mapper;

import com.menghor.java.development.phoneshopdevelopment.dto.BrandDTO;
import com.menghor.java.development.phoneshopdevelopment.entity.Brand;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BrandMapper {
    BrandMapper INSTANCE = Mappers.getMapper(BrandMapper.class);
    Brand toBrand(BrandDTO dto);
    BrandDTO toBrandDTO(Brand entity);
}
