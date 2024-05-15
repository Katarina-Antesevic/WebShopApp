package net.etfbl.webshop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import net.etfbl.webshop.dto.User;

public class UserDAO {

	private static ConnectionPool connectionPool = ConnectionPool.getConnectionPool();
	private static final String SQL_SELECT_ALL = "select id, first_name, last_name, city, username, password, mail, avatar, pin, is_activated from user order by last_name asc;";
	
	private static final String SQL_INSERT = "insert INTO user (first_name, last_name, city, username, password, mail, avatar, pin, is_activated) values\r\n"
			+ "(?, ?, ?, ?, ?, ?, ? , ? , 1);";
	private static final String SQL_DELETE = "DELETE FROM user WHERE id=?";
	private static final String SQL_UPDATE = "UPDATE user SET  first_name= ? , last_name = ? , city = ? , username = ? , password = ? , mail= ?  WHERE id = ?";
	

	public static ArrayList<User> selectAll() {
		ArrayList<User> retVal = new ArrayList<User>();
		Connection connection = null;
		ResultSet rs = null;
		Object values[] = {};
		try {
			connection = connectionPool.checkOut();
			PreparedStatement pstmt = DAOUtil.prepareStatement(connection, SQL_SELECT_ALL, false, values);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				retVal.add(new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getBoolean(10)));
			}
			pstmt.close();
		} catch (SQLException exp) {
			exp.printStackTrace();
		} finally {
			connectionPool.checkIn(connection);
		}
		return retVal;
	}
	
	public static boolean insert(User ks) {
		boolean result = false;
		Connection connection = null;
		ResultSet generatedKeys = null;
		Object values[] = { ks.getFist_name(), ks.getLast_name(), ks.getCity(), ks.getUsername(), ks.getPassword(), ks.getMail(), ks.getAvatar(), ks.getPin()};
		try {
			connection = connectionPool.checkOut();
			PreparedStatement pstmt = DAOUtil.prepareStatement(connection, SQL_INSERT, true, values);
			pstmt.executeUpdate();
			generatedKeys = pstmt.getGeneratedKeys();
			if(pstmt.getUpdateCount()>0) {
				result = true;
			}
			if (generatedKeys.next())
				ks.setId(generatedKeys.getInt(1));
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectionPool.checkIn(connection);
		}
		return result;
	}
	
	public static boolean delete(int id) {
		boolean result = false;
		Connection connection = null;
		Object values[] = {id};
		
		try {
			connection = connectionPool.checkOut();
			PreparedStatement pstmt = DAOUtil.prepareStatement(connection, SQL_DELETE, true, values);
			result = pstmt.executeUpdate() ==1;
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectionPool.checkIn(connection);
		}
		
		return result;
	}
	
	public static boolean update(User k) {
		boolean result = false;
		Connection connection = null;
		try {
			connection = connectionPool.checkOut();
			PreparedStatement pstmt = connection.prepareStatement(SQL_UPDATE);
			
			pstmt.setString(1, k.getFist_name());
			pstmt.setString(2, k.getLast_name());
			pstmt.setString(3, k.getCity());
			pstmt.setString(4, k.getUsername());
			pstmt.setString(5, k.getPassword());
			pstmt.setString(6, k.getMail());
			
			pstmt.setInt(7, k.getId());
			
			result = pstmt.executeUpdate()==1;
			
		}catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectionPool.checkIn(connection);
		}
		
		
		return result;
	}
	
	
}
