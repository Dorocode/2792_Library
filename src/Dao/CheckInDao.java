/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.Returnedbook;
import Util.InitalConn;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Mugara Steven
 */
public class CheckInDao extends InitalConn{
    public void saveCheckIn(Returnedbook cin){
        Session session =Util.GetConnection.getSessionFactory().openSession();
        Transaction tr=session.beginTransaction();
        try{
            Returnedbook rt= new Returnedbook();
            rt.setBookName(cin.getBookName());
            rt.setClientName(cin.getClientName());
            rt.setDates(cin.getDates());
            rt.setStatus(cin.getStatus());
            session.save(cin);
            tr.commit();
        }finally{
        session.close();
        }
    }
    public void searClient(String name) {
        Session session =Util.GetConnection.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            Returnedbook ret = new Returnedbook();
            ret.setClientName(name);
            Query q = session.createQuery("From ReturnedBook where clientName =" + ret.getClientName());
            Returnedbook stu = (Returnedbook) q.uniqueResult();
            transaction.commit();
        } finally {
            session.close();
        }
    }
    public List<Returnedbook> listofReturnedBook() {
        List<Returnedbook> returnedBook = new ArrayList<>();
        connect();
        try {
            st = conn.createStatement();
            String list = "SELECT * FROM ReturnedBook;";
            rs = st.executeQuery(list);
            while (rs.next()) {
                Returnedbook obj = new Returnedbook();
                obj.setClientName(rs.getString(1));
                obj.setBookName(rs.getString(2));
                obj.setStatus(rs.getString(3));
                obj.setDates(rs.getString(4));
                returnedBook.add(obj);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            disconnect();
        }
        return returnedBook;
    }
}
