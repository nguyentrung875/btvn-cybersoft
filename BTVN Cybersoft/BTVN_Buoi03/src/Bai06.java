import java.util.Scanner;

public class Bai06 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Mời nhập vào USD: ");
		double usd = scan.nextDouble();
		double vnd = (usd * 23500);
		System.out.println(usd + " USD = " + vnd + " VND");
	}

}
