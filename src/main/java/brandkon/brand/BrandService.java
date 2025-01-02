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


    public List<BrandResponse> read(Long brandId) {
        return brandRepository.findById(brandId).stream()
                .map(o -> new BrandResponse(
                        o.getId(),
                        o.getName(),
                        o.getImageUrl()
                ))
                .toList();
    }


}
