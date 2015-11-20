package br.mylibe.model.negocio;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 *
 * @author mady
 */
public class ReadBookBean implements Serializable{
    private static final long serialVersionUID = 1L;
    
    private Date beginReadDate;
    private Date endReadDate;
    private List<BookBean> books;
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

    public List<BookBean> getBooks() {
        return books;
    }

    public void setBooks(List<BookBean> books) {
        this.books = books;
    }

    public UserBean getUser() {
        return user;
    }

    public void setUser(UserBean user) {
        this.user = user;
    }
    
    
}
