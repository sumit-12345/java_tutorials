package com.tpc.test;

import com.tpc.dao.ProductDao;
import com.tpc.entities.Product;
import com.tpc.entities.Shoe;
import com.tpc.entities.Wallet;
import com.tpc.helper.EMFRegistry;

public class TPCTest {
    public static void main(String[] args) {
        try {
            ProductDao productDao = new ProductDao();
            /*Shoe shoe = Shoe.of().productName("Pointed Leather shoe")
                    .description("black leather shoe")
                    .soleType("rubber")
                    .purpose("office")
                    .size(9)
                    .price(3500).build();
            int id = productDao.saveProduct(shoe);*/
            /*Wallet wallet = Wallet.of().productName("Mens Wallet")
                    .description("black leather wallet")
                    .price(3500)
                    .material("leather")
                    .sections(2)
                    .walletType("General")
                    .build();
            int id = productDao.saveProduct(wallet);
            System.out.println("id : " + id);*/

            /*Shoe shoe = productDao.findShoe(1);
            System.out.println(shoe);*/

            Product product = productDao.findProduct(2);
            System.out.println(product);
        } finally {
            EMFRegistry.closeEntityManagerFactory();
        }
    }
}
