package sec01_exam;

//DTO��ü��??DB���� �����͸� �߼��������� �������� ���� �ƴ϶�
//�� DB���̺��� �ִ� ������ Ŭ������ �ѹ��� �������� �������� ��ü�� �ǹ��Ѵ�.
public class MemberDto {

	private String id;
	private String pw;
	private String name;
	private String eMail;
	private String rDate;
	private String address;

	// ������
	public MemberDto() {

	}

//�Ű������� �ִ� ������	
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