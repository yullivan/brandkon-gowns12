package brandkon.product;

import brandkon.brand.BrandDetailResponse;

import java.util.List;

public record ProductDetailResponse(
        Long id,
        String productName,
        Integer price,
        List<BrandDetailResponse> brand,
        Integer expirationDays
) {
}