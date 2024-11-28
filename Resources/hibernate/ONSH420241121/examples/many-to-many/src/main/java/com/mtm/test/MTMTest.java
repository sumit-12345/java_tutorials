package com.mtm.test;

import com.mtm.entities.Passenger;
import com.mtm.entities.Trip;
import com.mtm.helper.EMFRegistry;
import com.mysql.cj.protocol.PacketSentTimeHolder;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class MTMTest {
    public static void main(String[] args) {

        try {
            /*Passenger passenger = Passenger.of()
                    .fullName("Joseph M")
                    .age(24)
                    .gender("Male")
                    .mobileNo("917377443534")
                    .emailAddress("joseph@gmail.com")
                    .build();
            int passengerNo = savePassenger(passenger);
            System.out.println("passenger no : " + passengerNo);*/

            /*Passenger passenger1 = getPassenger(1);
            Passenger passenger2= getPassenger(2);

            Set<Passenger> passengers = new HashSet<>();
            passengers.add(passenger1);
            passengers.add(passenger2);

            Trip trip = Trip.of()
                    .source("Hyderabad")
                    .destination("Banglore")
                    .journeyDate(LocalDate.now().plusDays(7))
                    .days(5)
                    .cost(35000)
                    .passengers(passengers).build();

            int tripNo = saveTrip(trip);
            System.out.println("trip no : " + tripNo);*/
            printTrip(1);

        } finally {
            EMFRegistry.closeEntityManagerFactory();
        }
    }

    private static Passenger getPassenger(int passengerNo) {
        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;
        Passenger passenger = null;
        try {
            entityManagerFactory = EMFRegistry.getEntityManagerFactory();
            entityManager = entityManagerFactory.createEntityManager();

            passenger = entityManager.find(Passenger.class, passengerNo);
        } finally {
            if (entityManager != null) {

                entityManager.close();
            }
        }
        return passenger;
    }

    private static void printTrip(int tripNo) {
        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;
        Trip trip = null;
        try {
            entityManagerFactory = EMFRegistry.getEntityManagerFactory();
            entityManager = entityManagerFactory.createEntityManager();

            trip = entityManager.find(Trip.class, tripNo);
            System.out.println(trip);
        } finally {
            if (entityManager != null) {

                entityManager.close();
            }
        }

    }

    private static int savePassenger(Passenger passenger) {
        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;
        EntityTransaction entityTransaction = null;
        boolean flag = false;
        int passengerNo = 0;
        try {
            entityManagerFactory = EMFRegistry.getEntityManagerFactory();
            entityManager = entityManagerFactory.createEntityManager();
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();

            entityManager.persist(passenger);
            passengerNo = passenger.getPassengerNo();

            flag = true;
        } finally {
            if (entityTransaction != null) {
                if (flag) {
                    entityTransaction.commit();
                } else {
                    entityTransaction.rollback();
                }
                entityManager.close();
            }
        }
        return passengerNo;
    }

    private static int saveTrip(Trip trip) {
        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;
        EntityTransaction entityTransaction = null;
        boolean flag = false;
        int tripNo = 0;
        try {
            entityManagerFactory = EMFRegistry.getEntityManagerFactory();
            entityManager = entityManagerFactory.createEntityManager();
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();

            entityManager.persist(trip);
            tripNo = trip.getTripNo();

            flag = true;
        } finally {
            if (entityTransaction != null) {
                if (flag) {
                    entityTransaction.commit();
                } else {
                    entityTransaction.rollback();
                }
                entityManager.close();
            }
        }
        return tripNo;
    }
}
