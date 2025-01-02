package brandkon.product;

import brandkon.brand.Brand;
import brandkon.brand.BrandDetailResponse;
import brandkon.brand.BrandRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductService {
    ProductRepository productRepository;
    BrandRepository brandRepository;
    ProductDao productDao;

    public List<ProductResponse> read(Long brandId) {
        if (brandId!=null){
            return productRepository.findByBrand_Id(brandId).stream()
                    .map(o->new ProductResponse(
                            o.getId(),
                            o.getBrand().getName(),
                            o.getName(),
                            o.getPrice(),
                            o.getImageUrl()
                    ))
                    .toList();
        }
        return productRepository.findAll().stream()
                .map(o->new ProductResponse(
                        o.getId(),
                        o.getBrand().getName(),
                        o.getName(),
                        o.getPrice(),
                        o.getImageUrl()
                ))
                .toList();
    }


    public ProductDetailResponse readDetails(Long productId) {
        Product p = productRepository.findById(productId).orElseThrow(()->new IllegalArgumentException("존재하지 않는 상품 ID 입니다"));
        Brand b = brandRepository.findById(p.getBrand().getId()).orElseThrow();
        return new ProductDetailResponse(
                p.getId(),
                p.getName(),
                p.getPrice(),
                new BrandDetailResponse(
                        b.getId(),
                        b.getName(),
                        b.getGuidelines()),
                p.getExpirationDays());
    }

    public List<ProductPopularResponse> readPopularProducts(Long categoryId, Long brandId) {
        return productDao.findAllByFiltersOrderBySalesDesc(categoryId,brandId);
    }
}
