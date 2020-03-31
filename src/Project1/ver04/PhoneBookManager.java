package Project1.ver04;

import java.util.Scanner;

public class PhoneBookManager {
	
	private PhoneInfo[] myPhones;
	private int numOfInfo;
	
	public PhoneBookManager(int num) {
		
		myPhones = new PhoneInfo[num];
		numOfInfo=0;
	}
	public void printMenu() {
		
		while(true) {
			
			
			System.out.println("==================");
			System.out.println("선택하세요...");
			System.out.println("1. 데이터 입력");
			System.out.println("2. 데이터 검색");
			System.out.println("3. 데이터 삭제");
			System.out.println("4. 주소록 출력");
			System.out.println("5. 프로그램 종료");
			System.out.print("선택: "); 
			
			Scanner scan = new Scanner(System.in);
			int choice = scan.nextInt();
			
			switch(choice) {
			
			case 1:
				dataInput();
				break;
			case 2:
				dataSearch();
				break;
			case 3:
				dataDelete();
				break;
			case 4:
				dataAllShow();
				break;
			case 5:
				System.out.println("프로그램을 종료합니다.");
				return;
			}
		}
	}
	
	
	
	public void dataInput() {
		Scanner scan = new Scanner(System.in);
		String name, phone, major, grade, company;
		
		System.out.println("===데이터 입력을 시작합니다.===");
		System.out.println("1.일반, 2.동창, 3.회사");
		System.out.print("선택>> ");
		int inputNum = scan.nextInt();
		scan.nextLine(); //버퍼날림
		
		//공통 데이터
		System.out.println("이름 : "); name = scan.nextLine();
		System.out.println("전화번호 : "); phone = scan.nextLine();
		
		if(inputNum == 1) {
			PhoneInfo info = new PhoneInfo(name,phone);
			myPhones[numOfInfo++] = info;
			System.out.println("===데이터 입력이 완료되었습니다.===");
		}
		
		else if(inputNum == 2) {
			System.out.println("전공: "); major = scan.nextLine();
			System.out.println("학년: "); grade = scan.nextLine();
			PhoneSchoolInfo scInfo = 
					new PhoneSchoolInfo(name,phone,major,Integer.parseInt(grade));
			myPhones[numOfInfo++] = scInfo;
			System.out.println("===데이터 입력이 완료되었습니다.===");
		}
		else if(inputNum == 3) {
			System.out.println("회사: "); company = scan.nextLine();
			PhoneCompanyInfo cpInfo = 
					new PhoneCompanyInfo(name,phone,company);
			myPhones[numOfInfo++] = cpInfo;
			System.out.println("===데이터 입력이 완료되었습니다.===");
		}
		
	}


	public void dataSearch() {
		Scanner scan = new Scanner(System.in);
		System.out.println("데이터 검색을 시작합니다.");
		System.out.println("이름: ");
		String searchName = scan.nextLine();
		
		
		for(int i=0; i<numOfInfo; i++) {
			if(searchName.compareTo(myPhones[i].name)==0) {
				myPhones[i].showPhoneInfo();
				System.out.println("===데이터 검색이 완료되었습니다.===");
			}
		}
	}
	public void dataDelete() {
		Scanner scan = new Scanner(System.in);
		System.out.println("데이터 삭제를 시작합니다.");
		System.out.println("이름: ");
		String deleteName = scan.nextLine();
		
		int deleteIndex = -1;
		
		for(int i=0; i<numOfInfo; i++) {
			if(deleteName.compareTo(myPhones[i].name)==0) {
				myPhones[i] = null;
				deleteIndex = i;
				numOfInfo--;
				break;
			}
		}
		if (deleteIndex == -1) {
			System.out.println("===삭제된 데이터가 없습니다.===");
		}
		else {
			
			for(int i = deleteIndex; i < numOfInfo; i++) {
				myPhones[i] = myPhones[i+1];
			}
			System.out.println("===데이터 (" + deleteIndex+ "번)가 삭제되었습니다.===");
		}

	}
	public void dataAllShow() {
		for(int i=0; i<numOfInfo;i++) {
			myPhones[i].showPhoneInfo();
			System.out.println();
		}
		System.out.println("===전체정보가 출력되었습니다.==");

	}
	
}
