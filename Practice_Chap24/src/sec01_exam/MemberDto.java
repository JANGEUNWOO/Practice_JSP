package sec01_exam;

//DTO객체란??DB에서 데이터를 중수난방으로 가져오는 것이 아니라
//각 DB테이블에 있는 내용을 클래스로 한번에 보기좋게 가져오는 객체를 의미한다.
public class MemberDto {

	private String id;
	private String pw;
	private String name;
	private String eMail;
	private String rDate;
	private String address;

	// 생성자
	public MemberDto() {

	}

//매개변수가 있는 생성자	
	public MemberDto(String id, String pw, String name, String eMail, String rDate, String address) {
		this.name = name;
		this.id = id;
		this.pw = pw;
		this.eMail = eMail;
		this.address = address;
		this.rDate = rDate;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	public String getrDate() {
		return rDate;
	}

	public void setrDate(String rDate) {
		this.rDate = rDate;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
