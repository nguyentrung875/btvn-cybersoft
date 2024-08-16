package Bai4;

import java.util.Scanner;

public class Oto extends PhuongTienGiaoThong {
	private byte soChoNgoi;
	private String kieuDongCo;
	
	//Getter - setter
	public byte getSoChoNgoi() {
		return soChoNgoi;
	}
	public void setSoChoNgoi(byte soChoNgoi) {
		if (soChoNgoi <= 0) {
			System.out.println("Số chỗ ngồi phải lớn hơn 0!");
		} else {
			this.soChoNgoi = soChoNgoi;
		}
	}
	
	//Constructor
	public String getKieuDongCo() {
		return kieuDongCo;
	}
	public void setKieuDongCo(String kieuDongCo) {
		this.kieuDongCo = kieuDongCo;
	}
	public Oto() {}
	public Oto(String hangSanXuat, String tenPhuongTien, int namSanXuat, double vanTocToiDa, byte soChoNgoi, String kieuDongCo) {
		super(hangSanXuat, tenPhuongTien, namSanXuat, vanTocToiDa);
		this.soChoNgoi = soChoNgoi;
		this.kieuDongCo = kieuDongCo;
	}
	
	
	//Input - output
	@Override
	public void nhap(Scanner scan) {
		super.nhap(scan);
		do {
			System.out.print("Số chỗ ngồi: ");
			this.soChoNgoi = Byte.parseByte(scan.nextLine());
		} while (this.soChoNgoi <= 0);
		System.out.print("Kiểu động cơ: ");
		this.kieuDongCo = scan.nextLine();
	}
	
	@Override
	public void xuat() {
		super.xuat();
		System.out.println("Số chỗ ngồi: " + this.soChoNgoi);
		System.out.println("Kiểu động cơ: " + this.kieuDongCo);
	}
	
	
}
