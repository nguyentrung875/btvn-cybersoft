package Bai3;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class NhanVien {
	//Attributes
	protected String hoTen;
	protected Date ngaySinh;
	protected double luong = -1;
	
	
	//Getter setter
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	public Date getNgaySinh() {
		return ngaySinh;
	}
	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}
	public double getLuong() {
		return luong;
	}
	
	//Constructor
	public NhanVien() {}
	public NhanVien(String hoTen, Date ngaySinh, double luong) {
		this.hoTen = hoTen;
		this.ngaySinh = ngaySinh;
		this.luong = luong;
	}
	
	//Input output
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	public void nhap(Scanner scan) {
		System.out.println("---Nhập thông tin nhân viên---");
		System.out.print("Họ tên: ");
		this.hoTen = scan.nextLine();
		do {
			try {
				System.out.print("Ngày sinh (dd/MM/yyyy): ");
				dateFormat.setLenient(false);
				this.ngaySinh = dateFormat.parse(scan.nextLine());
				break;
			} catch (Exception e) {
				System.out.println("Vui lòng nhập đúng định dạng!");
			}
		} while (true);

	}
	
	public void xuat() {
		System.out.print("Họ tên: " + this.hoTen);
		System.out.print("\t\tNgày sinh: " + dateFormat.format(this.ngaySinh));
		System.out.print("\t\tLương: " + this.luong);
	}
	
	public void tinhLuong() {
	}
}
