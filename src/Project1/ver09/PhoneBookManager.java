package Project1.ver09;

import java.sql.SQLException;
import java.util.Scanner;

public class PhoneBookManager extends ConnectDB{
	
	public PhoneBookManager() {
		super();
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
			scan.nextLine();
			
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
				close();
				return;
			}
		}
	}
		
	//?사용(prepared)
	public void dataInput() {
		
		try {
			//1.쿼리문준비
			String query = "INSERT INTO phonebook_tb VALUES (?, ?, ?)";
			
			//2.prepared객체 생성
			psmt = con.prepareStatement(query);
			
			//3.DB입력값 입력받음.
			Scanner scan = new Scanner(System.in);
			System.out.println("이름: ");
			String name = scan.nextLine();
			System.out.println("전화번호: ");
			String phone = scan.nextLine();
			System.out.println("생년월일: ");
			String birth = scan.nextLine();
			
			//4.인파라미터 설정하기 : ?의 순서대로 설정하고 DB이므로 인덱스는 1부터
			psmt.setString(1, name);
			psmt.setString(2, phone);
			psmt.setString(3, birth);
			
			//5.쿼리실행을 위해 prepared객체 실행.
			int affected = psmt.executeUpdate();
			System.out.println(affected + "행이 입력되었습니다.");
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}

	}
	//?사용(prepared)
	public void dataDelete() {
		try {
			//1.쿼리문준비
			String query = "DELETE FROM phonebook_tb WHERE name =?";
			//2.prepared객체 생성
			psmt = con.prepareStatement(query);
			//3.DB입력값 입력받음.
			Scanner scan = new Scanner(System.in);
			System.out.print("삭제할 이름을 입력 : ");
			String inputStr = scan.nextLine();
			//4.인파라미터 설정하기 : ?의 순서대로 설정하고 DB이므로 인덱스는 1부터
			psmt.setString(1, inputStr);
			//5.쿼리실행을 위해 prepared객체 실행.
			System.out.println(psmt.executeUpdate()+"행이 삭제되었습니다");
		}
		catch (Exception e) {
	         e.printStackTrace();
	    }

	}
	//기본(statement)
	public void dataSearch() {
		
		try {
			Scanner scan = new Scanner(System.in);
			System.out.println("데이터 검색을 시작합니다.");
			System.out.println("이름: ");
			String searchName = scan.nextLine();
			
			stmt = con.createStatement();
	         
	        String query = "SELECT name, phone_num, birth from phonebook_tb "
	        		+ " Where name like '" + searchName + "'";
	        rs = stmt.executeQuery(query);
	        
	        while(rs.next()) {
	        	
	        	String name = rs.getString(1);//employee_id컬럼
				String phone = rs.getString(2);//컬럼명을 그대로 이용함
				String birth = rs.getString(3);
				
				System.out.printf("%s %s %s%n",
						name, phone, birth);
	      
	         }
	      }
	      catch (SQLException e) {
	         System.out.println("쿼리오류발생");
	         e.printStackTrace();
	      }

	}
	
	public void dataAllShow() {
		try {
			stmt = con.createStatement();
	         
	        String query = "SELECT * from phonebook_tb";
	        
	        rs = stmt.executeQuery(query);
	        
	        while(rs.next()) {
	        	String name = rs.getString(1);//employee_id컬럼
				String phone = rs.getString(2);//컬럼명을 그대로 이용함
				String birth = rs.getString(3);
				
				System.out.printf("%s %s %s%n",
						name, phone, birth);
	         }
	      }
	      catch (SQLException e) {
	         System.out.println("쿼리오류발생");
	         e.printStackTrace();
	      }

		System.out.println("===전체정보가 출력되었습니다.==");

	}
	
}

