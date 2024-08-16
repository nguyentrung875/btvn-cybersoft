import java.util.Scanner;

public class Bai01 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Vui lòng nhập");
		System.out.print("Tên sinh viên 1: ");
		String sv1 = scan.nextLine();
		System.out.print("Năm sinh: ");
		int namSinh1 = Integer.parseInt(scan.nextLine());

		System.out.print("Tên sinh viên 2: ");
		String sv2 = scan.nextLine();
		System.out.print("Năm Sinh: ");
		int namSinh2 = Integer.parseInt(scan.nextLine());

		System.out.print("Tên sinh viên 3: ");
		String sv3 = scan.nextLine();
		System.out.print("Năm sinh: ");
		int namSinh3 = Integer.parseInt(scan.nextLine());
		
		if (namSinh1 > 0 && namSinh2 > 0 && namSinh3 > 0) {
			int max = 0;

			//Tìm năm sinh max thật sự
			max = namSinh1 > max ? namSinh1 : max;
			max = namSinh2 > max ? namSinh2 : max;
			max = namSinh3 > max ? namSinh3 : max;

			//Xuất ra các sinh viên trẻ nhất
			System.out.println("Sinh viên trẻ nhất:");
			if (namSinh1 == max) {
				System.out.println(sv1 + " sinh năm " + namSinh1);
			}
			if (namSinh2 == max) {
				System.out.println(sv2 + " sinh năm " + namSinh2);
			}
			if (namSinh3 == max) {
				System.out.println(sv3 + " sinh năm " + namSinh3);
			}
			
		} else {
			System.out.println("Năm sinh không được mang giá trị âm");
		}



	}

}
