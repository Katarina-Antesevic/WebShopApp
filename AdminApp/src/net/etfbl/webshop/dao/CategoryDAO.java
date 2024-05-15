package net.etfbl.webshop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import net.etfbl.webshop.dto.Category;



public class CategoryDAO {
	private static ConnectionPool connectionPool = ConnectionPool.getConnectionPool();
	private static final String SQL_SELECT_ALL = "select id, name, id_parent_category from category ";
	private static final String SQL_SELECT_SUB = "select * from category where id_parent_category != 'null' ";
	private static final String SQL_SELECT_BY_NAME = "SELECT * FROM category WHERE name=?";
	
	private static final String SQL_INSERT = "INSERT INTO category (name, id_parent_category) VALUES (?, ?)";
	private static final String SQL_DELETE = "DELETE FROM category WHERE id = ?";
	private static final String SQL_UPDATE = "UPDATE category SET name = ? WHERE id = ?";
	
	public static ArrayList<Category> selectAll() {
		ArrayList<Category> retVal = new ArrayList<Category>();
		Connection connection = null;
		ResultSet rs = null;
		Object values[] = {};
		try {
			connection = connectionPool.checkOut();
			PreparedStatement pstmt = DAOUtil.prepareStatement(connection, SQL_SELECT_ALL, false, values);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				retVal.add(new Category(rs.getInt(1), rs.getString(2), rs.getInt(3)));
			}
			pstmt.close();
		} catch (SQLException exp) {
			exp.printStackTrace();
		} finally {
			connectionPool.checkIn(connection);
		}
		return retVal;
	}
	
	public static ArrayList<Category> selectAllSub() {
		ArrayList<Category> retVal = new ArrayList<Category>();
		Connection connection = null;
		ResultSet rs = null;
		Object values[] = {};
		try {
			connection = connectionPool.checkOut();
			PreparedStatement pstmt = DAOUtil.prepareStatement(connection, SQL_SELECT_SUB, false, values);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				retVal.add(new Category(rs.getInt(1), rs.getString(2), rs.getInt(3)));
			}
			pstmt.close();
		} catch (SQLException exp) {
			exp.printStackTrace();
		} finally {
			connectionPool.checkIn(connection);
		}
		return retVal;
	}
	
	public static  boolean update(Category cat) {
		boolean result = false;
		Connection connection = null;
		try {
			connection = connectionPool.checkOut();
			PreparedStatement pstmt = connection.prepareStatement(SQL_UPDATE);
			pstmt.setString(1, cat.getName());
			pstmt.setInt(2, cat.getId());
			
			result = pstmt.executeUpdate()==1;
			
		}catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectionPool.checkIn(connection);
		}
		
		
		return result;
	}
	
	
	public static boolean insert(Category cat) {
		boolean result = false;
		Connection connection = null;
		ResultSet generatedKeys = null;
		Object values[] = { cat.getName(), cat.getParentCategoryId() };
		try {
			connection = connectionPool.checkOut();
			PreparedStatement pstmt = DAOUtil.prepareStatement(connection, SQL_INSERT, true, values);
			pstmt.executeUpdate();
			generatedKeys = pstmt.getGeneratedKeys();
			if(pstmt.getUpdateCount()>0) {
				result = true;
			}
			if (generatedKeys.next())
				cat.setId(generatedKeys.getInt(1));
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
	
	public static Category selectByName(String name){
		Category kategorija = null;
		Connection connection = null;
		ResultSet rs = null;
		Object values[] = {name};
		try {
			connection = connectionPool.checkOut();
			PreparedStatement pstmt = DAOUtil.prepareStatement(connection,
					SQL_SELECT_BY_NAME, false, values);
			rs = pstmt.executeQuery();
			if (rs.next()){
				kategorija = new Category(rs.getInt(1), rs.getString(2), rs.getInt(3));
			}
			pstmt.close();
		} catch (SQLException exp) {
			exp.printStackTrace();
		} finally {
			connectionPool.checkIn(connection);
		}
		return kategorija;
	}
	
	

}

