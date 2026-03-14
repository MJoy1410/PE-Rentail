/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Trần Minh Tuấn
 */
public class JPAUtils {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("PE_Prj301PU");

    public static EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
}
