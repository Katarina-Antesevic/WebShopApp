package net.etfbl.webshop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import net.etfbl.webshop.dto.Attribute;
import net.etfbl.webshop.dto.Category;



public class AttributeDAO {

	private static ConnectionPool connectionPool = ConnectionPool.getConnectionPool();
	private static final String SQL_SELECT_ALL = "select a.id, a.name, c.id, c.name, c.id_parent_category from\r\n"
			+ "attribute a join category c on a.id_category=c.id\r\n"
			+ "order by c.name asc";
	private static final String SQL_INSERT = "insert into attribute (name, id_category) VALUES (?, ?)";
	private static final String SQL_DELETE = "DELETE FROM attribute WHERE id = ?";
	private static final String SQL_UPDATE = "UPDATE attribute SET name = ? WHERE id = ?";
	private static final String SQL_SELECT_BY_CATEGORY_ID = "select a.id, a.name, c.id, c.name, c.id_parent_category from\r\n"
			+ "attribute a join category c on a.id_category=c.id where c.id=? \r\n"
			+ "order by c.name asc;";
	
	public static ArrayList<Attribute> selectBySpecificCategoryId(int id){
		ArrayList<Attribute> retVal = new ArrayList<Attribute>();
		Connection connection = null;
		ResultSet rs = null;
		Object values[] = {id};
		try {
			connection = connectionPool.checkOut();
			PreparedStatement pstmt = DAOUtil.prepareStatement(connection, SQL_SELECT_BY_CATEGORY_ID, false, values);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				retVal.add(new Attribute(rs.getInt(1), rs.getString(2), new Category(rs.getInt(3), rs.getString(4), rs.getInt(5))));
			}
			pstmt.close();
		} catch (SQLException exp) {
			exp.printStackTrace();
		} finally {
			connectionPool.checkIn(connection);
		}
		return retVal;
		
	}
	
	public static ArrayList<Attribute> selectAll() {
		ArrayList<Attribute> retVal = new ArrayList<Attribute>();
		Connection connection = null;
		ResultSet rs = null;
		Object values[] = {};
		try {
			connection = connectionPool.checkOut();
			PreparedStatement pstmt = DAOUtil.prepareStatement(connection, SQL_SELECT_ALL, false, values);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				retVal.add(new Attribute(rs.getInt(1), rs.getString(2), new Category(rs.getInt(3), rs.getString(4), rs.getInt(5))));
			}
			pstmt.close();
		} catch (SQLException exp) {
			exp.printStackTrace();
		} finally {
			connectionPool.checkIn(connection);
		}
		return retVal;
	}
	
	public static boolean insert(Attribute a) {
		boolean result = false;
		Connection connection = null;
		ResultSet generatedKeys = null;
		Object values[] = { a.getName() };
		try {
			connection = connectionPool.checkOut();
			PreparedStatement pstmt = DAOUtil.prepareStatement(connection, SQL_INSERT, true, values);
			pstmt.setString(1, a.getName());
			pstmt.setInt(2, a.getCategory().getId());
			pstmt.executeUpdate();
			generatedKeys = pstmt.getGeneratedKeys();
			if(pstmt.getUpdateCount()>0) {
				result = true;
			}
			if (generatedKeys.next())
				a.setId(generatedKeys.getInt(1));
			
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
	
	public static  boolean update(Attribute a) {
		boolean result = false;
		Connection connection = null;
		try {
			connection = connectionPool.checkOut();
			PreparedStatement pstmt = connection.prepareStatement(SQL_UPDATE);
			pstmt.setString(1, a.getName());
			pstmt.setInt(2, a.getId());
			
			result = pstmt.executeUpdate()==1;
			
		}catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectionPool.checkIn(connection);
		}
		
		
		return result;
	}
	
	

}
