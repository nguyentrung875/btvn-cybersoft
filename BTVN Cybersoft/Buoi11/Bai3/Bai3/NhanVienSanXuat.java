package Bai3;

import java.util.Date;
import java.util.Scanner;

public class NhanVienSanXuat extends NhanVien {
	private double luongCanBan;
	private int soSanPham;
	
	public NhanVienSanXuat() {
		// TODO Auto-generated constructor stub
	}

	public NhanVienSanXuat(String hoTen, Date ngaySinh, double luong) {
		super(hoTen, ngaySinh, luong);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void nhap(Scanner scan) {
		super.nhap(scan);
		System.out.print("Lương cơ bản: ");
		this.luongCanBan = Double.parseDouble(scan.nextLine());
		System.out.print("Số sản phẩm: ");
		this.soSanPham = Integer.parseInt(scan.nextLine());
	}
	
	@Override
	public void xuat() {
		super.xuat();
		System.out.print("\t\tLương căn bản: " + this.luongCanBan);
		System.out.print("\t\tSố sản phẩm: " + this.soSanPham); 
		System.out.println();
	}
	
	@Override
	public void tinhLuong() {
		this.luong = this.luongCanBan * this.soSanPham * 5000;
	}

}
