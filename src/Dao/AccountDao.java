/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.Accounts;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Mugara Steven
 */
public class AccountDao {
   public void creatAccount(Accounts acc){
       Session session=Util.GetConnection.getSessionFactory().openSession();
       Transaction tr=session.beginTransaction();
       session.save(acc);
       tr.commit();
       session.close();
   } 
   public String loginAccount(String username){
       String password = null;
       Session session=Util.GetConnection.getSessionFactory().openSession();
       Transaction tr=session.beginTransaction();
       List accounts= session.createCriteria(Accounts.class).add(Restrictions.eq("username", username)).setProjection(Projections.property("passward")).list();
       tr.commit();
       session.close();
       for(Object a: accounts){
           password = a.toString();
       }
       return password;
   } 
}
