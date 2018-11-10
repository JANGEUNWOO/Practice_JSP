package sec01_exam;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.apache.jasper.tagplugins.jstl.core.Catch;

import com.sun.corba.se.impl.ior.GenericTaggedComponent;

public class MemberDao {

   // DB�� ���� Access�ϴ� Ŭ���� ������(DAO)

   // ȸ���� �����ϱ� ���� �⺻���� ����� �����Ѵ�.
   public static final int MEMBER_NONEXISTENT = 0;
   public static final int MEMBER_EXISTENT = 1;
   public static final int MEMBER_JOIN_FAIL = 0;
   public static final int MEMBER_JOIN_SUCCESS = 1;
   public static final int MEMBER_LOGIN_PW_NO_GOOD = 0;
   public static final int MEMBER_LOGIN_SUCCESS = 1;
   public static final int MEMBER_LOGIN_IS_NOT = -1;

   // �̱��� ������. �ڹٿ��� �̹� �����.
   private static MemberDao instance = new MemberDao();
   // �ܺο��� �����ڸ� ȣ���Ͽ� �ν��Ͻ��� �������� �ʵ��� �Ѵ�. (���������ڰ� private)
   // �� 1���� �ν��Ͻ��� ������. ���� �ּҴ� ��� �����ϴ�.

   private MemberDao() {
   }

   // ������ �ν��Ͻ��� ������ �ְ� �ִ�.
   public static MemberDao getInstance() {
      return instance;
   }

   // ȸ���� �����͸� DB�� �����ϴ� �޼���
   public int insertMember(MemberDto dto) {

      int ri = 0;

      Connection conn = null;
      PreparedStatement pstmt = null;
      String query = "insert into members values(?, ?, ?, ?, ?, ?)";

      try {
         conn = this.getConnection();

         // ������ �̸� �غ��Ѵ�.
         pstmt = conn.prepareStatement(query);
         pstmt.setString(1, dto.getId());
         pstmt.setString(2, dto.getPw());
         pstmt.setString(3, dto.getName());
         pstmt.setString(4, dto.geteMail());
         pstmt.setString(5, dto.getrDate());
         pstmt.setString(6, dto.getAddress());

         /*
          * executeQuery()�޼���� �ϳ��� Resultset�� ����� SQL������ ���Ǹ�, executeUpdate() �޼����
          * insert, update �Ǵ� delete����, �׸��� ���� create table �� drop table�� ���� sql ddl������
          * �����ϴµ� ���Ǿ�����.
          * 
          * insert, update, delete ���� ����� ���̺����� 0�̳� ���� ���� ������ �ϳ� �̻��� ���� �����ϴ� ���̴�.
          * executeUpdate�� ���ϰ��� �ۿ��� ���� ����(���� ī��Ʈ�� ���ֵǴ�)�� ��Ÿ���� �����̴�. �̰��� update���� ����ʹ�
          * �������� �ٸ���. create table�� ���� sql������ �Ǵٸ� ��Ȳ�̴�.
          * 
          * �� �װ��� ���̺��� �����, ���̺��� ����� ���� ���������, �ƹ��͵� ���������� �ʴ´�. �̷��� ��쿡 executeUpdate()������
          * 0�� �����Ѵ�. ���� executeUpdate()�� ���ϰ��� 0 �϶�, �װ��� ���� �� ���� �� �ϳ��� �ǹ��Ѵ�.
          * 
          * 1. ����� sql���� ���鿡 ������ ���� �ʴ� insert, update Ȥ�� delete���̴�. 2. ����� sql���� ddl ���̴�.
          * 
          * ���๮�� ���� ��� �޼������ �ϳ��� ���µǾ� �ִٸ� ȣ��� Statement��ü�� ���� resultset�� �ݾƾ� �Ѵ�. �̰���
          * Statement��ü�� �ٽ� �����ϱ� ���� ���� Resultset��ü�� ��� ó���� �ϰ��ؾ� �� �ʿ䰡 �ִٴ� ���� �ǹ��Ѵ�.
          */

         pstmt.executeUpdate();
         // ȸ�� ������ �����Ǿ����Ƿ�, 1�� �����ϰ� �����Ѵ�.
         ri = MemberDao.MEMBER_JOIN_SUCCESS;
      } catch (Exception e) {
         e.printStackTrace();
      } finally {
         try {
            if (pstmt != null)
               pstmt.close();
            if (conn != null)
               conn.close();
         } catch (Exception e2) {
            e2.printStackTrace();
         }
      }
      return ri;
   }

