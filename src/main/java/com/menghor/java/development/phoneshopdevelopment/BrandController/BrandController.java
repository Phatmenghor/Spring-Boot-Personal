package com.menghor.java.development.phoneshopdevelopment.BrandController;

import com.menghor.java.development.phoneshopdevelopment.dto.BrandDTO;
import com.menghor.java.development.phoneshopdevelopment.entity.Brand;
import com.menghor.java.development.phoneshopdevelopment.service.BrandService;
import com.menghor.java.development.phoneshopdevelopment.service.util.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("brands")
public class BrandController {
    @Autowired
    private BrandService brandService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> create(@RequestBody BrandDTO brandDTO) {
        Brand brand = Mapper.toBrand(brandDTO);
        brand = brandService.create(brand);

        return ResponseEntity.ok(Mapper.toBrandDTO(brand));
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getOneBrand(@PathVariable("id") Integer brandId){
        Brand brand = brandService.getById(brandId);
        return ResponseEntity.ok(Mapper.toBrandDTO(brand));
    }

    @PutMapping("{id}")
    public ResponseEntity<?> update(@PathVariable("id") Integer brandId, @RequestBody BrandDTO brandDTO){
        Brand brand = Mapper.toBrand(brandDTO);
        Brand updatedBrand = brandService.update(brandId, brand);
        return ResponseEntity.ok(Mapper.toBrandDTO(updatedBrand));
    }
}
