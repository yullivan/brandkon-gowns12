package brandkon.product.dto;

public record ProductResponse(
        Long id,
        String brandName,
        String productName,
        Integer price,
        String imageUrl
) {}