   // ȸ���� �����ϴ����� Ȯ���ϴ� �޼���
   public int confirmId(String id) {
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

         // ȸ�� id�� ������ ���
         if (set.next()) {
            // ri�� 1�� ����
            ri = MemberDao.MEMBER_EXISTENT;
         } else {
            // ���ٸ� 0 ���� ������
            ri = MemberDao.MEMBER_NONEXISTENT;
         }
      } catch (Exception e) {
         e.printStackTrace();
      } finally {
         try {
            set.close();
            pstmt.close();
            conn.close();
         } catch (Exception e2) {
            e2.printStackTrace();
         }
      }
      return ri;
   }

   // ȸ������ ��ȸ������ Ȯ���ϴ� �޼���
   public int userCheck(String id, String pw) {
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

         if (set.next()) {
            dbPw = set.getString("pw");
            if (dbPw.equals(pw)) {
               // DB�� ������ pw�� ���Ͽ� ������ 1�� ����
               ri = MemberDao.MEMBER_LOGIN_SUCCESS; // �α��� ����
            } else {
               // DB�� ������ pw�� ���Ͽ� Ʋ���� 0 ���� ����
               ri = MemberDao.MEMBER_LOGIN_PW_NO_GOOD; // ��й�ȣ�� Ʋ��
            }
         } else {
            // ȸ��� �������� ���� ���� -1�� ������
            ri = MemberDao.MEMBER_LOGIN_IS_NOT; // ȸ������ ����
         }
      } catch (Exception e) {
         e.printStackTrace();
      } finally {
         try {
            set.close();
            pstmt.close();
            conn.close();
         } catch (Exception e2) {
            e2.printStackTrace();
         }
      }
      return ri;
   }

   // �� ���� ȸ���� ������ id������ db���� �������� �޼���
   public MemberDto getMember(String id) {
      Connection conn = null;
      PreparedStatement pstmt = null;
      ResultSet set = null;
      String query = "select * from members where id = ?";
      MemberDto dto = null; // DTO����
      try {
         conn = getConnection();
         pstmt = conn.prepareStatement(query);
         pstmt.setString(1, id);
         set = pstmt.executeQuery();
         // id�� �����ϸ�...
         if (set.next()) {
            dto = new MemberDto(); // DTO����
            // DTO�� setter�� �̿��ؼ� DB�� �� ������ �����Ѵ�.
            dto.setId(set.getString("id"));
            dto.setPw(set.getString("pw"));
            dto.setName(set.getString("name"));
            dto.seteMail(set.getString("eMail"));
            dto.setrDate(set.getString("rDate"));
            dto.setAddress(set.getString("addreess"));
         }
      } catch (Exception e) {
         e.printStackTrace();
      } finally {
         try {
            set.close();
            pstmt.close();
            conn.close();
         } catch (Exception e2) {
            e2.printStackTrace();
         }
         // dto�� �����Ѵ�.
      }
      return dto;
   }

   // ȸ�� ������ �����ϸ� �װ��� DB�� Update�ϴ� �޼���
   public int updateMember(MemberDto dto) {
      int ri = 0;
      Connection conn = null;
      PreparedStatement pstmt = null;
      String query = "update members set pw=?, eMail=?, address=?" + "where id=?";
      try {
         conn = getConnection();
         // ����ڰ� �Է��� ���� DB�� �����ϱ� ���� ������ �غ�
         pstmt = conn.prepareStatement(query);
         pstmt.setString(1, dto.getPw());
         pstmt.setString(2, dto.geteMail());
         pstmt.setString(3, dto.getAddress());
         pstmt.setString(4, dto.getId());

         // ������ �Ǿ��ٸ� ri�� 1�� ������ �� ���̴�.
         // (�Ѹ��� ȸ���� ������ �����Ǿ��� �����̴�.)
         ri = pstmt.executeUpdate();
         System.out.println(ri);

      } catch (Exception e) {
         e.printStackTrace();
      } finally {
         try {
            pstmt.close();
            conn.close();
         } catch (Exception e2) {
            e2.printStackTrace();
         }
      }
      return ri;
   }

   // DBCP���� DB Ŀ�ؼ��� ������ �޼���
   private Connection getConnection() {
      Context context = null;
      DataSource dataSource = null;
      Connection conn = null;

      // �̹� �ռ� �忡�� Context�� DBCP�� �����Ͽ��⿡ Context�� ��´�.
      // ������ �����Ǹ鼭 DBCP�� ��������� ������ �����ٰ� ���� �Ǵ� ���̴�.
      try {
         context = new InitialContext();
         // context���� lookup�Ͽ� �Ű������� java:comp/env/jdbc/dbtool�� �־��ָ�
         // DataSource��ü�� ����ȯ���� ���� �� �ִ�.
         // DataSource�� �������̽��ν� DBCP���� Ŀ�ؼ� ��ü�� ���´�.
         dataSource = (DataSource) context.lookup("java:comp/env/jdbc/dbtool");
         conn = dataSource.getConnection();
         System.out.println(" DBCP ���� ���� ");
      } catch (Exception e) {
         e.printStackTrace();
      }
      return conn;
   }
}