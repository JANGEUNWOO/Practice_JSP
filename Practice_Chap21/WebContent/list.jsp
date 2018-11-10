<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.ResultSet"%>

<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%!//아래와 같이 선언할 때 Ctrl+Space바를 누르면 자동완성 기능을 이용하면 위에 페이지에 지시자를 통해 자동 import된다.
	Connection connection; //연결할 객체선언
	Statement statement; //쿼리문을 실행할 객체 선언
	ResultSet resultSet; //쿼리문의 실행 결과를 받아내는 객체 선언
	String driver = "com.mysql.jdbc.Driver"; //mysql드라이버 명시
	//mysql접속 위치(jdbc:mysql:->프로토콜,) //localhost ->도메인, :3306 ->포트번호, sqldb->접속 DB명
	String url = "jdbc:mysql://localhost:3306/sqldb";
	String id = "root"; //접속 아이디
	String pw = "1234"; //접속 비밀번호
	//쿼리문 작성
	String query = "select*from members order by name";%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		try {
			//하기 아래의 순서는 반드시 알아야한다. 그래야 접속도 하고 쿼리도 날릴 수 있다.
			//드라이버 로드
			//forName()은 일반예외를 발생하므로 예외 처리를 해줘야 한다.
			Class.forName(driver);
			System.out.println("드라이버 로드 성공");
			//connection객체를 DriverManager클래스를 통해 url,id,pw를 주고 얻는다.
			connection = DriverManager.getConnection(url, id, pw);
			//쿼리문 실행할 Statement객체를 connerction객체로 얻음
			statement = connection.createStatement();
			//쿼리문의 실행결과를 resultSet객체에 얻음
			resultSet = statement.executeQuery(query);
			//쿼리문의 결과가 resultSet객체에 담기기 대문에 BOF를 커서가 가리키고 있다.
			//하여 아래와 같이 루프를 돌면서 하나씩 데이터를 가져온다.
			//언제까지? EOF를 만날 때 까지... 가져올게 있느냐?
			while (resultSet.next()) {
				String id = resultSet.getString("id");
				String pw = resultSet.getString("pw");
				String name = resultSet.getString("name");
				String eMail = resultSet.getString("eMail");
				out.println("  아이디: " + id + "   비밀번호: " + pw + "   이름: " + name + "   이메일: " + eMail + "<br>");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		//이미 자바에서 학습했다. finally부분은 정상실행이 되면 예외가 발생하던지간에 무조건 실행하는 부분이다. 물론 옵션이기도 하다.
		finally {
			try {
				//위에서 사용한 리소스를 해제하는 부분(역순으로 해준다)
				if (request != null)
					resultSet.close();
				if (statement != null)
					statement.close();
				if (connection != null)
					connection.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	%>
</body>
</html>