package com.cognizant.hibernate.annotation;

import org.junit.jupiter.api.Test;

public class HibernateAnnotationConfigTest {

    @Test
    void explainHibernateAnnotations() {

        System.out.println("===== Hibernate Annotation Configuration =====");

        System.out.println("@Entity");
        System.out.println(" - Marks a Java class as a database entity.");

        System.out.println("@Table");
        System.out.println(" - Maps the entity to a table.");

        System.out.println("@Id");
        System.out.println(" - Represents the primary key.");

        System.out.println("@GeneratedValue");
        System.out.println(" - Generates primary key values automatically.");

        System.out.println("@Column");
        System.out.println(" - Maps a field to a database column.");

        System.out.println("\nHibernate Configuration");

        System.out.println("Dialect");
        System.out.println(" - Specifies the SQL dialect (MySQL, Oracle, etc.).");

        System.out.println("Driver");
        System.out.println(" - JDBC Driver class.");

        System.out.println("Connection URL");
        System.out.println(" - Database connection string.");

        System.out.println("Username");
        System.out.println(" - Database username.");

        System.out.println("Password");
        System.out.println(" - Database password.");

        System.out.println("==============================================");
    }
}