import java.util.Scanner;

public class Bai04 {
	final static int n = 5;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int tong = 0;
		for (int i = 1; i <= n; i++) {
			System.out.print("Mời bạn nhập số nguyên thứ " + (i) + ": ");
			int x = scan.nextInt();
			tong += x;
		}
		double trungBinh = tong*1.0/n;
		System.out.println("Số trung bình của " + n + " số bạn nhập là: " + trungBinh);
		scan.close();
	}
}
