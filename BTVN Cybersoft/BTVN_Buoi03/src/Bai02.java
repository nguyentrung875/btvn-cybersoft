import java.util.Scanner;

public class Bai02 {

	public static void main(String[] args) {
		double P;
		double a;
		int n;
		int x = 8;
		Scanner scan = new Scanner(System.in);
		System.out.print("Mời bạn nhập vào số thực a = ");
		a = scan.nextDouble();
		System.out.print("Mời bạn nhập vào số nguyên dương n = ");
		n = scan.nextInt();		
		P = a*Math.pow(x, n);
		System.out.println("Giá trị phương thức P = ax^n = " + P);
	}
}
