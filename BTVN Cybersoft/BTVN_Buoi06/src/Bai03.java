import java.util.Scanner;

public class Bai03 {

	public static void main(String[] args) {
		// Viết hàm tính tổng 3 số do người dùng nhập
		Scanner scan = new Scanner(System.in);
		System.out.print("Mời nhập vào số a: ");
		int a = scan.nextInt();
		System.out.print("Mời nhập vào số b: ");
		int b = scan.nextInt();
		System.out.print("Mời nhập vào số c: ");
		int c = scan.nextInt();
		System.out.println("Số lớn nhất là: " + tinhTong(a, b, c));
	}
	
	public static int tinhTong(int a, int b, int c) {
		return a + b + c;
	}

}
