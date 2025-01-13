package brandkon.product.service;

import brandkon.brand.entity.Brand;
import brandkon.brand.dto.BrandDetailResponse;
import brandkon.brand.repository.BrandRepository;
import brandkon.product.dao.ProductDao;
import brandkon.product.dto.ProductDetailResponse;
import brandkon.product.dto.ProductPopularResponse;
import brandkon.product.dto.ProductResponse;
import brandkon.product.entity.Product;
import brandkon.product.repository.ProductRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final ProductDao productDao;

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
        Brand b = p.getBrand();
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
