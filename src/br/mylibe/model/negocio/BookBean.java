package br.mylibe.model.negocio;

import br.mylibe.model.enums.BookClass;
import java.io.Serializable;

/**
 * @author mady
 * @project myLibe
 */
public class BookBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private int id;
    private String name;
    private String writer;
    private String description;
    private int pages;
    private BookClass type;
    private UserBean user;

    public BookBean() {
        
    }

    public UserBean getUser() {
        return user;
    }

    public void setUser(UserBean user) {
        this.user = user;
    }

    public BookClass getType() {
        return type;
    }

    public void setType(BookClass type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }
}
