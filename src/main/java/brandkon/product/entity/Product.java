package brandkon.product.entity;

import brandkon.brand.entity.Brand;
import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
@EqualsAndHashCode
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer price;
    private String imageUrl;
    private Integer expirationDays;
    private Integer sales;
    @ManyToOne
    private Brand brand;
}
