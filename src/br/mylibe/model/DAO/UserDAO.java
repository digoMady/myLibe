package br.mylibe.model.DAO;

import br.mylibe.model.enums.TypeUser;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.mylibe.model.negocio.UserBean;

public class UserDAO {

    private Connection con;

    public UserDAO() throws SQLException {
        this.con = ConnectionFactory.getConnection();
    }
    
    public int create(UserBean user) throws SQLException {
        if (user == null) {
            return 0;
        }
        String sql = "INSERT INTO user (name, lastName, username, password, email, hash, type) values (?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setString(1, user.getName());
        stmt.setString(2, user.getLastName());
        stmt.setString(3, user.getUsername());
        stmt.setString(4, user.getPassword());
        stmt.setString(5, user.getEmail());
        stmt.setString(6, user.getHash());
        stmt.setString(7, (user.getType().toString()));

        int retorno = stmt.executeUpdate();
        stmt.close();
        return retorno;
    }

    public UserBean read(String username, String password) throws SQLException {
        String sql = "SELECT * FROM user WHERE username = ? AND password = ?";
        PreparedStatement stmt = this.con.prepareStatement(sql);
        stmt.setString(1, username);
        stmt.setString(2, password);
        ResultSet rs = stmt.executeQuery();
        UserBean user = null;
        if (rs.next()) {
            user = new UserBean();
            user.setId(rs.getInt("id"));
            user.setName(rs.getString("name"));
            user.setLastName(rs.getString("lastname"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setHash(rs.getString("hash"));
            user.setType(TypeUser.valueOf(rs.getString("type")));
        }
        rs.close();
        stmt.close();
        return user;
    }

    public UserBean read(int id) throws SQLException {
        String sql = "SELECT * FROM user WHERE id = ?";
        PreparedStatement stmt = this.con.prepareStatement(sql);
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();
        UserBean user = null;
        if (rs.next()) {
            user = new UserBean();
            user.setId(rs.getInt("id"));
            user.setName(rs.getString("name"));
            user.setLastName(rs.getString("lastname"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setHash(rs.getString("hash"));
            user.setType(TypeUser.valueOf(rs.getString("type")));
        }
        rs.close();
        stmt.close();
        return user;
    }
    
    public UserBean read(String username) throws SQLException {
        String sql = "SELECT * FROM user WHERE username= ?";
        PreparedStatement stmt = this.con.prepareStatement(sql);
        stmt.setString(1, username);
        ResultSet rs = stmt.executeQuery();
        UserBean user = null;
        if (rs.next()) {
            user = new UserBean();
            user.setId(rs.getInt("id"));
            user.setName(rs.getString("name"));
            user.setLastName(rs.getString("lastname"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setHash(rs.getString("hash"));
            user.setType(TypeUser.valueOf(rs.getString("type")));
        }
        rs.close();
        stmt.close();
        return user;
    }

    public int update(UserBean user) throws SQLException {
        if (user == null) {
            return 0;
        }
        String sql = "UPDATE user SET " +
                " name = ?, lastName = ?, password = ?, email = ?, type = ? WHERE id = ? ";
        PreparedStatement stmt = this.con.prepareStatement(sql);

        stmt.setString(1, user.getName());
        stmt.setString(2, user.getLastName());
        stmt.setString(3, user.getPassword());
        stmt.setString(4, user.getEmail());
        stmt.setString(5, (user.getType().toString()));
        stmt.setInt(6, user.getId());
        
        int retorno = stmt.executeUpdate();
        stmt.close();
        return retorno;
    }

    public int delete(UserBean user) throws SQLException {
        if (user == null) {
            return 0;
        }
        String sql = "DELETE FROM user WHERE id = ?";
        PreparedStatement stmt = this.con.prepareStatement(sql);
        stmt.setInt(1, user.getId());
        int retorno = stmt.executeUpdate();
        stmt.close();
        return retorno;
    }

    public List<UserBean> list() throws SQLException {
        String sql = "SELECT * FROM user";
        PreparedStatement stmt = this.con.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        List<UserBean> users = new ArrayList<UserBean>();
        while (rs.next()) {
            UserBean user = new UserBean();
            user.setId(rs.getInt("id"));
            user.setName(rs.getString("name"));
            user.setLastName(rs.getString("lastname"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setHash(rs.getString("hash"));
            user.setType(TypeUser.valueOf(rs.getString("type")));
            users.add(user);
        }
        rs.close();
        stmt.close();
        return users;
    }

    public List<UserBean> list(String filter) throws SQLException {
        String sql = "SELECT * FROM user WHERE name LIKE ?";
        PreparedStatement stmt = this.con.prepareStatement(sql);
        stmt.setString(1, "%" + filter + "%");
        ResultSet rs = stmt.executeQuery();
        List<UserBean> users = new ArrayList<UserBean>();
        while (rs.next()) {
            UserBean user = new UserBean();
            user.setId(rs.getInt("id"));
            user.setName(rs.getString("name"));
            user.setLastName(rs.getString("lastname"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setHash(rs.getString("hash"));
            user.setType(TypeUser.valueOf(rs.getString("type")));
            users.add(user);
        }
        rs.close();
        stmt.close();
        return users;
    }
}
