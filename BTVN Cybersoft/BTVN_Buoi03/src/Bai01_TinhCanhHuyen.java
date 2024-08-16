import java.util.Scanner;

public class Bai01_TinhCanhHuyen {
	public static void main(String[] args) {
		float a;
		float b;
		float c;
		Scanner scan = new Scanner(System.in);
		System.out.print("Nhập vào cạnh a = ");
		a = scan.nextFloat();
		System.out.print("Nhập vào cạnh b = ");
		b = scan.nextFloat();
		c = (float) Math.sqrt(a*a + b*b);
		System.out.print("Cạnh huyển c = " + c);
	}
}