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

public class New_MemberDAO {

	private String driver = "com.mysql.jdbc.Driver";
	private String url = "jdbc:mysql://localhost/sqldb";
	// private String url = "jdbc:mysql://localhost/sqldb?" +
	// "useUnicode=true&characterEncoding=UTF-8";

	private String uid = "root";
	private String upw = "1234";

	// 생성자 , 드라이버 로드
	public New_MemberDAO() {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	// 반환형이 ArrayList<MemberDTO>이다.
	public ArrayList<New_MemberDTO> memberSelect() {
		ArrayList<New_MemberDTO> dtos = new ArrayList<New_MemberDTO>();
		Connection con = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		String query = "select*from new_member";
		try {
			// DB커넥션 및 쿼리문 실행
			con = DriverManager.getConnection(url, uid, upw);
			psmt = con.prepareStatement(query);
			rs = psmt.executeQuery();
			// DB에서 가져온 데이터를 아래와 같이 받아서 MemberDTO에 생성자의 매개값으로 대입하고
			// 아울러 그 객체를 ArrayList<MemberDTO>에 계속 추가하고 있다.
			while (rs.next()) {
				String name = rs.getString("name");
				String id = rs.getString("id");
				String pw = rs.getString("pw");
				String phone1 = rs.getString("phone1");
				String phone2 = rs.getString("phone2");
				String phone3 = rs.getString("phone3");
				String gender = rs.getString("gender");
				
				New_MemberDTO dto = new New_MemberDTO(name, id, pw, phone1, phone2, phone3, gender);
				dtos.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// 다 추가된 ArrayList<MemberDTO>객체를 리턴하고 있다.
		return dtos;

	}
	
	public int memberInsert(New_MemberDTO new_MemberDTO) {
		
		Connection con = null;
		PreparedStatement psmt = null;
		
		String query = "insert into new_member values(?,?,?,?,?,?,?)";
		
		try {
			
			con = DriverManager.getConnection(url, uid, upw);
			psmt = con.prepareStatement(query);
			
			psmt.setString(1, new_MemberDTO.getName());
			psmt.setString(2, new_MemberDTO.getId());
			psmt.setString(3, new_MemberDTO.getPw());
			psmt.setString(4, new_MemberDTO.getPhone1());
			psmt.setString(5, new_MemberDTO.getPhone2());
			psmt.setString(6, new_MemberDTO.getPhone3());
			psmt.setString(7, new_MemberDTO.getGender());
			
			psmt.executeUpdate();
			return 1;
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}
		
	}

}
