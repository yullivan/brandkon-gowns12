package brandkon.category.controller;

import brandkon.category.dto.CategoryResponse;
import brandkon.category.entity.Category;
import brandkon.category.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RequestMapping("/categories")
@RestController
public class CategoryController {

    CategoryService categoryService;

    @GetMapping("")
    public List<CategoryResponse> readCategories(){
       return categoryService.readAll();
    }
}
