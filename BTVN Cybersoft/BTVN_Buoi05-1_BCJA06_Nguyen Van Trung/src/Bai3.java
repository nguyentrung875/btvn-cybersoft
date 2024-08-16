import java.util.Scanner;

public class Bai3 {

	public static void main(String[] args) {
		//Viết chương trình tính tổng các số lẻ nguyên dương nhỏ hơn n
		int n;
		int tongSoLe = 0;
		
		do {
			System.out.print("Nhập số nguyên dương n = ");
			Scanner scan = new Scanner(System.in);
			n = Integer.parseInt(scan.nextLine());
			for (int i = 1; i < n; i+=2) {
					tongSoLe += i;
			}
		} while (n <= 0);
		System.out.println("Tổng số lẻ cần tìm = " + tongSoLe);
	}

}
