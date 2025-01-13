package brandkon.brand.service;

import brandkon.brand.dto.BrandResponse;
import brandkon.brand.entity.Brand;
import brandkon.brand.entity.BrandCategory;
import brandkon.brand.repository.BrandCategoryRepository;
import brandkon.brand.repository.BrandRepository;
import brandkon.category.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BrandService {

    private final BrandRepository brandRepository;
    private final BrandCategoryRepository brandCategoryRepository;
    private final CategoryRepository categoryRepository;

//    public List<BrandResponse> readByCategory(String slug) {
//        return brandRepository.findByCategory_Slug(slug).stream()
//                .map(o->new BrandResponse(
//                        o.getId(),
//                        o.getName(),
//                        o.getImageUrl()
//                ))
//                .toList();
//    }

    public List<BrandResponse> readByCategory(String slug) {
        Long categoryId = categoryRepository.findBySlug(slug).getId();
        List<BrandCategory> bc = brandCategoryRepository.findAllByCategoryId(categoryId);
        return bc.stream()
                .map(BrandCategory::getBrand)
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
