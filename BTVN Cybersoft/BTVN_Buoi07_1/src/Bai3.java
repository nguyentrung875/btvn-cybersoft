import java.util.Scanner;

public class Bai3 {

	public static void main(String[] args) {
		//Viết chương trình cho phép nhập vào một số nguyên dương n, tính tổng tất cả số chẵn trong khoảng từ 0 - n.
		int n;

		do {
			Scanner scan = new Scanner(System.in);
			System.out.print("Nhập vào số nguyên dương n: ");
			n = scan.nextInt();
		} while (n < 0);
		tinhTongCacSoChan(n);
		
	}
	
	public static void tinhTongCacSoChan(int n) {
		int tong = 0;
		for (int i = 0; i <= n; i+=2) {
			tong += i;
		}
		System.out.println("Tổng các số chẵn từ 0 - " + n + " là: " + tong);
	}

}
