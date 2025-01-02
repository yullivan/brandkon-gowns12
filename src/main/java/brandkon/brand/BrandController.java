package brandkon.brand;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/brands")
public class BrandController {
    BrandService brandService;

    @GetMapping("")
    public List<BrandResponse> readBrandByCategory(@RequestParam String category){
        return brandService.readByCategory(category);
    }

    @GetMapping("/{brandId}")
    public List<BrandResponse> readBrandByCategory(@PathVariable Long brandId){
        return brandService.read(brandId);
    }
}
