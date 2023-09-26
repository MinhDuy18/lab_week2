package vn.edu.iuh.fit.lab2_week2.models;

import jakarta.persistence.*;
import vn.edu.iuh.fit.lab2_week2.enums.ProductStatus;
import java.util.List;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @Column(name = "product_id", columnDefinition = "bigint(20)")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    private String description;

    private String unit;
    @Column(name = "manufacturer_name")
    private String manufacturerName;

    @Enumerated(EnumType.ORDINAL)
    @Column(columnDefinition = "int")
    private ProductStatus status;

    @OneToMany(mappedBy = "product")
    private List<ProductImage> productImageList;
    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
    private List<OrderDetail> orderDetailList;

    @OneToMany(mappedBy = "product")
    private List<ProductPrice>  productPrices;

    public Product() {
    }

    public Product(long id, String name, String description, String unit, String manufacturerName, ProductStatus status, List<ProductImage> productImageList, List<OrderDetail> orderDetailList, List<ProductPrice> productPrices) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.unit = unit;
        this.manufacturerName = manufacturerName;
        this.status = status;
        this.productImageList = productImageList;
        this.orderDetailList = orderDetailList;
        this.productPrices = productPrices;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", unit='" + unit + '\'' +
                ", manufacturerName='" + manufacturerName + '\'' +
                ", status=" + status +
                ", productImageList=" + productImageList +
                ", orderDetailList=" + orderDetailList +
                ", productPrices=" + productPrices +
                '}';
    }
}
