/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.mylibe.model.DAO;

import br.mylibe.model.enums.BookClass;
import br.mylibe.model.negocio.BookBean;
import br.mylibe.model.negocio.UserBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mady
 */
public class BookDAO {

    private Connection con;

    public BookDAO() throws SQLException {
        this.con = ConnectionFactory.getConnection();
    }

    /**
     * CreateReadUpdateDelete - CRUD
     *
     */
    public int create(BookBean book) throws SQLException {
        if (book == null) {
            return 0;
        }
        String sql = "INSERT INTO book (name, writer, description, pages, type, user_id) values (?, ?, ?, ?, ?, ?)";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setString(1, book.getName());
        stmt.setString(2, book.getWriter());
        stmt.setString(3, book.getDescription());
        stmt.setInt(4, book.getPages());
        stmt.setString(5, (book.getType().toString()));
        stmt.setInt(6, book.getUser().getId());

        int retorno = stmt.executeUpdate();
        stmt.close();
        return retorno;
    }

    public BookBean read(int id) throws SQLException {
        String sql = "SELECT * FROM book WHERE id = ?";
        PreparedStatement stmt = this.con.prepareStatement(sql);
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();
        BookBean book = null;
        if (rs.next()) {
            book = new BookBean();
            book.setId(rs.getInt("id"));
            book.setName(rs.getString("name"));
            book.setWriter(rs.getString("writer"));
            book.setDescription(rs.getString("description"));
            book.setPages(rs.getInt("pages"));            
            book.setType(BookClass.valueOf(rs.getString("type")));
            book.setUser(new UserDAO().read(rs.getInt("id")));
        }
        rs.close();
        stmt.close();
        return book;
    }

    public int update(BookBean book) throws SQLException {
        if (book == null) {
            return 0;
        }
        String sql = "UPDATE book SET name = ?, writer = ?, "
                + " description = ?, pages = ?, type = ?, user_id = ? WHERE id = ? ";
        PreparedStatement stmt = this.con.prepareStatement(sql);

        stmt.setString(1, book.getName());
        stmt.setString(2, book.getWriter());
        stmt.setString(3, book.getDescription());
        stmt.setInt(4, book.getPages());               
        stmt.setString(5, (book.getType().toString()));
        stmt.setInt(6, book.getUser().getId());
        stmt.setInt(7, book.getId());

        int retorno = stmt.executeUpdate();
        stmt.close();
        return retorno;
    }

    public int delete(BookBean book) throws SQLException {
        if (book == null) {
            return 0;
        }
        String sql = "DELETE FROM book WHERE id = ?";
        PreparedStatement stmt = this.con.prepareStatement(sql);
        stmt.setInt(1, book.getId());
        int retorno = stmt.executeUpdate();
        stmt.close();
        return retorno;
    }

    public List<BookBean> list() throws SQLException {
        String sql = "SELECT * FROM book";
        PreparedStatement stmt = this.con.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        List<BookBean> books = new ArrayList<BookBean>();
        while (rs.next()) {
            BookBean book = new BookBean();
            book.setId(rs.getInt("id"));
            book.setName(rs.getString("name"));
            book.setWriter(rs.getString("writer"));
            book.setDescription(rs.getString("description"));
            book.setPages(rs.getInt("pages"));
            book.setType(BookClass.valueOf(rs.getString("type")));
            book.setUser(new UserDAO().read(rs.getInt("id")));
            
            books.add(book);
        }
        rs.close();
        stmt.close();
        return books;
    }

    public List<BookBean> list(String filter) throws SQLException {
        String sql = "SELECT * FROM book WHERE name LIKE ?";
        PreparedStatement stmt = this.con.prepareStatement(sql);
        stmt.setString(1, "%" + filter + "%");
        ResultSet rs = stmt.executeQuery();
        List<BookBean> books = new ArrayList<BookBean>();
        while (rs.next()) {
            BookBean book = new BookBean();
            book.setId(rs.getInt("id"));
            book.setName(rs.getString("name"));
            book.setWriter(rs.getString("writer"));
            book.setDescription(rs.getString("description"));
            book.setPages(rs.getInt("pages"));             
            book.setType(BookClass.valueOf(rs.getString("type")));
            book.setUser(new UserDAO().read(rs.getInt("id")));
            books.add(book);
        }
        rs.close();
        stmt.close();
        return books;
    }

}
