package brandkon.product;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/products")
public class ProductController {

    ProductService productService;

    @GetMapping("")
    public List<ProductResponse> readProducts(@RequestParam(required = false) Long brandId){
        return productService.read(brandId);
    }
}
