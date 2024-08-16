import java.util.Scanner;

public class Bai1 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("Vui lòng nhập vào số nguyên: ");
		int n = scan.nextInt();
		ktraSoNguyen(n);
		ktraChanLe(n);
		ktraSoNguyenTo(n);
	}
	
	public static void ktraSoNguyen(int n) {
		if (n > 0) {
			System.out.println(n + " là số nguyên dương");
		} else if (n < 0){
			System.out.println(n + " là số nguyên âm");
		} else {
			System.out.println("Đây là số 0");
		}
	}
	
	public static void ktraChanLe(int n) {
		if (n % 2 == 0) {
			System.out.println(n + " là số chẵn");
		} else {
			System.out.println(n + " là số lẻ");
		}
	}
	
	public static void ktraSoNguyenTo(int n) {
		if (n < 2) {
			System.out.println(n + " không phải là số nguyên tố");
			return;
		}
		
		for (int i = 2; i < Math.sqrt(n); i++) {
			if (n % i == 0) {
				System.out.println(n + " không phải là số nguyên tố");
				return;
			}
		}
		System.out.println(n + " là số nguyên tố");
		return;
	}

}
