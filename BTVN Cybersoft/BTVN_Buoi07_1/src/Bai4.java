import java.util.Scanner;

public class Bai4 {

	public static void main(String[] args) {
		/*
		• Viết chương trình cho phép nhập vào n, sau đó nhập vào n phần tử số nguyên.
		• Cuối cùng, chương trình sẽ xuất ra giá trị trung bình của mảng này.
		 */
		Scanner scan = new Scanner(System.in);
		int n = nhapN(scan);
		int[] a = new int[n];
		a = nhapMang(a, scan);
		xuatMang(a);
		tinhTrungBinh(a);
		
	}
	
	public static int nhapN(Scanner scan) {
		int n;
		do {
			System.out.print("Vui lòng nhập số phần tử n cho mảng: ");
			n = scan.nextInt();
		} while (n <= 0);
		return n;
		
	}
	
	public static int[] nhapMang(int array[], Scanner scan) {
		for (int i = 0; i < array.length; i++) {
			System.out.print("a[" + i + "] = ");
			array[i] = scan.nextInt();
		}
		return array;
	}
	
	public static void xuatMang(int array[]) {
		System.out.println("Xuất mảng: ");
		for (int pt : array) {
			System.out.print(pt + " ");
		}
		System.out.println();
	}
	
	public static void tinhTrungBinh(int a[]) {
		int tong = 0;
		for (int pt : a) {
			tong += pt;
		}
		double trungBinh = tong*1.0/a.length;
		System.out.println("Giá trị trung bình của mảng là: " + trungBinh);
	}

}
