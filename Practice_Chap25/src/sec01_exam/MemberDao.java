package sec01_exam;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

//DB에 직접 Access하는 클래스 정의함(DAO)
public class MemberDao {
	//회원을 인증하기 위한 기본적인 상수를 정의한다.
	public static final int MEMBER_NONEXISTENT  = 0;
	public static final int MEMBER_EXISTENT = 1;
	public static final int MEMBER_JOIN_FAIL = 0;
	public static final int MEMBER_JOIN_SUCCESS = 1;
	public static final int MEMBER_LOGIN_PW_NO_GOOD = 0;
	public static final int MEMBER_LOGIN_SUCCESS = 1;
	public static final int MEMBER_LOGIN_IS_NOT = -1;
	
	//싱글톤 패턴이다. 자바에서 이미 배웠다. 
	private static MemberDao instance = new MemberDao();
	//외부에서 생성자를 호출하여 인스턴스를 생성하지 않도록 한다.(접근제어자가 private이다)
	//단 1개의 인스턴스만 존재함. 하여, 주소는 다 동일하다.
	private MemberDao() {}
	
	//생성된 인스턴스를 리턴해주고 있다.
	public static MemberDao getInstance() {
		return instance;
	}	
	
	//회원의 데이터를 DB에 저장하는 메서드.
	public int insertMember(MemberDto dto) {
		int ri = 0;		
		Connection conn = null;
		PreparedStatement pstmt = null;
		String query = "insert into members values(?, ?, ?, ? , ?, ?)";
		
		try {
			//DBCP에서 커넥션 객체를 하나 얻는다.
			conn = this.getConnection();
			//쿼리를 미리 준비한다.
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getPw());
			pstmt.setString(3, dto.getName());
			pstmt.setString(4, dto.geteMail());
			pstmt.setString(5, dto.getrDate());
			pstmt.setString(6, dto.getAddress());			
/*			executeQuery메서드는 하나의 ResultSet을 만드는 SQL문들에서 사용되며,
			executeUpdate 메서드는  INSERT,UPDATE 또는 DELETE문들, 그리고 또한
			CREATE TABLE과 DROP TABLE과 같은 SQL DDL문들을 실행하는데 사용되어진다. 
			INSERT,UPDATE,DELETE 문의 결과는 테이블내의 0 이나 많은 열들 내에서 하나
			이상의 행을 수정하는 것이다. 
			executeUpdate의 리턴값은 작용한 열의 개수(갱신 카운트로 간주되는)를 나타내는 
			정수이다. 이것은 update문의 결과와는 전적으로 다르다.CREATE TABLE과 같은 
			SQL문은 또 다른 상황이 나타난다. 
			즉,그것은 새로운 테이블을 만들고,테이블을 만드는 것이 결과이지만,아무것도 리턴
			하지는 않는다.이러한 경우에 executeUpdate 메서드는 0를 리턴한다. 
			따라서 executeUpdate의 리턴값이 0일 때,그것은 다음 두 가지 중 하나를 의미할
			수 있다.
			   1) 실행된 SQL문은 열들에 영향을 주지 않는 INSERT,UPDATE 
			   	    또는 DELETE이다. 
			   2) 실행된 SQL문이 DDL문들이다.
			실행문을 위한 모든 메서드들은 하나가 오픈되어있다면 호출된 Statement객체의 현재 
			resultset을 닫아야 한다. 
			이것은 Statement 객체를 다시 실행하기 전에 현재 ResultSet객체의 어떠한 처리도 
			완결해야 할 필요가 있다는 것을 의미한다
*/
			pstmt.executeUpdate();			
			//회원이 가입이 성공되었으므로, 1을 저장하고 리턴한다.
			ri = MemberDao.MEMBER_JOIN_SUCCESS;			
		} catch (Exception e) { e.printStackTrace(); }
		//자원 해제
		finally	{
			try	{
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (Exception e2) { e2.printStackTrace(); }
		}		
		return ri;
	}	
	//회원이 존재하는지를 확인하는 메서드
	public int confirmId(String id)	{		
		int ri = 0;		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet set = null;
		String query = "select id from members where id = ?";		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, id);
			set = pstmt.executeQuery();
			//회원 ID가 존재하면
			if(set.next()) {
				//ri를 1로 설정
				ri = MemberDao.MEMBER_EXISTENT;
			} 
			else {
				//없다면 0으로 설정함.
				ri = MemberDao.MEMBER_NONEXISTENT;
			}
		} catch(Exception e) { e.printStackTrace(); }		
		//자원 해제
		finally {
			try	{
				set.close();
				pstmt.close();
				conn.close();
			}catch (Exception e2) { e2.printStackTrace(); }
		}
		return ri;
	}	
	//회원인지 비회원인지를 확인하는 메서드
	public int userCheck(String id, String pw)	{		
		int ri = 0;
		String dbPw;		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet set = null;
		String query = "select pw from members where id = ?";		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, id);
			set = pstmt.executeQuery();			
			if(set.next()) { 
				//사용자가 입력한 pw를 가져옴
				dbPw = set.getString("pw");				
				if(dbPw.equals(pw)) {
					//DB에 저장한 pw와 비교하여 맞으면 1로 설정
					ri = MemberDao.MEMBER_LOGIN_SUCCESS; //로그인 성공
				} 
				else {
					//DB에 저장한 pw와 비교하여  틀리면 0으로 설정
					ri = MemberDao.MEMBER_LOGIN_PW_NO_GOOD;	//비번틀림
				}
			}			
			else {
				//회원 정보조차 없을때는 -1로 설정함.
				ri = MemberDao.MEMBER_LOGIN_IS_NOT;		// 회원정보 없음	
			}			
		} catch (Exception e) {	e.printStackTrace();}		
		finally {
			try {
				set.close();
				pstmt.close();
				conn.close();
			} catch (Exception e2) { e2.printStackTrace(); }
		}
		return ri;
	}	
	//한 명의 회원의 정보를 id값으로 DB에서 가져오는 메서드
	public MemberDto getMember(String id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet set = null;
		String query = "select * from members where id = ?";
		MemberDto dto = null;  //DTO선언
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, id);
			set = pstmt.executeQuery();
			//id가 존재하면...
			if(set.next()) {
				dto = new MemberDto();  //DTO생성				
				//DTO의 setter를 이용해서 DB의 각 값들을 저장한다.
				dto.setId(set.getString("id"));
				dto.setPw(set.getString("pw"));
				dto.setName(set.getString("name"));
				dto.seteMail(set.getString("eMail"));
				dto.setrDate(set.getString("rDate"));
				dto.setAddress(set.getString("address"));
			}
		} catch (Exception e) {	e.printStackTrace(); }		
		finally {
			try {
				set.close();
				pstmt.close();
				conn.close();
			} catch (Exception e2) { e2.printStackTrace(); }
		}		
		//DTO를 리턴한다.
		return dto;		
	}	
	//회원 정보를 수정하면 그것을 DB에 Update를 하는 메서드
	public int updateMember(MemberDto dto){		
		int ri = 0;		
		Connection conn = null;
		PreparedStatement pstmt = null;
		String query = "update members set pw=?, eMail=?, address=? "
						+ "where id=?";		
		try {
			conn = getConnection();			
			//사용자가 입력한 값을 DB에 저장하기 위한 쿼리문 준비
			pstmt = conn.prepareStatement(query);			
			pstmt.setString(1, dto.getPw());
			pstmt.setString(2, dto.geteMail());
			pstmt.setString(3, dto.getAddress());
			pstmt.setString(4, dto.getId());			
			//저장이 되었다면 ri는 1로 설정이 될 것이다.
			//(한명의 회원의 정보가 수정되었기 때문이다.)
			ri = pstmt.executeUpdate();
			System.out.println(ri);
		} catch (Exception e) {	e.printStackTrace(); }		
		finally {
			try {
				pstmt.close();
				conn.close();
			} catch (Exception e2) { e2.printStackTrace(); }
		}		
		return ri;
	}	
	//DBCP에서 DB커넥션을 얻어오는 메서드
	private Connection getConnection() {
		Context context = null;
		DataSource dataSource = null;
		Connection conn = null;		
		//이미 앞선장에서 Context에 DBCP를 설정하였기에 Context를 얻는다.
		//서버가 구동되면서 DBCP는 만들어졌기 때문에 가져다가 쓰면 되는 것이다.
		try {
			context = new InitialContext();				
			//context에서 lookup하여 매개값으로 java:comp/env/jdbc/dbtool을
			//넣어주면 DataSource객체를 형변환으로 얻을수 있다.
			//DataSource는 인터페이스로써 DBCP에서 커넥션 객체를 얻어온다.
			dataSource = (DataSource)context.lookup("java:comp/env/"+
									"jdbc/dbtool");
			conn = dataSource.getConnection();
			System.out.println("DBCP 연동 성공");			
		} catch (Exception e) {	e.printStackTrace(); }		
		return conn;
	}
}