import java.util.Scanner;

public class BTBuoi07 {

	public static void main(String[] args) {	
		Scanner scan = new Scanner(System.in);
		int n = nhapN(scan);
		int[] a = new int[n];
		a = nhapMang(a, scan);
		xuatMang(a);
		
		//b. Tìm số lớn nhất trong mảng
		int indexMax = timIndexSoLonNhat(a);
		System.out.println("b. Số lớn nhất trong mảng là: " + a[indexMax] + "(Vị trí: " + indexMax +")");
		
		//c. Tìm số âm đầu tiên trong mảng
		int indexAmDauTien = timIndexSoAmDauTien(a);
		if (indexAmDauTien == -1) {
			System.out.println("c. Mảng không có số âm");
		} else {
			System.out.println("c. Số âm đầu tiên trong mảng là: " + a[indexAmDauTien] + "(Vị trí: " + indexAmDauTien +")");

		}
		
		//d. Tìm số âm lớn nhất trong mảng
		int indexAmLonNhat = timIndexSoAmLonNhat(a);
		if (indexAmLonNhat == -1) {
			System.out.println("d. Mảng không có số âm");
		} else {
			System.out.println("d. Số âm lớn nhất trong mảng là: " + a[indexAmLonNhat] + "(Vị trí: " + indexAmLonNhat +")");
		}
		
		//e. Tính tổng các số chẵn
		tongSoChan(a);
		
		//f. Đếm số âm và tính tổng các số âm
		demSoAm(a);
		
		//h. Tìm x có trong mảng đó hay không
		timX(a, scan);
		
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
	
	public static int timIndexSoLonNhat(int array[]) {
		int indexMax = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] > array[indexMax]) {
				indexMax = i;
			}
		}
		return indexMax;
	}
	
	public static int timIndexSoAmDauTien(int array[]) {
		int index = -1; //mảng ko có số âm
		for (int i = 0; i < array.length; i++) {
			if (array[i] < 0) {
				index = i;
				break;
			}
		}
		return index;
	}
	
	public static int timIndexSoAmLonNhat(int array[]) {
		int indexAmLonNhat = -1;
		int indexAmDauTien = timIndexSoAmDauTien(array);
		if (indexAmDauTien == -1) {
			indexAmLonNhat = -1;
		} else {
			indexAmLonNhat = indexAmDauTien;
			for (int i = indexAmDauTien + 1; i < array.length; i++) {
				if (array[i] < 0 && array[i] > array[indexAmLonNhat]) {
					indexAmLonNhat = i;
				}
			}
		}
		return indexAmLonNhat;
	}
	
	public static void tongSoChan(int array[]) {
		int tong = 0;
		for (int pt : array) {
			if (pt % 2 == 0) {
				tong += pt;
			}
		}
		System.out.println("e. Tổng các số chẵn trong mảng là: " + tong);
	}
	
	public static void demSoAm(int array[]) {
		int dem = 0;
		int tong = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] < 0) {
				dem++;
				tong += array[i];
			}
		}
		System.out.println("f. Mảng có " + dem + " số âm");
		System.out.println("g. Tổng các số âm: " + tong);
	}
	
	public static void timX(int array[], Scanner scan) {
		System.out.print("Nhập x cần tìm: ");
		int x = scan.nextInt();
		boolean flag = false;

		for (int i = 0; i < array.length; i++) {
			if (array[i] == x) {
				System.out.println("h. x = " + x + " có trong mảng");
				flag = true;
				break;
			}
			
		}
		if (!flag) {
			System.out.println("h. x = " + x + " không có trong mảng");
		}
	}
	
	

}
