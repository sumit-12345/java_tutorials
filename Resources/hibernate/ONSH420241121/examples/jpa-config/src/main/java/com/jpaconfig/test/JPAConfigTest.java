package com.jpaconfig.test;

import com.jpaconfig.dao.RechargePlanDao;
import com.jpaconfig.entities.RechargePlan;
import com.jpaconfig.helper.EntityManagerFactoryRegistry;

public class JPAConfigTest {
    public static void main(String[] args) {

        RechargePlan plan = new RechargePlan();
        plan.setPlanNo(1);
        plan.setPlanName("399 Unlimited Plan");
        plan.setCircle("AP");
        plan.setValidityDays(30);
        plan.setDescription("Unlimited Text/Talk Local");
        plan.setRechargeAmount(399);

        try {
            RechargePlanDao dao = new RechargePlanDao();
            dao.saveRechargePlan(plan);
            System.out.println("recharge plan saved!");
        } finally {
            EntityManagerFactoryRegistry.closeEntityManagerFactory();
        }
    }
}
