package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;

import DTO.Challenge_recordDTO;

public class ChallengeRecordDAO {
	private static ChallengeRecordDAO instance;
	private static BasicDataSource bds = new BasicDataSource();
	
	private ChallengeRecordDAO() {
		bds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		bds.setUrl("jdbc:oracle:thin:@o.qowmq.dev:1521:xe");
		bds.setUsername("semi");
		bds.setPassword("semi");
		bds.setInitialSize(30);
	}
	
	public synchronized static ChallengeRecordDAO getInstance() {
		if(instance==null) {
			instance = new ChallengeRecordDAO();
		}return instance;
	}
	
	public Connection getConnection() throws Exception {
		return bds.getConnection();
	}
	
	public ArrayList<Challenge_recordDTO> getParticipate(int seq) throws Exception {
		String sql = "select * from challenge_record where challenge_numm =?";
		try(Connection conn = getConnection();
				PreparedStatement pstat = conn.prepareStatement(sql);){
			pstat.setInt(1, seq);
			try(ResultSet rs = pstat.executeQuery()){
				ArrayList<Challenge_recordDTO> list = new ArrayList<>();
				
				while(rs.next()) {
					Challenge_recordDTO dto = new Challenge_recordDTO();
					dto.setSeq(rs.getInt(1));
					dto.setSuccess(rs.getString(2));
					dto.setChallenge_num(rs.getInt(3));
					dto.setMember_id(rs.getString(4));
					
					list.add(dto);

				}
				
				return list;
				
			}
			
		}
	}
	
	public int successUpdate (int seq) throws SQLException, Exception {
		String sql ="update challenge_record set success='Y' where seq=?";
		try(Connection conn = getConnection();
				PreparedStatement pstat =conn.prepareStatement(sql);){
			pstat.setInt(1, seq);
			
			int result = pstat.executeUpdate();
			conn.commit();
			
			return result;
			
		}
	}

}
