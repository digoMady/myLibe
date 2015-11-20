/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.mylibe.model.DAO;

import br.mylibe.model.negocio.ReadBookBean;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author mady
 */
public class ReadBookDAO {

    private Connection con;

    public BookDAO() throws SQLException {
        this.con = ConnectionFactory.getConnection();
    }

    /**
     * CreateReadUpdateDelete - CRUD
     *
     */
    public int create(ReadBookBean read) throws SQLException {
        if (read == null) {
            return 0;
        }
        String sql = "INSERT INTO readBook (beginReadDate, book_id, book_user_id) "
                + "values (STR_TO_DATE(SYSDATE, '%d/%m/%Y'), ?, ? ))";

        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setInt(1, read.getBooks();
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
        String sql = "SELECT * FROM readBook r INNER JOIN book b ON r.book_id = b.id WHERE b.id = ?";
        PreparedStatement stmt = this.con.prepareStatement(sql);
        stmt.setInt(1, id);
        stmt.setString(2, hash);
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
        String sql = "UPDATE book b INNER JOIN user u ON b.user_id = u.id SET b.name = ?, b.writer = ?, "
                + " b.description = ?, b.pages = ?, b.type = ?, b.user_id = ? WHERE b.id = ? AND u.hash = ? ";
        PreparedStatement stmt = this.con.prepareStatement(sql);

        stmt.setString(1, book.getName());
        stmt.setString(2, book.getWriter());
        stmt.setString(3, book.getDescription());
        stmt.setInt(4, book.getPages());
        stmt.setString(5, (book.getType().toString()));
        stmt.setInt(6, book.getUser().getId());
        stmt.setInt(7, book.getId());
        stmt.setString(8, book.getUser().getHash());

        int retorno = stmt.executeUpdate();
        stmt.close();
        return retorno;
    }

    public int delete(BookBean book) throws SQLException {
        if (book == null) {
            return 0;
        }
        String sql = "DELETE FROM b USING book b WHERE b.id = ?";
        PreparedStatement stmt = this.con.prepareStatement(sql);
        stmt.setInt(1, book.getId());
        int retorno = stmt.executeUpdate();
        stmt.close();
        return retorno;
    }

    public List<ReadBookBean> list(String hash) throws SQLException {
        String sql = "SELECT * FROM readbook r INNER JOIN book b ON b.user_id = u.id WHERE u.hash = ? ";
        PreparedStatement stmt = this.con.prepareStatement(sql);
        stmt.setString(1, hash);
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

    public List<BookBean> list(String filter, String hash) throws SQLException {
        String sql = "SELECT * FROM book b INNER JOIN user u ON b.user_id = u.id "
                + " WHERE b.name LIKE ? AND u.hash = ? ";
        PreparedStatement stmt = this.con.prepareStatement(sql);
        stmt.setString(1, "%" + filter + "%");
        stmt.setString(2, hash);
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
