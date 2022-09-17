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
import dto.Grade;
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
			ps.setString(4, customer.getTel());
			
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
				customer = new Customer(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getString(6), rs.getString(7), rs.getLong(8));
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
				Customer customer = new Customer(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getString(6), rs.getString(7), rs.getLong(8));
				customers.add(customer);
			}
		} finally {
			DbUtil.close(con, ps, rs);
		}
		return customers;
	}

	/**
	 * 키워드로 회원 검색
	 * : 회원 테이블에 있는 회원 중 키워드 검색에 걸리는 회원을 가져옴
	 * @param: String field(검색 컬럼), String keyword(검색 키워드)
	 * @return: List<Customer>
	 * */
	@Override
	public List<Customer> findByKeyword(String field, String keyword) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 계좌로 회원 검색
	 * : 특정 계좌를 소유하고 있는 회원 검색
	 * @param: int accountId
	 * @return: Customer
	 * */
	@Override
	public Customer findByAccountId(int accountId) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 등급별 회원 검색
	 * : 회원 테이블의 회원 중 특정 등급의 회원만 가져옴
	 * @param: int gradeId
	 * @return: List<Customer>
	 * */
	@Override
	public List<Customer> findByGrade(int grade) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 등급 아이디로 회원 등급 검색
	 * : 등급 테이블에서 특정 등급 가져오기
	 * @param: int gradeId
	 * @return: Grade
	 * */
	@Override
	public Grade findByGradeId(int gradeId) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	};
}
