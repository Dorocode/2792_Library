/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.Book;
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
public class BookDao extends InitalConn{
    public void insertBook(Book book){
        Session session=Util.GetConnection.getSessionFactory().openSession();
        Transaction tr=session.beginTransaction();
        session.save(book);
        tr.commit();
        session.close();
    }
    public void deleteBook(String id){
        Session session=Util.GetConnection.getSessionFactory().openSession();
        Transaction tr=session.beginTransaction();
        try{
            Book book=(Book) session.load(Book.class, id);
            session.delete(book);
            tr.commit();
            tr=null;
        }finally{
            session.close();
        }
    }
    
    
    public void upDateBook(Book b){
        Session session=Util.GetConnection.getSessionFactory().openSession();
        Transaction tr=session.beginTransaction();
        try{
            Book book=(Book) session.load(Book.class, b.getBookId());
            book.setTitle(b.getTitle());
            book.setPublicationHouse(b.getPublicationHouse());
            book.setDateOfPublication(b.getDateOfPublication());
            book.setAuthor(b.getAuthor());
            book.setPage(b.getPage());
            book.setBookcategorie(b.getBookcategorie());
            session.update(book);
            tr.commit();
            tr=null;
        }finally{
            session.close();
        }
    }
    public List<Book> listBook(){
        Session session=Util.GetConnection.getSessionFactory().openSession();
        String HQL ="from Book";
        Query q=session.createQuery(HQL);
        List<Book> list=q.list();
        for(Book booklist: list){
            booklist.getBookId();
            booklist.getTitle();
            booklist.getPublicationHouse();
            booklist.getDateOfPublication();
            booklist.getAuthor();
            booklist.getBookId();
            list.add(booklist);
        }
        return list;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public List<Book> listBooks() {
        List<Book> book = new ArrayList<>();
        connect();
        try {
            st = conn.createStatement();
            String list = "SELECT * FROM book;";
            rs = st.executeQuery(list);
            while (rs.next()) {
                Book obj = new Book();
                obj.setBookId(rs.getString(1));
                obj.setTitle(rs.getString(2));
                obj.setPublicationHouse(rs.getString(3));
                obj.setDateOfPublication(rs.getDate(4));
                obj.setAuthor(rs.getString(5));
                obj.setPage(rs.getInt(6));
                obj.setBookcategorie(rs.getString(7));

                book.add(obj);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            disconnect();
        }
        return book;
    }
}
