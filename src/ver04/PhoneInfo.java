package ver04;


public class PhoneInfo {
	//멤버변수
	String name;
	String phoneNumber; 
	
	//생성자
	public PhoneInfo(String name, String phoneNumber) {

		this.name = name;
		this.phoneNumber = phoneNumber;

	}
	
	//정보출력용 메소드
	public void showPhoneInfo() {
		System.out.println();
		System.out.println("이름: " + name);
		System.out.println("전화번호: " + phoneNumber);
		
	}
	
	
	
}
