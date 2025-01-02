package brandkon.product;

import brandkon.brand.BrandRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductService {
    ProductRepository productRepository;
    BrandRepository brandRepository;

    public List<ProductResponse> read(Long brandId) {
        if (brandId!=null){
            return productRepository.findByBrand_Id().stream()
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


}
