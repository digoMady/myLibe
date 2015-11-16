package br.mylibe.model.negocio;

import java.io.Serializable;

/**
 *
 * @author mady
 */
public class ReadBookBean implements Serializable{
    private static final long serialVersionUID = 1L;
    
    private Date beginReadDate;
    private Date endReadDate;
    private BookBean book;
    private UserBean user;

    public Date getBeginReadDate() {
        return beginReadDate;
    }

    public void setBeginReadDate(Date beginReadDate) {
        this.beginReadDate = beginReadDate;
    }

    public Date getEndReadDate() {
        return endReadDate;
    }

    public void setEndReadDate(Date endReadDate) {
        this.endReadDate = endReadDate;
    }

    public BookBean getBook() {
        return book;
    }

    public void setBook(BookBean book) {
        this.book = book;
    }

    public UserBean getUser() {
        return user;
    }

    public void setUser(UserBean user) {
        this.user = user;
    }
    
    
}
