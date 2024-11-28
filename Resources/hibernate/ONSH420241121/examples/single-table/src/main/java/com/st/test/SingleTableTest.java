package com.st.test;

import com.st.dao.PaymentDao;
import com.st.entities.CardPayment;
import com.st.entities.ChequePayment;
import com.st.entities.Payment;
import com.st.helper.EMFRegistry;

import java.time.LocalDate;

public class SingleTableTest {
    public static void main(String[] args) {

        try {
            PaymentDao paymentDao = new PaymentDao();
            /*Payment payment = new Payment();

            payment.setBillNo("bn010");
            payment.setPaymentDate(LocalDate.now());
            payment.setDescription("groceries");
            payment.setPaymentStatus("paid");
            payment.setAmount(230);*/
            /*CardPayment payment = new CardPayment();
            payment.setBillNo("bn210");
            payment.setPaymentDate(LocalDate.now());
            payment.setDescription("groceries");
            payment.setPaymentStatus("paid");
            payment.setAmount(230);
            payment.setCardNumber("8789-9890-9839-7656");
            payment.setCardType("credit");
            payment.setIssuer("visa");
            payment.setExpiry("10/25");*/

            /*ChequePayment payment = new ChequePayment();
            payment.setBillNo("bn310");
            payment.setPaymentDate(LocalDate.now());
            payment.setDescription("utensils");
            payment.setPaymentStatus("paid");
            payment.setAmount(1230);

            payment.setBankName("SBI");
            payment.setChequeDate(LocalDate.now().plusDays(2));
            payment.setChequeNo("CHQ001923");
            payment.setPayeeAccountNo("SBI039838");
            payment.setPayeeName("Gulshan Enterprises");

            int id = paymentDao.savePayment(payment);
            System.out.println("payment id: " + id);*/

            /*ChequePayment chequePayment = paymentDao.findChequePayment(2);
            System.out.println(chequePayment);*/

            Payment payment = paymentDao.findPayment(3);
            System.out.println(payment);

        } finally {
            EMFRegistry.closeEntityManagerFactory();
        }
    }


}
