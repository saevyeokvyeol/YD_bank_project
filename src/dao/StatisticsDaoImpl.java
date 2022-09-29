package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

import dto.Statistics;
import util.DbUtil;

public class StatisticsDaoImpl implements StatisticsDao {
	private Properties profile = DbUtil.getProfile();

	/**
	 * 전체 회원 수 반환
	 * @return: Long
	 * */
	@Override
	public Long findTotalCustomer() throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = profile.getProperty("statistics.findTotalCustomer");
		Long result = null;
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			if (rs.next()) {
				result = rs.getLong(1);
			}
		} finally {
			DbUtil.close(con, ps, rs);
		}
		return result;
	}

	/**
	 * 오늘 가입한 회원 수 반환
	 * @return: Long
	 * */
	@Override
	public Long findTodayCustomer() throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = profile.getProperty("statistics.findTodayCustomer");
		Long result = null;
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			if (rs.next()) {
				result = rs.getLong(1);
			}
		} finally {
			DbUtil.close(con, ps, rs);
		}
		return result;
	}

	/**
	 * 총 예치액 반환
	 * @return: Long
	 * */
	@Override
	public Long findTotalBalance() throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = profile.getProperty("statistics.findTotalBalance");
		Long result = null;
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			if (rs.next()) {
				result = rs.getLong(1);
			}
		} finally {
			DbUtil.close(con, ps, rs);
		}
		return result;
	}

	/**
	 * 총 거래 횟수 반환
	 * @return: Long
	 * */
	@Override
	public Long findTotalTransactionCount() throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = profile.getProperty("statistics.findTotalTransactionCount");
		Long result = null;
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			if (rs.next()) {
				result = rs.getLong(1);
			}
		} finally {
			DbUtil.close(con, ps, rs);
		}
		return result;
	}

	/**
	 * 총 거래 금액 반환
	 * @return: Long
	 * */
	@Override
	public Long findTotalTransactionAmount() throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = profile.getProperty("statistics.findTotalTransactionAmount");
		Long result = null;
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			if (rs.next()) {
				result = rs.getLong(1);
			}
		} finally {
			DbUtil.close(con, ps, rs);
		}
		return result;
	}

	/**
	 * 오늘 거래 횟수 반환
	 * @return: Long
	 * */
	@Override
	public Long findTotalTransactionTodayCount() throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = profile.getProperty("statistics.findTotalTransactionTodayCount");
		Long result = null;
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			if (rs.next()) {
				result = rs.getLong(1);
			}
		} finally {
			DbUtil.close(con, ps, rs);
		}
		return result;
	}

	/**
	 * 오늘 거래 금액 반환
	 * @return: Long
	 * */
	@Override
	public Long findTotalTransactionTodayAmount() throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = profile.getProperty("statistics.findTotalTransactionTodayAmount");
		Long result = null;
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			if (rs.next()) {
				result = rs.getLong(1);
			}
		} finally {
			DbUtil.close(con, ps, rs);
		}
		return result;
	}

	/**
	 * 거래 횟수 많은 회원 검색
	 * @return: List<Statistics>
	 * */
	@Override
	public List<Statistics> findTransactionCount() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 거래 액수 많은 회원 검색
	 * @return: List<Statistics>
	 * */
	@Override
	public List<Statistics> findTransactionAmount() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
