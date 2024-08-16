package Bai3;

import java.text.ParseException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		DanhSachNhanVien danhSach = new DanhSachNhanVien();
		NhanVien nhanVien;
		int chon;
		do {
			inMenu();
			System.out.print("VUI LÒNG CHỌN: ");
			chon = Integer.parseInt(scan.nextLine());
			switch (chon) {
			case 1:
				nhanVien = new NhanVienSanXuat();
				nhanVien.nhap(scan);
				danhSach.them(nhanVien);
				break;
			case 2:
				nhanVien = new NhanVienVanPhong();
				nhanVien.nhap(scan);
				danhSach.them(nhanVien);
				break;
			case 3:
				if (danhSach == null) {
					System.out.println("Chưa có nhân viên trong danh sách!");
				} else {
					danhSach.xuat();
				}
				break;
			case 4:
				danhSach.tinhLuong();
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
	
	public static void inMenu() {
		System.out.println("===QUẢN LÝ NHÂN VIÊN===");
		System.out.println("1. Thêm nhân viên sản xuất");
		System.out.println("2. Thêm nhân viên văn phòng");
		System.out.println("3. Xuất danh sách nhân viên");
		System.out.println("4. Tính lương nhân viên");
		System.out.println("0. Thoát");
	}
}
