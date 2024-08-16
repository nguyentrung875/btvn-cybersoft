package Bai4;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		xuLy();
	}
	
	public static void inMenu() {
		System.out.println("===QUẢN LÝ PHƯƠNG TIỆN GIAO THÔNG===");
		System.out.println("1. Thêm phương tiện");
		System.out.println("2. Thêm ô tô");
		System.out.println("3. Xuất danh sách phương tiện");
		System.out.println("4. Xuất danh sách ô tô");
		System.out.println("5. Xuất danh sách ô tô cùng vận tốc");
		System.out.println("0. Thoát");
	}
	
	public static void xuLy() {
		Scanner scan = new Scanner(System.in);
		DanhSachPhuongTien danhSach = new DanhSachPhuongTien();
		PhuongTienGiaoThong phuongTien;
		danhSach.sampleData(); //Thêm dữ liệu mẫu
		int chon;
		do {
			inMenu();
			System.out.print("VUI LÒNG CHỌN: ");
			chon = Integer.parseInt(scan.nextLine());
			switch (chon) {
			case 1:
				phuongTien = new PhuongTienGiaoThong();
				phuongTien.nhap(scan);
				danhSach.them(phuongTien);
				break;
			case 2:
				phuongTien = new Oto();
				phuongTien.nhap(scan);
				danhSach.them(phuongTien);
				break;
			case 3:
				danhSach.xuat();
				break;
			case 4:
				danhSach.xuatOto();
				break;
			case 5:
				danhSach.xuatOtoCungVanToc();
				break;
			case 0:
				System.out.println("Đã thoát chương trình!");
				break;
			default:
				System.out.println("Vui lòng chọn đúng menu!");
				break;
			}
		} while (chon != 0);
	}


}
