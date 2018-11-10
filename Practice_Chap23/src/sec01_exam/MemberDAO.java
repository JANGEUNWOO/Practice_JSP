package sec01_exam;
/*DAO객체는 Database Access Object이다. 즉 다시 말해 데이터베이스에 접근하여 조회, 수정, 삭제 등 작업을 진행하는 객체이다
 * 그리고 결과값을 받아온다. 그 결과값을 중구난방으로 가져오는게 아니라 DTO객체로 받아오게 도와준다.
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class MemberDAO {
	
	private DataSource dataSource;
	protected Connection con = null;
	protected PreparedStatement psmt = null;
	protected ResultSet rs = null;
	protected Context ctx = null;
	
	public MemberDAO() {}
	
	//DBCP커넥션 얻기 
	public Connection getConnection() {
		try {
			ctx = new InitialContext();
			dataSource = (DataSource)ctx.lookup("java:comp/env/jdbc/dbtool");
			con = dataSource.getConnection();
			System.out.println("DBCP 커넥션 얻어오기 성공");
		} catch(Exception e) {e.printStackTrace();}
		return con;
	}
	//반환형이 ArrayList<MemberDTO>이다. 
	public ArrayList<MemberDTO> memberSelect(){
		System.out.println("memberselect진입");
		ArrayList<MemberDTO> dtos = new ArrayList<MemberDTO>();
		try {
			//DB커넥션 및 쿼리문 실행
			//con = DriverManager.gertCionnection(url,uid,upw);
			System.out.println("쿼리문 받아옴");
			//서버에 있는 DB커넥션 객체 사용
			Connection con = this.getConnection();
			String query = "select * from new_member";
			psmt = con.prepareStatement(query);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				String name = rs.getString("name");
				String id = rs.getString("id");
				String pw = rs.getString("pw");
				String phone1 = rs.getString("phone1");
				String phone2 = rs.getString("phone2");
				String phone3 = rs.getString("phone3");
				String gender = rs.getString("gender");
				MemberDTO dto = 
						new MemberDTO(name, id, pw, phone1, phone2, phone3, gender);
				dtos.add(dto);
			}
		}
		catch(SQLException e) { e.printStackTrace();}
		return dtos;
		
	}
}
