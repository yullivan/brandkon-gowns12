package brandkon.category.service;

import brandkon.category.dto.CategoryResponse;
import brandkon.category.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class CategoryService {
    CategoryRepository categoryRepository;

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
