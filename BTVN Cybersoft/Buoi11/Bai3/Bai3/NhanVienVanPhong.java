package Bai3;

import java.util.Date;
import java.util.Scanner;

public class NhanVienVanPhong extends NhanVien {
	private double soNgayLamViec;
	
	public NhanVienVanPhong() {
		// TODO Auto-generated constructor stub
	}

	public NhanVienVanPhong(String hoTen, Date ngaySinh, double luong, double soNgayLamViec) {
		super(hoTen, ngaySinh, luong);
		this.soNgayLamViec = soNgayLamViec;
	}
	
	@Override
	public void nhap(Scanner scan) {
		super.nhap(scan);
		System.out.print("Số ngày làm việc: ");
		this.soNgayLamViec = Integer.parseInt(scan.nextLine());
	}
	
	@Override
	public void xuat() {
		super.xuat();
		System.out.print("\t\tSố ngày làm việc: " + this.soNgayLamViec);
		System.out.println();
	}
	
	@Override
	public void tinhLuong() {
		this.luong = this.soNgayLamViec * 100000;
	}
}
