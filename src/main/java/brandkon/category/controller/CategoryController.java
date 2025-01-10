package brandkon.category.controller;

import brandkon.category.dto.CategoryResponse;
import brandkon.category.entity.Category;
import brandkon.category.service.CategoryService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/categories")
@RestController
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping("")
    public List<CategoryResponse> readCategories(){
       return categoryService.readAll();
    }
}
