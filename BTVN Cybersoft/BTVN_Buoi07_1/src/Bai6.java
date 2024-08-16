import java.util.Scanner;

public class Bai6 {

	public static void main(String[] args) {
		/* 
		•	Viết một chương nhập vào chiều rộng của hình vuông và có các phương thức sau:
		•	Phương thức tính diện tích hình vuông.
		•	Phương thức tính chu vi hình vuông.
		 */
		Scanner scan = new Scanner(System.in);
		System.out.println("Vui lòng nhập vào chiều rộng hình vuông: ");
		double a = scan.nextDouble();
		tinhDienTichHinhVuong(a);
		tinhChuViHinhVuong(a);
	}
	
	public static void tinhDienTichHinhVuong(double a) {
		System.out.println("Diện tích hình vuông: " + (a*a));
	}
	
	public static void tinhChuViHinhVuong(double a) {
		System.out.println("Chu vi hình vuông: " + (4*a));
	}

}
