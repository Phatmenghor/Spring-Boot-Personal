package com.menghor.java.development.phoneshopdevelopment.BrandController;

import com.menghor.java.development.phoneshopdevelopment.dto.BrandDTO;
import com.menghor.java.development.phoneshopdevelopment.dto.PageDTO;
import com.menghor.java.development.phoneshopdevelopment.entity.Brand;
import com.menghor.java.development.phoneshopdevelopment.mapper.BrandMapper;
import com.menghor.java.development.phoneshopdevelopment.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("brands")
public class BrandController {
    @Autowired
    private BrandService brandService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> create(@RequestBody BrandDTO brandDTO) {
        Brand brand = BrandMapper.INSTANCE.toBrand(brandDTO);
        brand = brandService.create(brand);

        return ResponseEntity.ok(BrandMapper.INSTANCE.toBrandDTO(brand));
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getOneBrand(@PathVariable("id") Integer brandId){
        Brand brand = brandService.getById(brandId);
        return ResponseEntity.ok(BrandMapper.INSTANCE.toBrandDTO(brand));
    }

    @PutMapping("{id}")
    public ResponseEntity<?> update(@PathVariable("id") Integer brandId, @RequestBody BrandDTO brandDTO){
        Brand brand = BrandMapper.INSTANCE.toBrand(brandDTO);
        Brand updatedBrand = brandService.update(brandId, brand);
        return ResponseEntity.ok(BrandMapper.INSTANCE.toBrandDTO(updatedBrand));
    }

    @GetMapping
    public ResponseEntity<?> getBrands(@RequestParam Map<String, String> params){
        Page<Brand> page = brandService.getBrands(params);

        PageDTO pageDTO = new PageDTO(page);
		/*
		List<BrandDTO> list = brandService.getBrands(params)
			.stream()
			.map(brand -> BrandMapper.INSTANCE.toBrandDTO(brand))
			.collect(Collectors.toList());
		*/
        return ResponseEntity.ok(pageDTO);

    }
}
