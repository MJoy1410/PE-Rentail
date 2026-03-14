/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.repository;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import pe.model.Account;
import pe.utils.JPAUtils;

/**
 *
 * @author Trần Minh Tuấn
 */
public class AccountRepository {

    public void insertAccount(Account a) {
        EntityManager em = JPAUtils.getEntityManager();
        em.getTransaction().begin();
        em.persist(a);
        em.getTransaction().commit();
        em.close();
    }

    public void deleteAccount(Object id) {
        EntityManager em = JPAUtils.getEntityManager();
        Account a = em.find(Account.class, id);

        em.getTransaction().begin();
        em.remove(a);
        em.getTransaction().commit();
        em.close();
    }

    public Account getAccount(Object id) {
        EntityManager em = JPAUtils.getEntityManager();
        Account a = em.find(Account.class, id);

        em.close();
        return a;
    }

    public void updateAccount(Account a) {
        EntityManager em = JPAUtils.getEntityManager();
        em.getTransaction().begin();
        em.merge(a);
        em.getTransaction().commit();
        em.close();
    }

    public List<Account> listAll() {
        EntityManager em = JPAUtils.getEntityManager();

        TypedQuery<Account> query = em.createQuery("Select a FROM Account a", Account.class);

        List<Account> list = query.getResultList();
        em.close();
        return list;
    }

    public Account checkLogin(String userName, String pass) {
        EntityManager em = JPAUtils.getEntityManager();
        String jpql = "Select a FROM Account a WHERE a.username=:u AND a.password=:p";

        TypedQuery<Account> query = em.createQuery(jpql, Account.class);
        query.setParameter("u", userName);
        query.setParameter("p", pass);
        List<Account> list = query.getResultList();

        em.close();

        if (list.isEmpty()) {
            return null;
        }

        return list.get(0);
    }

}
