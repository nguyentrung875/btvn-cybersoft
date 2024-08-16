import java.util.Scanner;

public class Bai05 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("Mời nhập vào Độ C: ");
		double doC = scan.nextDouble();
		double doF = (doC * 1.8) + 32;
		System.out.println(doC + " độ C = " + doF + " độ F");
	}
}
