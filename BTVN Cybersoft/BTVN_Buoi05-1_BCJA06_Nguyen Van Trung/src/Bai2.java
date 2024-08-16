import java.util.Scanner;

public class Bai2 {
	//Tìm số nguyên dương n nhỏ nhất sao cho: 1 + 2 + ... + n > 1000
	public static void main(String[] args) {
		final int MAX = 10000;
		int n = 0;
		int tong = 0;		
		while (tong <= MAX) {
			n++;
			tong += n;
		}
		System.out.println("Số nguyên dương nhỏ nhất thỏa: 1+2+...+n > " + MAX + " là: " + n);
		System.out.println("Tổng = " + tong);
	}

}
