/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.repository;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import pe.model.RoomForRent;
import pe.utils.JPAUtils;

/**
 *
 * @author Trần Minh Tuấn
 */
public class RoomRepository {

    public void insertRoom(RoomForRent r) {
        EntityManager em = JPAUtils.getEntityManager();
        em.getTransaction().begin();
        em.persist(r);
        em.getTransaction().commit();
        em.close();
    }

    public void deleteRoom(Object id) {
        EntityManager em = JPAUtils.getEntityManager();
        RoomForRent r = em.find(RoomForRent.class, id);

        em.getTransaction().begin();
        em.remove(r);
        em.getTransaction().commit();
        em.close();
    }

    public RoomForRent getRoom(Object id) {
        EntityManager em = JPAUtils.getEntityManager();
        RoomForRent r = em.find(RoomForRent.class, id);
        em.close();
        return r;
    }

    public void updateRoom(RoomForRent r) {
        EntityManager em = JPAUtils.getEntityManager();
        em.getTransaction().begin();
        em.merge(r);
        em.getTransaction().commit();
        em.close();
    }

    public List<RoomForRent> listAll() {
        EntityManager em = JPAUtils.getEntityManager();

        TypedQuery<RoomForRent> query = em.createQuery("SELECT r FROM RoomForRent r", RoomForRent.class);
        List<RoomForRent> list = query.getResultList();

        em.close();
        return list;
    }

}
