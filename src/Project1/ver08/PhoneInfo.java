package Project1.ver08;

import java.io.Serializable;

//직렬화 : 인스턴스가 파일형태로 저장되는것 (PhoneBook.obj)
public class PhoneInfo implements Serializable{
	//멤버변수
	String name;
	String phoneNumber; 
	
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
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
//		result = prime * result + ((phoneNumber == null) ? 0 : phoneNumber.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		PhoneInfo phoneInfo = (PhoneInfo)obj;
		
		if(phoneInfo.name.equals(this.name)) {
			return true;
		}
		else {
			return false;
		}
	}
}
