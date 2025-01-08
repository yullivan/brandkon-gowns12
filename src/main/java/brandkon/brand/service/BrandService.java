package brandkon.brand.service;

import brandkon.brand.dto.BrandResponse;
import brandkon.brand.entity.Brand;
import brandkon.brand.repository.BrandCategoryRepository;
import brandkon.brand.repository.BrandRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class BrandService {

    BrandRepository brandRepository;
    BrandCategoryRepository brandCategoryRepository;

    public List<BrandResponse> readByCategory(String slug) {
        return brandRepository.findByCategory_Slug(slug).stream()
                .map(o->new BrandResponse(
                        o.getId(),
                        o.getName(),
                        o.getImageUrl()
                ))
                .toList();
    }


    public BrandResponse read(Long brandId) {
        Brand brand = brandRepository.findById(brandId).orElseThrow(()->new IllegalArgumentException("존재하지 않는 브랜드 ID 입니다."));
        return new BrandResponse(
                brand.getId(),
                brand.getName(),
                brand.getImageUrl());
    }


}
