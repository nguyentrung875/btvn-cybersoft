import java.util.Scanner;

public class Bai5 {

	public static void main(String[] args) {
		//Viết chương trình nhập vào N phần trong mảng và gán giá trị cho các phần tử của mảng. Tìm số lớn nhất và số nhỏ nhất của mảng.
		Scanner scan = new Scanner(System.in);
		int n = nhapN(scan);
		int[] a = new int[n];
		a = nhapMang(a, scan);
		xuatMang(a);
		timSoLonNhatVaNhoNhat(a);
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
	public static void timSoLonNhatVaNhoNhat(int a[]) {
		int max = a[0];
		int min = a[0];
		for (int pt : a) {
			if (pt > max) max = pt;
			if (pt < min) min = pt;
		}
		System.out.println("Số lớn nhất là: " + max);
		System.out.println("Số nhỏ nhất là: " + min);
	}
	
}
