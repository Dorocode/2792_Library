/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.Withdrowbook;
import Util.InitalConn;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Mugara Steven
 */
public class CheckOutDao extends InitalConn{
    public void savecheckout(Withdrowbook cout){
        Session session =Util.GetConnection.getSessionFactory().openSession();
        Transaction tr=session.beginTransaction();
        try {
            Withdrowbook with = new Withdrowbook();
            with.setBookName(cout.getBookName());
            with.setClientName(cout.getClientName());
            with.setDates(cout.getDates());
            with.setStatus(cout.getStatus());
            session.save(with);
            tr.commit();
        } finally {
            session.close();
        }
    }
    public void delete(String id){
        Session session =Util.GetConnection.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try{
            Withdrowbook book = new Withdrowbook();
            book = (Withdrowbook) session.load(Withdrowbook.class, id);
            session.delete(book);
            transaction.commit();
        }finally{
            session.close();
        }
    }
    public List<Withdrowbook> listofwithdrowBook() {
        List<Withdrowbook> withdrowBook = new ArrayList<>();
        connect();
        try {
            st = conn.createStatement();
            String list = "SELECT * FROM WithDrowBook;";
            rs = st.executeQuery(list);
            while (rs.next()) {
                Withdrowbook obj = new Withdrowbook();
                obj.setClientName(rs.getString(1));
                obj.setBookName(rs.getString(2));
                obj.setStatus(rs.getString(3));
                obj.setDates(rs.getString(4));
                withdrowBook.add(obj);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            disconnect();
        }
        return withdrowBook;
    }
}  
