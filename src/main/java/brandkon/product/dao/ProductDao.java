package brandkon.product.dao;

import brandkon.brand.QBrand;
import brandkon.brand.QBrandCategory;
import brandkon.product.dto.ProductPopularResponse;
import brandkon.product.QProduct;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ProductDao {
    private final JPAQueryFactory queryFactory;

    private final QProduct qProduct = QProduct.product;
    private final QBrand qBrand = QBrand.brand;
    private final QBrandCategory qBrandCategory = QBrandCategory.brandCategory;

    public List<ProductPopularResponse> findAllByFiltersOrderBySalesDesc(Long categoryId, Long brandId) {


        return queryFactory.select(
                        Projections.constructor(
                                ProductPopularResponse.class,
                                qProduct.id,
                                qProduct.brand.name,
                                qProduct.name,
                                qProduct.price,
                                qProduct.imageUrl,
                                qProduct.sales))
                .from(qProduct)
                .join(qProduct.brand, qBrand)
                .join(qBrand.categories, qBrandCategory)
                .where(categoryIdEq(categoryId),
                        brandIdEq(brandId))
                .orderBy(qProduct.sales.desc())
                .limit(5)
                .fetch();
    }

    private BooleanExpression categoryIdEq(Long categoryId) {
        return categoryId != null ? qBrandCategory.CategoryId.eq(categoryId) : null;
    }

    private BooleanExpression brandIdEq(Long brandId){
        return brandId != null ? qProduct.brand.id.eq(brandId) : null;
    }
}
