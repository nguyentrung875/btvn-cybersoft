import java.util.Scanner;

public class Bai8 {
	static final int MIN = -100;
	static final int MAX = 100;
	public static void main(String[] args) {
		//Nhập mảng có n phần tử (bằng tay hoặc tự động) các số nguyên, hiển thị mảng vừa nhập ra màn hình.
		Scanner scan = new Scanner(System.in);
		int n = nhapN(scan);
		int[] b = new int[n];
		b = randomMang(b);
		xuatMang(b);
		inPhanTuChan(b);
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
	
	public static void inPhanTuChan(int array[]) {
		boolean flag = false;
		System.out.println("Các phần tử chẵn trong mảng: ");
		for (int pt : array) {
			if (pt%2 == 0) {
				System.out.print(pt + " ");
				flag = true;
			}
		}
		if (!flag) {
			System.out.println("Mảng không có phần tử chẵn!");
		}
	}
}
