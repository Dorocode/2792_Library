/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.Book;
import Model.Bookcategorie;
import Util.InitalConn;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Mugara Steven
 */
public class BookCategoryDao extends InitalConn{

    public void insertBookCat(Bookcategorie bct) {
        Session session = Util.GetConnection.getSessionFactory().openSession();
        Transaction tr = session.beginTransaction();
        try {
            session.save(bct);
            tr.commit();
        } finally {
            session.close();
        }
    }

    public void deleteBookCategory(String id){
        Session session=Util.GetConnection.getSessionFactory().openSession();
        Transaction tr=session.beginTransaction();
        try{
            Bookcategorie bookc=(Bookcategorie) session.load(Bookcategorie.class, id);
            session.delete(bookc);
            tr.commit();
            tr=null;
        }finally{
        session.close();
        }
    }
    public void upDateBCategory(Bookcategorie bc){
        Session session=Util.GetConnection.getSessionFactory().openSession();
        Transaction tr=session.beginTransaction();
        try{
            Bookcategorie bookc=(Bookcategorie) session.load(Bookcategorie.class, bc.getCategorieId());
            bookc.setCategorieName(bc.getCategorieName());
            session.update(bookc);
            tr.commit();
            tr=null;
        }finally{
            session.clear();
        }
    }
    public List<Bookcategorie> listBookCat() {
        Session session = Util.GetConnection.getSessionFactory().openSession();
        String HQL = "from BookCategory";
        Query q = session.createQuery(HQL);
        List<Bookcategorie> list = q.list();
        for (Bookcategorie bct : list) {
            bct.getCategorieId();
            bct.getCategorieName();
            list.add(bct);
        }
        return list;
    }
     public List<Bookcategorie> listBookCategories() {
        List<Bookcategorie> bookcategorie = new ArrayList<>();
        connect();
        try {
            st = conn.createStatement();
            String list = "SELECT * FROM bookCategorie;";
            rs = st.executeQuery(list);
            while (rs.next()) {
                Bookcategorie obj = new Bookcategorie();
                obj.setCategorieId(rs.getString(1));
                obj.setCategorieName(rs.getString(2));
                bookcategorie.add(obj);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            disconnect();
        }
        return bookcategorie;
    }
}
