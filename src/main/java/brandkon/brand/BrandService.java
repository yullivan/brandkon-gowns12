package brandkon.brand;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class BrandService {

    BrandRepository brandRepository;

    public List<BrandResponse> readByCategory(String category) {
        return brandRepository.findByCategory_Name(category).stream()
                .map(o -> new BrandResponse(
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
