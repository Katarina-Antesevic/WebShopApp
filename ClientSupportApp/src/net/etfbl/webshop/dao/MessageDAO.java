package net.etfbl.webshop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import net.etfbl.webshop.beans.UserBean;
import net.etfbl.webshop.beans.MessageBean;



public class MessageDAO {

	private static ConnectionPool connectionPool = ConnectionPool.getConnectionPool();
	private static final String SQL_SELECT_ALL = "select m.id, m.content, m.date_time, m.is_read, \r\n"
			+ "u.id, u.first_name, u.last_name, u.city, u.username, u.password,\r\n"
			+ "u.mail, u.avatar, u.pin, u.is_activated\r\n"
			+ "FROM message m JOIN user u on m.id_user=u.id \r\n"
			+ "order by m.id ASC;";
	private static final String SQL_UPDATE = "UPDATE message SET is_read = 1 WHERE id = ?";
	private static final String SQL_SELECT_BY_WEBSHOP_USER_ID = "select m.id, m.content, m.date_time, m.is_read, \r\n"
			+ "u.id, u.first_name, u.last_name, u.city, u.username, u.password,\r\n"
			+ "u.mail, u.avatar, u.pin, u.is_activated\r\n"
			+ "FROM message m JOIN user u on m.id_user=u.id  \r\n"
			+ "where u.id = ? \r\n"
			+ "order by m.id ASC;";
	
	private static final String SQL_SELECT_WHERE_NOT_READ =	"select m.id, m.content, m.date_time, m.is_read, \r\n"
			+ "u.id, u.first_name, u.last_name, u.city, u.username, u.password,\r\n"
			+ "u.mail, u.avatar, u.pin, u.is_activated\r\n"
			+ "FROM message m JOIN user u on m.id_user=u.id  \r\n"
			+ "where m.is_read = 0 \r\n"
			+ "order by m.id ASC;";
	
	
	public static  boolean update(MessageBean p) {
		boolean result = false;
		Connection connection = null;
		try {
			connection = connectionPool.checkOut();
			PreparedStatement pstmt = connection.prepareStatement(SQL_UPDATE);
			
			pstmt.setInt(1, p.getId());
			
			result = pstmt.executeUpdate()==1;
			
		}catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectionPool.checkIn(connection);
		}
		
		
		return result;
	}
	
	public static ArrayList<MessageBean> selectAll() {
		ArrayList<MessageBean> retVal = new ArrayList<MessageBean>();
		Connection connection = null;
		ResultSet rs = null;
		Object values[] = {};
		try {
			connection = connectionPool.checkOut();
			PreparedStatement pstmt = DAOUtil.prepareStatement(connection, SQL_SELECT_ALL, false, values);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				retVal.add(new MessageBean(rs.getInt(1),rs.getString(2), rs.getString(3), rs.getInt(4), new UserBean(rs.getInt(5), rs.getString(6), rs.getString(7), rs.getString(8),
						rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13), rs.getBoolean(14))));
			}
			pstmt.close();
		} catch (SQLException exp) {
			exp.printStackTrace();
		} finally {
			connectionPool.checkIn(connection);
		}
		return retVal;
	}
	
	public static ArrayList<MessageBean> selectNotRead() {
		ArrayList<MessageBean> retVal = new ArrayList<MessageBean>();
		Connection connection = null;
		ResultSet rs = null;
		Object values[] = {};
		try {
			connection = connectionPool.checkOut();
			PreparedStatement pstmt = DAOUtil.prepareStatement(connection, SQL_SELECT_WHERE_NOT_READ, false, values);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				retVal.add(new MessageBean(rs.getInt(1),rs.getString(2), rs.getString(3), rs.getInt(4), new UserBean(rs.getInt(5), rs.getString(6), rs.getString(7), rs.getString(8),
						rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13), rs.getBoolean(14))));
			}
			pstmt.close();
		} catch (SQLException exp) {
			exp.printStackTrace();
		} finally {
			connectionPool.checkIn(connection);
		}
		return retVal;
	}
	
	public static ArrayList<MessageBean> selectBySpecificUserId(int id){
		ArrayList<MessageBean> retVal = new ArrayList<MessageBean>();
		Connection connection = null;
		ResultSet rs = null;
		Object values[] = {id};
		try {
			connection = connectionPool.checkOut();
			PreparedStatement pstmt = DAOUtil.prepareStatement(connection, SQL_SELECT_BY_WEBSHOP_USER_ID, false, values);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				retVal.add(new MessageBean(rs.getInt(1),rs.getString(2), rs.getString(3), rs.getInt(4), new UserBean(rs.getInt(5), rs.getString(6), rs.getString(7), rs.getString(8),
						rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13), rs.getBoolean(14))));
			}
			pstmt.close();
		} catch (SQLException exp) {
			exp.printStackTrace();
		} finally {
			connectionPool.checkIn(connection);
		}
		return retVal;
		
	}
	

}
