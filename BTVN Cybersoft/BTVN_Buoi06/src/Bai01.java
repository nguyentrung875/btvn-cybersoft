import java.util.Scanner;

public class Bai01 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("Mời nhập vào số a: ");
		int a = scan.nextInt();
		System.out.print("Mời nhập vào số b: ");
		int b = scan.nextInt();
		System.out.print("Mời nhập vào số c: ");
		int c = scan.nextInt();
		System.out.println("Số lớn nhất là: " + timSoLonNhat(a, b, c));
	}
	
	//Bài 1: Tìm số lớn nhất trong 3 số
	public static int timSoLonNhat(int a, int b, int c) {
		int max = a;
		max = b > max ? b : max;
		max = c > max ? c : max;
		return max;
	}

}
