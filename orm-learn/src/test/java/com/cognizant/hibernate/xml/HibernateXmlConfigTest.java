package com.cognizant.hibernate.xml;

import org.junit.jupiter.api.Test;

public class HibernateXmlConfigTest {

    @Test
    void explainHibernateXmlConfiguration() {

        System.out.println("===== Hibernate XML Configuration =====");

        System.out.println("1. SessionFactory");
        System.out.println("   - Created once during application startup.");
        System.out.println("   - Reads hibernate.cfg.xml.");
        System.out.println("   - Creates Session objects.");

        System.out.println("2. Session");
        System.out.println("   - Represents a connection with the database.");
        System.out.println("   - Used for CRUD operations.");

        System.out.println("3. Transaction");
        System.out.println("   - Maintains data consistency.");
        System.out.println("   - beginTransaction() starts a transaction.");
        System.out.println("   - commit() permanently saves changes.");
        System.out.println("   - rollback() cancels changes if an error occurs.");

        System.out.println("4. CRUD Operations");
        System.out.println("   - session.save(object)");
        System.out.println("   - session.get(Entity.class, id)");
        System.out.println("   - session.createQuery(\"from Employee\").list()");
        System.out.println("   - session.delete(object)");

        System.out.println("=======================================");
    }
}