package ver07;

public class PhoneSchoolInfo extends PhoneInfo{
	//멤버변수
	String major;
	int grade;
	
	//생성자
	public PhoneSchoolInfo(String name, String phoneNumber,
				String major, int grade) {
		super(name, phoneNumber);
		this.major = major;
		this.grade = grade;
	}
	
	@Override
	public void showPhoneInfo() {
		
		super.showPhoneInfo();
		System.out.println("전공: " + major);
		System.out.println("학년: " + grade);
	}
	
	

	
}
