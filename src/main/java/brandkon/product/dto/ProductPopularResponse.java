package brandkon.product.dto;

public record ProductPopularResponse(Long id,
                                     String brandName,
                                     String productName,
                                     Integer price,
                                     String imageUrl,
                                     Integer sales) {
}
