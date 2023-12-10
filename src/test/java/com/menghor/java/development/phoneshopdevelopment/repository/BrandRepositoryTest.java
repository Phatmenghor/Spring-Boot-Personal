package com.menghor.java.development.phoneshopdevelopment.repository;

import com.menghor.java.development.phoneshopdevelopment.entity.Brand;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class BrandRepositoryTest {
    @Autowired
    private BrandRepository brandRepositoryTest;

    @Test
    public void testFindByNameLike() {
        //given
        Brand brand = new Brand();
        brand.setName("Apple");

        Brand brand2 = new Brand();
        brand2.setName("Samsung");

        brandRepositoryTest.save(brand);
//        brandRepositoryTest.save(brand2);

        //when
        List<Brand> brands = brandRepositoryTest.findByNameLike("%A%");

        //then
        assertEquals(1, brands.size());
        assertEquals("Apple", brands.get(0).getName());
        assertEquals(1, brands.get(0).getId());
    }
}
