import java.util.Scanner;

public class Bai5 {

	public Bai5() {
		// Tính số năm ít nhất để anh X có thể mua ô tô
	}

	public static void main(String[] args) {
		float tienGui;
		float tienCanCo;
		float tienMuaOto;
		float laiSuat;
		int soNam = 0;
		Scanner scan = new Scanner(System.in);
		System.out.print("Nhập vào số tiền gửi (triệu): ");
		tienGui = Float.parseFloat(scan.nextLine());
		System.out.print("Nhập vào số tiền cần mua ô tô (triệu): ");
		tienMuaOto = Float.parseFloat(scan.nextLine());
		System.out.print("Nhập vào % lãi suất: ");
		laiSuat = Float.parseFloat(scan.nextLine());
		tienCanCo = tienGui;
		while (tienCanCo < tienMuaOto) {
			soNam++;
			tienCanCo += tienCanCo*laiSuat/100;
		};
		System.out.println("Sau ít nhất " + soNam + " năm anh X sẽ có " + tienCanCo + " triệu để mua ô tô");
	}

}
