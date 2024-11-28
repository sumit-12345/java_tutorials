package com.idgen.test;

import com.idgen.dao.ProductDao;
import com.idgen.entities.Product;
import com.idgen.helper.EntityManagerFactoryRegistry;

public class IDGeneratorTest {
    public static void main(String[] args) {
        Product product = null;
        ProductDao dao = null;

        try {
            dao = new ProductDao();
            product = new Product();
            product.setProductName("LED 32 Inch Television");
            product.setCategory("Electronics");
            product.setManufacturer("Samsung");
            product.setPrice(30450);
            String productNo = dao.saveProduct(product);
            System.out.println("product has been saved with product no : " + productNo);
        } finally {
            EntityManagerFactoryRegistry.closeEntityManagerFactory();
        }
    }
}
