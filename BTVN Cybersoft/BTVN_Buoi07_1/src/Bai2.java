import java.util.Scanner;

public class Bai2 {

	public static void main(String[] args) {
		//Viết chương trình cho phép nhập vào một số nguyên dạng số từ 1 đến 10, sau khi chạy thì chương trình sẽ ghi số đó ra dưới dạng chữ.
		int number;

		do {
			Scanner scan = new Scanner(System.in);
			System.out.print("Nhập vào số nguyên từ 1 đến 10: ");
			number = scan.nextInt();
		} while (number < 1 || number > 10);
		chuyenSoThanhChu(number);
	}
	
	public static void chuyenSoThanhChu(int num) {
		String a[] = {"Không","Một", "Hai", "Ba", "Bốn", "Năm", "Sáu", "Bảy", "Tám", "Chín", "Mười"};
		for (int i = 1; i < a.length; i++) {
			if (num == i) {
				System.out.println(a[i]);
			}
		}
	}

}
