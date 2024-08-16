package Bai3;

import java.util.ArrayList;

public class DanhSachNhanVien {
	private ArrayList<NhanVien> danhSachNhanVien;
	
	
	public DanhSachNhanVien() {
		this.danhSachNhanVien = new ArrayList<NhanVien>();
	}

	public void them(NhanVien nv) {
		this.danhSachNhanVien.add(nv);
	}
	
	public void xuat() {
		if (danhSachNhanVien.size() == 0) {
			System.out.println("Không có nhân viên nào trong danh sách!");
			return;
		}
		
		System.out.println("---DANH SÁCH NHÂN VIÊN---");
		for (NhanVien nhanVien : danhSachNhanVien) {
			if (nhanVien instanceof NhanVienSanXuat) {
				System.out.print("NVSX - ");
				nhanVien.xuat();
			} else {
				System.out.print("NVVP - ");
				nhanVien.xuat();
			}
		}
	}
	
	public void tinhLuong() {
		if (danhSachNhanVien.size() == 0) {
			System.out.println("Không có nhân viên nào trong danh sách!");
			return;
		}
		
		for (NhanVien nhanVien : danhSachNhanVien) {
			nhanVien.tinhLuong();
		}
		System.out.println("Đã tính lương cho toàn bộ nhân viên!");
	}
}
