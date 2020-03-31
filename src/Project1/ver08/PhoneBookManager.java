package Project1.ver08;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

class MenuSelectException extends Exception{
	public MenuSelectException() {
		super();
	}
}

public class PhoneBookManager {
	
	private HashSet<PhoneInfo> myPhone;
	
	public PhoneBookManager() {
		
		//역직렬화
		try {
			myPhone = new HashSet<PhoneInfo>();
			
			ObjectInputStream in =
					new ObjectInputStream(
							new FileInputStream("src/ver08/PhoneBook.obj"));

		while(true) {
			PhoneInfo info = (PhoneInfo)in.readObject();
			if(info == null) break;
			myPhone.add(info);
		}
		
		in.close();
		
		}
		catch (Exception e) {
			//e.printStackTrace();
		}
		
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
			System.out.print("선택>> ");
			
			try {
				Scanner scan = new Scanner(System.in);
				int choice = scan.nextInt();
				if(!(choice>=1 && choice<=5)) {
					MenuSelectException ex = new MenuSelectException();
					throw ex;							
				}
				switch(choice) {
				
				case MenuItem.INPUT :
					dataInput();
					break;
				case MenuItem.SEARCH:
					dataSearch();
					break;
				case MenuItem.DELETE:
					dataDelete();
					break;
				case MenuItem.SHOW:
					dataAllShow();
					break;
				case MenuItem.EXIT:
					saveInfo();
					System.out.println("프로그램을 종료합니다."); 
					return;
				}
				
			}
			catch (InputMismatchException e) {
				System.out.println("문자를 입력하시면 안됩니다.");
				
			}
			catch (MenuSelectException e) {
				System.out.println("1~5까지의 정수를 입력해주세용~");
				
			}
		}
		
	}
	
	public void overlapInput(boolean a, PhoneInfo info) {
		Scanner scan = new Scanner(System.in);

		if(a == false) {
			System.out.println("같은이름이 있습니다. 덮어쓰기[0] | 메뉴로돌아가기[1] : ");
			int overlap = scan.nextInt();
			
			if(overlap == 0) {
				myPhone.remove(info);
				myPhone.add(info);
				System.out.println("===데이터 입력이 완료되었습니다.===");
			}
		}
		else {
			System.out.println("===데이터 입력이 완료되었습니다.===");
		}
	}
	
	public void dataInput() {
		Scanner scan = new Scanner(System.in);
		String name, phone, major, grade, company;
		try {
			
			System.out.println("===데이터 입력을 시작합니다.===");
			System.out.println("1.일반, 2.동창, 3.회사");
			System.out.print("선택>> ");
			int inputNum = scan.nextInt();
			scan.nextLine(); //버퍼날림
			
			if(!(inputNum>=1 && inputNum<=3)) {
				MenuSelectException ex = new MenuSelectException();
				throw ex;							
			}
			System.out.println("이름 : "); name = scan.nextLine();
			System.out.println("전화번호 : "); phone = scan.nextLine();
			
			if(inputNum == SubMenuItem.ILBAN) {
				
				PhoneInfo info = new PhoneInfo(name,phone);
				boolean a = myPhone.add(info);
			
				overlapInput(a,info);
			}
			
			else if(inputNum == SubMenuItem.SCHOOL) {
				System.out.println("전공: "); major = scan.nextLine();
				System.out.println("학년: "); grade = scan.nextLine();
				
				PhoneInfo scInfo = 
						new PhoneSchoolInfo(name,phone,major,Integer.parseInt(grade));
				boolean a = myPhone.add(scInfo);
				
				overlapInput(a, scInfo);
				
			}
			else if(inputNum == SubMenuItem.COMPANY) {
				System.out.println("회사: "); company = scan.nextLine();
				PhoneInfo cpInfo = 
						new PhoneCompanyInfo(name,phone,company);
				boolean a = myPhone.add(cpInfo);
				
				overlapInput(a,cpInfo);
			}
			
			
		}
		catch (InputMismatchException e) {
			System.out.println("문자를 입력하시면 안됩니다.");
			dataInput();
		}
		catch (MenuSelectException e) {
			System.out.println("1~3중의 숫자를 입력해주세요");
			dataInput();
		}
	}


	public void dataSearch() {
		Scanner scan = new Scanner(System.in);
		System.out.println("데이터 검색을 시작합니다.");
		System.out.println("이름: ");
		String searchName = scan.nextLine();
		
		boolean searchFlag = false;
		
		Iterator<PhoneInfo> itr = myPhone.iterator();
		try {
			while(itr.hasNext()) {
				PhoneInfo phoneInfo = itr.next();
				if(searchName.equals(phoneInfo.name)) {
					
					searchFlag = true;
					phoneInfo.showPhoneInfo();
				}
			}
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		if(searchFlag == true) {
			System.out.println("===입력하신 정보를 찾았습니다.===");
		}
		else {
			System.out.println("===해당정보는 없습니다.===");
		}
		
	}
	
	public void dataDelete() {
		Scanner scan = new Scanner(System.in);
		System.out.println("데이터 삭제를 시작합니다.");
		System.out.println("이름: ");
		String deleteName = scan.nextLine();
		boolean searchFlag = false;
		
		Iterator<PhoneInfo> itr = myPhone.iterator();
		while(itr.hasNext()) {
			PhoneInfo phoneInfo = itr.next();
			if(deleteName.equals(phoneInfo.name)) {
				
				searchFlag = true;
				itr.remove();	
			}
			
		}
		if(searchFlag == true) {
			System.out.println("===데이터가 삭제되었습니다.===");
		
		}
		else {
			System.out.println("===삭제할 데이터가 없습니다.===");
		}
	
	}
	
	public void dataAllShow() {
		
		Iterator<PhoneInfo> itr = myPhone.iterator();
		for(PhoneInfo info : myPhone) {
			info.showPhoneInfo();
		}
		System.out.println();
		System.out.println("===전체정보가 출력되었습니다.==");
		
	}
	
	public void saveInfo() {
		try {
			
			ObjectOutputStream out = new ObjectOutputStream(
					new FileOutputStream("src/ver08/PhoneBook.obj")
					);
			//myFriends 객체배열에 저장된 친구의 정보만큼 반복
			
		
			for(PhoneInfo info : myPhone) {
				//객체배열의 i번째 요소를 파일로 저장
				out.writeObject(info);
			}
			
			out.writeObject(null);
			out.close();
			
		}
		catch (Exception e) {
			System.out.println("예외발생");
			e.printStackTrace();
			// TODO: handle exception
		}
				
	}
}