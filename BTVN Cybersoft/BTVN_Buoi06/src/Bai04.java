import java.util.Scanner;

public class Bai04 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("Vui lòng nhập số nguyên a = ");
		int a = scan.nextInt();
		System.out.print("Vui lòng nhập số nguyên b = ");
		int b = scan.nextInt();
		int chon;

		do {
			System.out.println("==========MENU========");
			System.out.println("1. Cộng");
			System.out.println("2. Trừ");
			System.out.println("3. Nhân");
			System.out.println("4. Chia");
			System.out.println("0. Thoát");
			System.out.println("Vui lòng chọn: ");
			chon = scan.nextInt();
			
			switch (chon) {
			case 0: {
				System.out.println("Đã thoát chương trình!");
				break;
			}
			case 1:
				System.out.println(a + " + " + b + " = " + cong(a, b));
				break;
			case 2:
				System.out.println(a + " - " + b + " = " + tru(a, b));
				break;
			case 3:
				System.out.println(a + " * " + b + " = " + nhan(a, b));
				break;
			case 4:
				if (b != 0) {
					System.out.println(a + " / " + b + " = " + chia(a, b));
				} else {
					System.out.println("Mẫu số không được bằng 0");
				}
				break;
			default:
				System.out.println("Vui lòng nhập đúng menu!");
			}
		} while (chon!=0);
		

	}
	
	public static int cong(int a, int b) {
		return a + b;
	}
	
	public static int tru(int a, int b) {
		return a - b;
	}
	
	public static int nhan(int a, int b) {
		return a * b;
	}
	
	public static float chia(int a, int b) {
		return a * 1.0f/ b;
		
	}

}
