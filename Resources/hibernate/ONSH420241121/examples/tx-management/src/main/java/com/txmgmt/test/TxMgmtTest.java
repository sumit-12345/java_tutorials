package com.txmgmt.test;

import com.txmgmt.dao.JobDao;
import com.txmgmt.entities.Job;
import com.txmgmt.helper.SessionFactoryRegistry;

public class TxMgmtTest {
    public static void main(String[] args) {
        Job job = null;
        JobDao jobDao = null;

        try {
            jobDao = new JobDao();

            job = new Job();
            job.setJobNo(2);
            job.setJobTitle("Principle Application Engineer");
            job.setDescription("Java developer with hands-on experience on building enterprise applications");
            job.setDesignation("IC4");
            job.setLocation("Pune");
            job.setSalary(2500000);

            jobDao.saveJob(job);
        } finally {
            SessionFactoryRegistry.closeSessionFactory();
        }
    }
}
