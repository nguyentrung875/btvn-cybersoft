import java.util.Scanner;

public class Bai05 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("Mời nhập tên mặt hàng: ");
		String ten = scan.nextLine();
		System.out.print("Số lượng: ");
		int soLuong = Integer.parseInt(scan.nextLine());
		System.out.print("Đơn giá: ");
		double donGia = Double.parseDouble(scan.nextLine());
	
		double total;
		double discount;
		
		if (soLuong <= 0 || donGia <= 0) {
			System.out.println("Nhập sai số lượng hoặc đơn giá");
		} else {
			if (soLuong > 100) {
				discount = 12;
			} else if (soLuong >= 50) {
				discount = 8;
			} else {
				discount = 0;
			}
			
			total = donGia * soLuong * (1 - discount/100);
			System.out.println("Số tiền phải trả: " + total);
		}
		

	}

}
