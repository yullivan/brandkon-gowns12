package brandkon.brand.repository;

import brandkon.brand.entity.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BrandRepository extends JpaRepository<Brand,Long> {

    @Query("SELECT b FROM Brand b JOIN b.categories bc JOIN Category c ON c.id = bc.CategoryId WHERE c.slug = :slug")
    List<Brand> findByCategory_Slug(@Param("slug") String slug);

}
