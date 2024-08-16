package Bai4;

import java.util.Objects;
import java.util.Scanner;

public class PhuongTienGiaoThong {
	protected String hangSanXuat;
	protected String tenPhuongTien;
	protected int namSanXuat;
	protected double vanTocToiDa;
	
	//Getter - setter
	public String getHangSanXuat() {
		return hangSanXuat;
	}
	public void setHangSanXuat(String hangSanXuat) {
		this.hangSanXuat = hangSanXuat;
	}
	public String getTenPhuongTien() {
		return tenPhuongTien;
	}
	public void setTenPhuongTien(String tenPhuongTien) {
		this.tenPhuongTien = tenPhuongTien;
	}
	public int getNamSanXuat() {
		return namSanXuat;
	}
	public void setNamSanXuat(int namSanXuat) {
		if (namSanXuat < 0) {
			System.out.println("Năm sản xuất không được là số âm!");
		} else {
			this.namSanXuat = namSanXuat;
		}
	}
	public double getVanTocToiDa() {
		return vanTocToiDa;
	}
	public void setVanTocToiDa(double vanTocToiDa) {
		if (vanTocToiDa < 0) {
			System.out.println("Vận tốc không được là số âm!");
		} else {
			this.vanTocToiDa = vanTocToiDa;
		}
	}
	
	//Constructor
	public PhuongTienGiaoThong() {}
	public PhuongTienGiaoThong(String hangSanXuat, String tenPhuongTien, int namSanXuat, double vanTocToiDa) {
		super();
		this.hangSanXuat = hangSanXuat;
		this.tenPhuongTien = tenPhuongTien;
		this.namSanXuat = namSanXuat;
		this.vanTocToiDa = vanTocToiDa;
	}
	
	//Input - output
	public void nhap(Scanner scan) {
		System.out.println("---Vui lòng nhập thông tin---");
		System.out.print("Hãng sản xuất: ");
		this.hangSanXuat = scan.nextLine();
		System.out.print("Tên phương tiện: ");
		this.tenPhuongTien = scan.nextLine();
		do {
			System.out.print("Năm sản xuất: ");
			this.namSanXuat = Integer.parseInt(scan.nextLine());
		} while (this.namSanXuat < 0);
		do {
			System.out.print("Vận tốc tối đa: ");
			this.vanTocToiDa = Double.parseDouble(scan.nextLine());
		} while (this.namSanXuat < 0);
	}
	
	public void xuat() {
		System.out.println("-----------------------------");
		System.out.println("Hãng sản xuất: " + this.hangSanXuat);
		System.out.println("Tên phương tiện: " + this.tenPhuongTien);
		System.out.println("Năm sản xuất: " + this.namSanXuat);
		System.out.println("Vận tốc tối đa: " + this.vanTocToiDa);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(vanTocToiDa);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PhuongTienGiaoThong other = (PhuongTienGiaoThong) obj;
		return Double.doubleToLongBits(vanTocToiDa) == Double.doubleToLongBits(other.vanTocToiDa);
	}
	
	
	
}
