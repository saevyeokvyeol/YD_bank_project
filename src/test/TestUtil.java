package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import dto.Customer;
import service.CustomerService;
import service.CustomerServiceImpl;
import session.Session;
import util.DbUtil;
import view.FailView;
import view.Menu;

public class TestUtil {
	private CustomerService customerService = new CustomerServiceImpl();
	private Session session = Session.getInstance();
	
	/**
	 * 테스트 코드 실행 후 레코드 삭제를 위한 메소드
	 * 실제 사용 금지
	 * */
	protected void delete(String sql) {
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbUtil.close(con, ps);
		}
	}
	
	/**
	 * 테스트용 로그인 메소드: 세션 계정 정보 저장용
	 * */
	protected void login(Customer customer) {
		try {
			Customer loginUser = customerService.login(customer);
			session.setAttribute("loginUser", loginUser);
		} catch (Exception e) {
			FailView.printErrorMessage(e);
		}
	}
}
