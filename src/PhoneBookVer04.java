import java.util.Scanner;
import ver04.PhoneInfo;
import ver04.PhoneBookManager;

public class PhoneBookVer04 {

	public static void main(String[] args) {
		PhoneBookManager manager = new PhoneBookManager(100);
		manager.printMenu();
	}
}