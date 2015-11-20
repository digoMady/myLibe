package br.mylibe.model.negocio;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author mady
 */
public class WishListBean implements Serializable{
    private static final long serialVersionUID = 1L;
    
    private int id;
    private BookBean book;
    private Date dateOfWish;
    private int active; //0 ou 1

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BookBean getBook() {
        return book;
    }

    public void setBook(BookBean book) {
        this.book = book;
    }

    public Date getDateOfWish() {
        return dateOfWish;
    }

    public void setDateOfWish(Date dateOfWish) {
        this.dateOfWish = dateOfWish;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }
    
    
    
}
