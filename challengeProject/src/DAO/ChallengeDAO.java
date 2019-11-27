package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;

import DTO.ChallengeDTO;

public class ChallengeDAO {
	private static ChallengeDAO instance;
	private static BasicDataSource bds = new BasicDataSource();
	
	private ChallengeDAO() {
		bds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		bds.setUrl("jdbc:oracle:thin:@o.qowmq.dev:1521:xe");
		bds.setUsername("semi");
		bds.setPassword("semi");
		bds.setInitialSize(30);
	}
	
	public synchronized static ChallengeDAO getInstance() {
		if(instance==null) {
			instance = new ChallengeDAO();
		}return instance;
	}
	
	public Connection getConnection() throws Exception {
		return bds.getConnection();
	
	}
	
	public ChallengeDTO getChallenge(int seq) throws Exception {
		String sql ="select * from challenge where seq=?";
		try(Connection conn = getConnection();
				PreparedStatement pstat = conn.prepareStatement(sql)){
			pstat.setInt(1, seq);
			try(ResultSet rs = pstat.executeQuery()){
				
				ChallengeDTO dto = new ChallengeDTO();
				if(rs.next()) {
					dto.setSeq(rs.getInt(1));
					dto.setTitle(rs.getString("title"));
					dto.setContent(rs.getString("content"));
					dto.setStart_date(rs.getString(4));
					dto.setEnd_date(rs.getString(5));
					dto.setEnd(rs.getString(6));
					dto.setTotal_participate(rs.getInt(7));
				}
				
				return dto;
				
			}
			
		}
	}

}
