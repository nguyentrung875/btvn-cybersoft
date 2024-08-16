import java.util.Scanner;

public class Bai02 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("Mời nhập một số kiểm tra chẵn lẻ: ");
		int num = scan.nextInt();
		ktraChanLe(num);

	}

	public static void ktraChanLe(int number) {
		if (number % 2 == 0) {
			System.out.println("Số bạn nhập là chẵn");
		} else {
			System.out.println("Số bạn nhập là lẻ");
		}
	}

}
