import java.util.Scanner;

public class Bai04 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Vui lòng nhập: ");
		System.out.print("Tên sinh viên 1: ");
		String sv1 = scan.nextLine();
		System.out.print("Tọa độ x: ");
		double x1 = Double.parseDouble(scan.nextLine());
		System.out.print("Tọa độ y: ");
		double y1 = Double.parseDouble(scan.nextLine());
		
		System.out.print("Tên sinh viên 2: ");
		String sv2 = scan.nextLine();
		System.out.print("Tọa độ x: ");
		double x2 = Double.parseDouble(scan.nextLine());
		System.out.print("Tọa độ y: ");
		double y2 = Double.parseDouble(scan.nextLine());
		
		System.out.print("Tên sinh viên 3: ");
		String sv3 = scan.nextLine();
		System.out.print("Tọa độ x: ");
		double x3 = Double.parseDouble(scan.nextLine());
		System.out.print("Tọa độ y: ");
		double y3 = Double.parseDouble(scan.nextLine());
		
		System.out.println("Tọa độ trường học: ");
		System.out.print("Tọa độ x: ");
		double xTH = Double.parseDouble(scan.nextLine());
		System.out.print("Tọa độ y: ");
		double yTH = Double.parseDouble(scan.nextLine());
		
		//Tính khoảng cách từ các sinh viên đến trường
		double kc1 = Math.sqrt(Math.pow(x1 - xTH, 2) + Math.pow(y1 - yTH, 2));
		double kc2 = Math.sqrt(Math.pow(x2 - xTH, 2) + Math.pow(y2 - yTH, 2));
		double kc3 = Math.sqrt(Math.pow(x3 - xTH, 2) + Math.pow(y3 - yTH, 2));
		System.out.println(kc1);
		System.out.println(kc2);
		System.out.println(kc3);
		
		//Tìm khoảng các xa nhất
		double kcMax = 0;
		kcMax = kc1 > kcMax ? kc1 : kcMax;
		kcMax = kc2 > kcMax ? kc2 : kcMax;
		kcMax = kc3 > kcMax ? kc3 : kcMax;
		
		//Tìm các sinh viên ở xa trường nhất
		System.out.println("Sinh viên ở xa trường nhất: ");
		if (kc1 == kcMax) {
			System.out.println(sv1 + "(khoảng cách: " + kc1 + ")");
		}
		if (kc2 == kcMax) {
			System.out.println(sv2 + "(khoảng cách: " + kc2 + ")");
		}
		if (kc3 == kcMax) {
			System.out.println(sv3 + "(khoảng cách: " + kc3 + ")");
		}
		
	}

}
