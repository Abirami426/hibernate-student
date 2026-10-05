package com.student.app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.student.entity.Student;
import com.student.util.HibernateUtil;

public class StudentApp {

    public static void main(String[] args) {

        SessionFactory factory = HibernateUtil.getSessionFactory();

        Session session = factory.openSession();

        Transaction transaction = session.beginTransaction();

        // Find student with ID 1
        Student student = session.get(Student.class, 1);

        // Update the course
        student.setCourse("Data Analytics");

        transaction.commit();

        System.out.println("Student updated successfully!");

        System.out.println("ID: " + student.getId());
        System.out.println("Name: " + student.getName());
        System.out.println("Email: " + student.getEmail());
        System.out.println("Course: " + student.getCourse());

        session.close();
        factory.close();
    }
}