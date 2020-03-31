package Project1;
import java.util.Scanner;

import Project1.ver04.PhoneBookManager;
import Project1.ver04.PhoneInfo;

public class PhoneBookVer04 {

	public static void main(String[] args) {
		PhoneBookManager manager = new PhoneBookManager(100);
		manager.printMenu();
	}
}