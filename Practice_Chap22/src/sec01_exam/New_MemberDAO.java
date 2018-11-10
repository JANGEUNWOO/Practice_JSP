package sec01_exam;
/*DAO��ü�� Database Access Object�̴�. �� �ٽ� ���� �����ͺ��̽��� �����Ͽ� ��ȸ, ����, ���� �� �۾��� �����ϴ� ��ü�̴�
 * �׸��� ������� �޾ƿ´�. �� ������� �߱��������� �������°� �ƴ϶� DTO��ü�� �޾ƿ��� �����ش�.
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

	// ������ , ����̹� �ε�
	public New_MemberDAO() {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	// ��ȯ���� ArrayList<MemberDTO>�̴�.
	public ArrayList<New_MemberDTO> memberSelect() {
		ArrayList<New_MemberDTO> dtos = new ArrayList<New_MemberDTO>();
		Connection con = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		String query = "select*from new_member";
		try {
			// DBĿ�ؼ� �� ������ ����
			con = DriverManager.getConnection(url, uid, upw);
			psmt = con.prepareStatement(query);
			rs = psmt.executeQuery();
			// DB���� ������ �����͸� �Ʒ��� ���� �޾Ƽ� MemberDTO�� �������� �Ű������� �����ϰ�
			// �ƿ﷯ �� ��ü�� ArrayList<MemberDTO>�� ��� �߰��ϰ� �ִ�.
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
		// �� �߰��� ArrayList<MemberDTO>��ü�� �����ϰ� �ִ�.
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
