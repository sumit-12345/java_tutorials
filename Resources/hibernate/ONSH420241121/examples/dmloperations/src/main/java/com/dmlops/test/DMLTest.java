package com.dmlops.test;

import com.dmlops.dao.TrafficChallanDao;
import com.dmlops.entities.TrafficChallan;

import java.time.LocalDate;

public class DMLTest {
    public static void main(String[] args) {
        TrafficChallanDao dao = new TrafficChallanDao();

        TrafficChallan trafficChallan = new TrafficChallan();
        trafficChallan.setChallanNo(10);
        trafficChallan.setChallanDate(LocalDate.now());
        trafficChallan.setReasonForChallan("Speed Violation");
        trafficChallan.setDriversLicenseNo("KN93AB02393");
        trafficChallan.setVehicleRegistrationNo("DH0393834");
        trafficChallan.setAmount(2500);

        /*dao.mergeTrafficChallan(trafficChallan);
        System.out.println("updated");*/

        //dao.updateTrafficChallan(10, "Speed Ticket", 1500);

        dao.deleteTrafficChallan(11);
    }
}
