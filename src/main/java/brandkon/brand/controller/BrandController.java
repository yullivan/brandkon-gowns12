package brandkon.brand.controller;

import brandkon.brand.dto.BrandResponse;
import brandkon.brand.service.BrandService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/brands")
public class BrandController {
    BrandService brandService;

    @GetMapping("")
    public List<BrandResponse> readBrandByCategory(@RequestParam("category") String slug){
        return brandService.readByCategory(slug);
    }

    @GetMapping("/{brandId}")
    public BrandResponse readBrandByBrandId(@PathVariable Long brandId){
        return brandService.read(brandId);
    }
}
