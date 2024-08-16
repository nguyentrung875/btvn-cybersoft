import java.util.Scanner;

public class Bai4 {

	public Bai4() {

	}

	public static void main(String[] args) {
		int x;
		int n;
		long tong = 0;
		Scanner scan = new Scanner(System.in);
		System.out.println("Nhập vào cơ số x: ");
		x = Integer.parseInt(scan.nextLine());
		System.out.println("Nhập vào n: ");
		n = Integer.parseInt(scan.nextLine());
		for (int i = 1; i <= n; i++) {
			tong += tinhLuyThua(x, i);
			System.out.print(" + (" + x + ")^" + i);
		}
		System.out.println(" = " + tong);
	}
	
    public static long tinhLuyThua(int coSo, int soMu) {
        long ketQua = 1;
        for (int i = 0; i < soMu; i++) {
            ketQua *= coSo;
        }
        return ketQua;
    }

}
