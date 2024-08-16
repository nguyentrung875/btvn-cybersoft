import java.awt.print.Printable;
import java.util.Scanner;

public class Bai03 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Vui lòng nhập");
		System.out.print("Tên cán bộ 1: ");
		String cb1 = scan.nextLine();
		System.out.print("Giới tính (Nam: true - Nữ: false): ");
		boolean gt1 = Boolean.parseBoolean(scan.nextLine());
		System.out.print("Năm sinh: ");
		int namSinh1 = Integer.parseInt(scan.nextLine());

		System.out.print("Tên cán bộ 2: ");
		String cb2 = scan.nextLine();
		System.out.print("Giới tính (Nam: true - Nữ: false): ");
		boolean gt2 = Boolean.parseBoolean(scan.nextLine());
		System.out.print("Năm Sinh: ");
		int namSinh2 = Integer.parseInt(scan.nextLine());

		System.out.print("Tên cán bộ 3: ");
		String cb3 = scan.nextLine();
		System.out.print("Giới tính (Nam: true - Nữ: false): ");
		boolean gt3 = Boolean.parseBoolean(scan.nextLine());
		System.out.print("Năm sinh: ");
		int namSinh3 = Integer.parseInt(scan.nextLine());
		
		
		if (namSinh1 > 0 && namSinh2 > 0 && namSinh3 > 0) {
			int max = 0;
			boolean flag = false; //tất cả cán bộ đều giới tinh nữ

			if (gt1 == true) {
				max = namSinh1 > max ? namSinh1 : max;
				flag = true;
			}
			if (gt2 == true) {
				max = namSinh2 > max ? namSinh2 : max;
				flag = true;
			}
			if (gt3 == true) {
				max = namSinh3 > max ? namSinh3 : max;
				flag = true;
			}
			
			
			if (flag) {
				System.out.println("Cán bộ nam trẻ nhất:");
				if (namSinh1 == max) {
					System.out.println(cb1 + " sinh năm " + namSinh1);
				}
				if (namSinh2 == max) {
					System.out.println(cb2 + " sinh năm " + namSinh2);
				}
				if (namSinh3 == max) {
					System.out.println(cb3 + " sinh năm " + namSinh3);
				}	
			} else {
				System.out.println("3 cán bộ đều là nữ");
			}
		} else {
			System.out.println("Năm sinh không được mang giá trị âm");
		}
	}

}
