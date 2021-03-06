package Model;
// Generated May 13, 2020 2:57:43 PM by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * Book generated by hbm2java
 */
public class Book  implements java.io.Serializable {


     private String bookId;
     private String title;
     private String publicationHouse;
     private Date dateOfPublication;
     private String author;
     private Integer page;
     private String bookcategorie;

    public Book() {
    }

	
    public Book(String bookId, String title, String publicationHouse, Date dateOfPublication) {
        this.bookId = bookId;
        this.title = title;
        this.publicationHouse = publicationHouse;
        this.dateOfPublication = dateOfPublication;
    }
    public Book(String bookId, String title, String publicationHouse, Date dateOfPublication, String author, Integer page, String bookcategorie) {
       this.bookId = bookId;
       this.title = title;
       this.publicationHouse = publicationHouse;
       this.dateOfPublication = dateOfPublication;
       this.author = author;
       this.page = page;
       this.bookcategorie = bookcategorie;
    }
   
    public String getBookId() {
        return this.bookId;
    }
    
    public void setBookId(String bookId) {
        this.bookId = bookId;
    }
    public String getTitle() {
        return this.title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    public String getPublicationHouse() {
        return this.publicationHouse;
    }
    
    public void setPublicationHouse(String publicationHouse) {
        this.publicationHouse = publicationHouse;
    }
    public Date getDateOfPublication() {
        return this.dateOfPublication;
    }
    
    public void setDateOfPublication(Date dateOfPublication) {
        this.dateOfPublication = dateOfPublication;
    }
    public String getAuthor() {
        return this.author;
    }
    
    public void setAuthor(String author) {
        this.author = author;
    }
    public Integer getPage() {
        return this.page;
    }
    
    public void setPage(Integer page) {
        this.page = page;
    }
    public String getBookcategorie() {
        return this.bookcategorie;
    }
    
    public void setBookcategorie(String bookcategorie) {
        this.bookcategorie = bookcategorie;
    }




}


