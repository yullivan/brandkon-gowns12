package brandkon.product;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/products")
public class ProductController {

    ProductService productService;

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
