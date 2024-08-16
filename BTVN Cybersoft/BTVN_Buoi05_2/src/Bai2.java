import java.util.Scanner;

public class Bai2 {
	//Tỉnh tổng các số chẵn từ 1 đến n
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n;
		do {
			System.out.print("Nhập số nguyên dương n > 1: ");
			n = scan.nextInt();
		} while (n <= 1);
		
		//Dùng while
		int tong = 0;
		int number = 1;
		while (number <= n) {
			if (number % 2 == 0) {
				tong += number;
			}
			number++;
		}
		System.out.println("Tổng số chẵn dùng while: " + tong);
		
		//Dùng for
		tong = 0;
		for (int i = 2; i <= n; i+=2) {
			tong += i;
		}
		System.out.println("Tổng số chẵn dùng for: " + tong);
	}

}
