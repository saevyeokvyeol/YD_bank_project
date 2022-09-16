package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import util.DbUtil;

public class TestDelete {
	/**
	 * 테스트 코드 실행 후 레코드 삭제를 위한 메소드
	 * 실제 사용 금지
	 * */
	public void delete(String sql) {
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			int result = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbUtil.close(con, ps);
		}
	}
}
