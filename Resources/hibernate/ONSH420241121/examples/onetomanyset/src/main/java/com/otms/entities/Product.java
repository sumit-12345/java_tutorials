package com.otms.entities;

import com.otms.bean.BasicProduct;
import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "product")
@NamedQueries({
        @NamedQuery(name = "productsGreaterThanPrice", query = "from Product p where p.price > :price")
})
@NamedNativeQueries({
        @NamedNativeQuery(name = "productsByCategory", query = "select p.product_no, p.product_nm, p.category, p.price from product p where p.category like :category")
})
@SqlResultSetMappings({
        @SqlResultSetMapping(name = "BasicProductMapping",
                classes = {@ConstructorResult(targetClass = BasicProduct.class, columns = {
                        @ColumnResult(name = "product_no", type = Integer.class),
                        @ColumnResult(name = "product_nm", type = String.class),
                        @ColumnResult(name = "price", type = Double.class)
                })}
        )
})
@NamedStoredProcedureQueries({
        @NamedStoredProcedureQuery(name = "findProductPrice", procedureName = "hibdb.find_product_price",
                parameters = {
                        @StoredProcedureParameter(name = "product_no", type = Integer.class, mode = ParameterMode.IN),
                        @StoredProcedureParameter(name = "price", type = Double.class, mode = ParameterMode.OUT)
                })
})
public class Product implements Serializable {
    @Id
    @Column(name = "product_no")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int productNo;
    @Column(name = "product_nm")
    private String productName;
    private String description;
    private String category;
    private double price;

    @ManyToOne
    @JoinColumn(name = "manufacturer_no")
    private Manufacturer manufacturer;

    public int getProductNo() {
        return productNo;
    }

    public void setProductNo(int productNo) {
        this.productNo = productNo;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productNo=" + productNo +
                ", productName='" + productName + '\'' +
                ", description='" + description + '\'' +
                ", category='" + category + '\'' +
                ", price=" + price +
                '}';
    }
}
