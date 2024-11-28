package com.tpsc.test;

import com.tpsc.dao.TelevisionDao;
import com.tpsc.entities.LCDTelevision;
import com.tpsc.entities.LEDTelevision;
import com.tpsc.entities.Television;
import com.tpsc.helper.EMFRegistry;

public class JoinedTest {
    public static void main(String[] args) {
        try {
            TelevisionDao dao = new TelevisionDao();

            /*Television television = new Television();
            television.setSerialNo("S00293");
            television.setModelName("Blue diamond Color TV");
            television.setDimensions("24inch Tv");
            television.setManufacturer("Sharp");
            television.setPrice(23000);*/

            /*LCDTelevision television = new LCDTelevision();
            television.setSerialNo("S3839");
            television.setModelName("Full HD LCD Television");
            television.setDimensions("32inch Tv");
            television.setManufacturer("Samsung");
            television.setPrice(32000);
            television.setPanelType("A Panel");
            television.setResolution("21372");*/

            /*LEDTelevision television = new LEDTelevision();
            television.setSerialNo("S3993");
            television.setModelName("Micro LED Television");
            television.setDimensions("50 Inch Tv");
            television.setManufacturer("LG");
            television.setPrice(123000);
            television.setLedTechnology("Micro");
            television.setRefreshRate(90);

            int productCode = dao.saveTelevision(television);
            System.out.println("product code : " + productCode);*/

            /*LEDTelevision ledTelevision = dao.findLEDTelevision(3);
            System.out.println(ledTelevision);*/

            Television television = dao.findTelevision(2);
            System.out.println(television);

        } finally {
            EMFRegistry.closeEntityManagerFactory();
        }
    }
}
