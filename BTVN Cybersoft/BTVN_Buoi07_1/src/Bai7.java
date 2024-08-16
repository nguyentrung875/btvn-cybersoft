import java.util.Scanner;

public class Bai7 {
	static final int MIN = -100;
	static final int MAX = 100;
	public static void main(String[] args) {
		//Nhập mảng có n phần tử (bằng tay hoặc tự động) các số nguyên, hiển thị mảng vừa nhập ra màn hình.
		Scanner scan = new Scanner(System.in);
		int n = nhapN(scan);
		int[] a = new int[n];
		int[] b = new int[n];
		a = nhapMang(a, scan);
		xuatMang(a);
		b = randomMang(b);
		xuatMang(b);
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
	
	public static int[] randomMang(int array[]) {
		for (int i = 0; i < array.length; i++) {
			array[i] = (int) ((Math.random() * (MAX - MIN)) + MIN);
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

}
