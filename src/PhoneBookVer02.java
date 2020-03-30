import java.util.Scanner;
import ver02.PhoneInfo;

public class PhoneBookVer02 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		while(true) {
			System.out.println("선택하세요...");
			System.out.println("1.데이터 입력");
			System.out.println("2.프로그램 종료");
			System.out.print("선택: ");
			int inputNum = scan.nextInt();
			scan.nextLine(); //버퍼날림
			
			if(inputNum == 1) {
				String name, phone, birthday;
				System.out.println("이름 : "); name = scan.nextLine();
				System.out.println("전화번호 : "); phone = scan.nextLine();
				System.out.println("생년월일 : "); birthday = scan.nextLine();
				
				PhoneInfo info = new PhoneInfo(name,phone,birthday);
				info.showPhoneInfo();
				
			}
			
			else if(inputNum == 2){
				System.out.println("프로그램을 종료합니다.");
				break; //break는 반복문만 탈출
			}

		}
		
	}

}
