import java.util.Scanner;

public class Bai03 {

	public static void main(String[] args) {
		int n, tong;
		Scanner scan = new Scanner(System.in);
		do {
			System.out.print("Mời bạn nhập vào số nguyên dương n với 2 ký số = ");
			n = scan.nextInt();
		} while (n > 99 || n < 10);
		tong = n%10 + n/10;
		System.out.println("Tổng 2 ký số của " + n + " là: " + tong);
		scan.close();
	}
}
