package com.menghor.java.development.phoneshopdevelopment.service.impl;

import com.menghor.java.development.phoneshopdevelopment.entity.Brand;
import com.menghor.java.development.phoneshopdevelopment.exception.ResourceNotFoundException;
import com.menghor.java.development.phoneshopdevelopment.repository.BrandRepository;
import com.menghor.java.development.phoneshopdevelopment.service.BrandService;
import com.menghor.java.development.phoneshopdevelopment.service.util.PageUtil;
import com.menghor.java.development.phoneshopdevelopment.spec.BrandFilter;
import com.menghor.java.development.phoneshopdevelopment.spec.BrandSpec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


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

    @Override
    public List<Brand> getBrands(String name) {
        //return brandRepository.findByNameLike("%"+name + "%");
        return brandRepository.findByNameContaining(name);
    }

    /*
	@Override
	public List<Brand> getBrands(Map<String, String> params) {
		BrandFilter brandFilter = new BrandFilter();

		if(params.containsKey("name")) {
			String name = params.get("name");
			brandFilter.setName(name);
		}

		if(params.containsKey("id")) {
			String id = params.get("id");
			brandFilter.setId(Integer.parseInt(id));
		}

		BrandSpec brandSpec = new BrandSpec(brandFilter);

		return brandRepository.findAll(brandSpec);

	}
	*/

    @Override
    public Page<Brand> getBrands(Map<String, String> params) {
        BrandFilter brandFilter = new BrandFilter();

        if(params.containsKey("name")) {
            String name = params.get("name");
            brandFilter.setName(name);
        }

        if(params.containsKey("id")) {
            String id = params.get("id");
            brandFilter.setId(Integer.parseInt(id));
        }
        // @TODO add to a function for pageable
        int pageLimit = PageUtil.DEFAULT_PAGE_LIMIT;
        if(params.containsKey(PageUtil.PAGE_LIMIT)) {
            pageLimit = Integer.parseInt(params.get(PageUtil.PAGE_LIMIT));
        }

        int pageNumber = PageUtil.DEFAULT_PAGE_NUMBER;
        if(params.containsKey(PageUtil.PAGE_NUMBER)) {
            pageNumber = Integer.parseInt(params.get(PageUtil.PAGE_NUMBER));
        }

        BrandSpec brandSpec = new BrandSpec(brandFilter);

        Pageable pageable = PageUtil.getPageable(pageNumber, pageLimit);

        //Pageable
        //Page<Brand> findAll = brandRepository.findAll(brandSpec, org.springframework.data.domain.Pageable.ofSize(0));

        Page<Brand> page = brandRepository.findAll(brandSpec, pageable);
        return page;
    }


}
