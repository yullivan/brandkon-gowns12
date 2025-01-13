package brandkon.category.service;

import brandkon.category.dto.CategoryResponse;
import brandkon.category.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public List<CategoryResponse> readAll() {
        return categoryRepository.findAll().stream()
                .map(o->new CategoryResponse(
                        o.getId(),
                        o.getName(),
                        o.getSlug(),
                        o.getImageUrl()
                ))
                .toList();
    }


}
