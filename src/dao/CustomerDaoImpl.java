package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import dto.Customer;
import util.DbUtil;

public class CustomerDaoImpl implements CustomerDao {
	private Properties profile = DbUtil.getProfile();

	/**
	 * 회원가입
	 * : 회원 정보를 받아 회원 리스트에 저장
	 * @param: Customer
	 * @return: Customer
	 * */
	@Override
	public Customer signup(Customer customer) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		
		String sql = profile.getProperty("customer.signup");
		int result = 0;
		
		try {
			con = DbUtil.getConnection();
			
			ps = con.prepareStatement(sql);
			ps.setString(1, customer.getId());
			ps.setString(2, customer.getPassword());
			ps.setString(3, customer.getName());
			
			result = ps.executeUpdate();
		} finally {
			DbUtil.close(con, ps);
		}
		return customer;
	}

	/**
	 * 아이디 찾기
	 * : 회원 정보에 입력받은 아이디와 일치하는 정보가 있을 경우 리턴
	 * @param: String id
	 * @return: Customer
	 * */
	@Override
	public Customer findById(String id) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = profile.getProperty("customer.findById");
//		String sql = "select * from customer where id = ?";
		Customer customer = null;
		
		try {
			con = DbUtil.getConnection();
			
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			
			rs = ps.executeQuery();
			
			if (rs.next()) {
				customer = new Customer(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(5), rs.getString(6), rs.getLong(7));
			}
		} finally {
			DbUtil.close(con, ps, rs);
		}
		return customer;
	}

	/**
	 * 모든 회원 검색
	 * : 회원 테이블에 있는 모든 회원을 가져옴
	 * @return: List<Customer>
	 * */
	public List<Customer> findAll() throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = profile.getProperty("customer.findAll");
		List<Customer> customers = new ArrayList<Customer>();
		
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				Customer customer = new Customer(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(5), rs.getString(6), rs.getLong(7));
				customers.add(customer);
			}
		} finally {
			DbUtil.close(con, ps, rs);
		}
		return customers;
	};
}
