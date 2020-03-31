package Project1;
import java.util.Scanner;

import Project1.ver05.MenuItem;
import Project1.ver05.PhoneBookManager;

public class PhoneBookVer05 {

	public static void main(String[] args) {
		PhoneBookManager manager = new PhoneBookManager(100);
		manager.printMenu();
	}
}
