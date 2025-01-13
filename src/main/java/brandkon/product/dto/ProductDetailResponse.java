package brandkon.product.dto;

import brandkon.brand.dto.BrandDetailResponse;

public record ProductDetailResponse(
        Long id,
        String productName,
        Integer price,
        BrandDetailResponse brand,
        Integer expirationDays
) {
}
