package brandkon.category.dto;

public record CategoryResponse(
        Long id,
        String name,
        String slug,
        String imageUrl
) {
}
