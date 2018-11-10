package sec01_exam;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class modifyOk
 */
@WebServlet("/modifyOk")
public class modifyOk extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private String id, pw, name, eMail, address, rDate;
    private String driver = "com.mysql.jdbc.Driver";
    private String url = "jdbc:mysql://localhost/sqldb";
    // private String url = "jdbc:mysql://localhost/sqldb?" + "useUnicode=true&characterEncoding=UTF-8";
    
    private String uid = "root";
    private String upw = "1234";
    
    // DB연결 객체 선언
    private Connection connection = null;
    private PreparedStatement psmt = null;
    private ResultSet set = null;
    HttpSession httpsession = null;
    
     public modifyOk() {
         super();
     }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       System.out.println("doGet() 호출");
       actionDo(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       System.out.println("doPost() 호출");
       actionDo(request, response);
    }
    
    private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       // request, response를 사용하기 위해 예외처리를 한다.
       
       // 한글 깨짐 방지
       request.setCharacterEncoding("UTF-8");
       System.out.println("actionDo()");
       
       // form에서 넘어온 값들을 가져와 저장함.
       id = request.getParameter("id");
     //  System.out.println(id);
       pw = request.getParameter("pw");
      // System.out.println(pw);
       name = request.getParameter("name");
     //  System.out.println(name);
       eMail = request.getParameter("eMail");
     //  System.out.println(eMail);
       address = request.getParameter("address");
     //  System.out.println(address);
       
       Date now = new Date();    // 현재 시스템의 날짜와 시간을 구함(가입일시 저장)
       SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 E요일 a hh시 mm분 ss초");
       rDate = sdf.format(now);
     //  System.out.println(rDate.toString());
       
      
       //패스워드 인증통과하면 아래 쿼리부분 실행
       if(pwConfirm() == true) {
     	  System.out.println("ok");
     	  //수정한 회원정보를 DB에 업데이트하기 위한 커리문
       String query = "update members set pw=?, name=?, eMail=?, address=?, rDate=? where id=?";
       
       try {
          Class.forName(driver);
          connection = DriverManager.getConnection(url, uid, upw);
          psmt = connection.prepareStatement(query);
          psmt.setString(1, pw);
          // System.out.println(pw);
          psmt.setString(2, name);
          // System.out.println(name);
          psmt.setString(3, eMail);
          // System.out.println(eMail);
          psmt.setString(4, address);
          // System.out.println(address);
          psmt.setString(5, rDate);
          // System.out.println(rDate);
          psmt.setString(6, id);
          // System.out.println(id);
          
          // PreparedStatement객체의 executeUpdate()는 반환형이 int이기 때문에
          // 삽입, 수정, 삭제 할 때 진행되었던 row를 리턴한다.
          int i = psmt.executeUpdate();
          // System.out.println(i);
          
          if(i == 1) {
             //System.out.println(i);
        	  httpsession.setAttribute("name", name);
        	  httpsession.setAttribute("id", id);
        	  httpsession.setAttribute("pw", pw);
             System.out.println("데이터 수정 성공!!!");
             response.sendRedirect("modifyResult.jsp");
          } else {
             //System.out.println(i);
             System.out.println("데이터 수정 실패...");
             response.sendRedirect("modify.jsp");
          }
       } catch (Exception e) { e.printStackTrace(); }
       finally {
          try {
             // 리소스 해재
             if(psmt != null) { psmt.close(); }
             if(connection != null) { connection.close(); }
          } catch (Exception e2) { e2.printStackTrace(); }
       }
       
    } else {
        // 패스워드 인증에 실패하면 아래와 같이 실행됨
        System.out.println("안맞네 ㅋㅋ");
        response.sendRedirect("modify.jsp");
     }

}
    //비밀번호를 인증하는 인증하는 메서드
    private boolean pwConfirm() {
    	boolean rs = false;
    	//세션에서 pw의 값을 얻는다.
    	String sessionPw = (String)httpsession.getAttribute("pw");
    	//System.out.println("세션비밀번호 : "+sessionPw);
    	//System.out.println("사용자입력 비밀번호 : "+pw);
    	//그리고 사용자가 입력한 값과 비교하여 같으면 ture, 틀리면 false리턴
    	if(sessionPw.equals(pw)) {
    		rs=true;
    	}else {
    		rs=false;
    	System.out.println("참거짓"+rs);
    	}return rs;
    }
}