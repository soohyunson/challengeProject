package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;

public class MemberDAO {
	
	private static MemberDAO instance;
	private static BasicDataSource bds = new BasicDataSource();
	
	private MemberDAO() {
		bds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		bds.setUrl("jdbc:oracle:thin:@o.qowmq.dev:1521:xe");
		bds.setUsername("semi");
		bds.setPassword("semi");
		bds.setInitialSize(30);
	}
	
	public synchronized static MemberDAO getInstance() {
		if(instance==null) {
			instance = new MemberDAO();
		}return instance;
	}
	
	public Connection getConnection() throws Exception {
		return bds.getConnection();
	}
	
	public boolean isLoginOK(String id, String pw)throws Exception{
		String sql = "select * from Member where id = ? and pw = ?";
		try(Connection con = getConnection();
				PreparedStatement psta = con.prepareStatement(sql);){
			psta.setString(1, id);
			psta.setString(2, pw);
			try(ResultSet rs = psta.executeQuery();){
				return rs.next();
			}
	
		}
		
	}
	

}
