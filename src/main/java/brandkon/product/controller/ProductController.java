package brandkon.product.controller;

import brandkon.product.dto.ProductPopularResponse;
import brandkon.product.dto.ProductResponse;
import brandkon.product.service.ProductService;
import brandkon.product.dto.ProductDetailResponse;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    @GetMapping("")
    public List<ProductResponse> readProducts(@RequestParam(required = false) Long brandId) {
        return productService.read(brandId);
    }

    @GetMapping("/{productId}")
    public ProductDetailResponse readDetails(@PathVariable Long productId) {
        return productService.readDetails(productId);
    }

    @GetMapping("/popular")
    public List<ProductPopularResponse> readPopularProducts(@RequestParam(required = false) Long categoryId, @RequestParam(required = false) Long brandId) {
        return productService.readPopularProducts(categoryId, brandId);
    }
}
