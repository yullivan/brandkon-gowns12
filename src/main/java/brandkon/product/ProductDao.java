package brandkon.product;

import brandkon.brand.QBrand;
import brandkon.category.entity.QCategory;
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
    private final QCategory qCategory = QCategory.category;
    private final QBrand qBrand = QBrand.brand;

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
                .leftJoin(qProduct.brand, qBrand)
                .leftJoin(qBrand.category, qCategory)
                .where(categoryIdEq(categoryId),
                        brandIdEq(brandId))
                .orderBy(qProduct.sales.desc())
                .limit(5)
                .fetch();
    }

    private BooleanExpression categoryIdEq(Long categoryId) {
        return categoryId != null ? qBrand.category.id.eq(categoryId) : null;
    }

    private BooleanExpression brandIdEq(Long brandId){
        return brandId != null ? qProduct.brand.id.eq(brandId) : null;
    }
}
