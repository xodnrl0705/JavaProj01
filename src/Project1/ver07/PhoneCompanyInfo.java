package Project1.ver07;

public class PhoneCompanyInfo extends PhoneInfo{

	String company;

	public PhoneCompanyInfo(String name, String phoneNumber,
				String company) {
		super(name, phoneNumber);
		this.company = company;
	}
	
	@Override
	public void showPhoneInfo() {
		super.showPhoneInfo();
		System.out.println("회사: " + company);
	}
	
	
}
