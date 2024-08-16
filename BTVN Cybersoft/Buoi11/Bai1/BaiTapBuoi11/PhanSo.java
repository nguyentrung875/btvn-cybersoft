package BaiTapBuoi11;

import java.util.Scanner;

public class PhanSo {
	//Attributes
	private double tuSo;
	private double mauSo;
	
	//Getter setter
	public double getTuSo() {
		return tuSo;
	}
	public void setTuSo(double tuSo) {
		this.tuSo = tuSo;
	}
	public double getMauSo() {
		return mauSo;
	}
	public void setMauSo(double mauSo) {
		if (mauSo == 0) {
			System.out.println("Mẫu số phải khác 0!");
		} else {
			this.mauSo = mauSo;
		}
	}
	
	//Constructor
	
	
	//Input, output
	public void nhap() {
		Scanner scan = new Scanner(System.in);
		System.out.print("Vui lòng nhập tử số: ");
		this.tuSo = scan.nextDouble();
		do {
			System.out.print("Vui lòng nhập mẫu số khác 0: ");
			this.mauSo = scan.nextDouble();
		} while (this.mauSo == 0);

	}
	
	public void xuat() {
//		System.out.println("Tử số: " + this.tuSo + " - Mẫu số: " + this.mauSo);
		System.out.println(this.tuSo + "/" + this.mauSo);
	}
	
	//Methods
	//Cách 1:
//	public void cong(PhanSo p1, PhanSo p2) {
//		double tong = (p1.tuSo * p2.mauSo) + (p1.tuSo * p1.mauSo);
//		double mauSoChung = p1.mauSo * p2.mauSo;
//		System.out.println("Tổng phân số là: " + tong + "/" + mauSoChung);
//	}
	
	public PhanSo cong(PhanSo p2) {
		double tong = (this.tuSo * p2.mauSo) + (p2.tuSo * this.mauSo); 
		double mauSoChung = this.mauSo * p2.mauSo;
		
		PhanSo phanSo = new PhanSo();
		phanSo.setTuSo(tong);
		phanSo.setMauSo(mauSoChung);
		
		return phanSo;
	}
	
	public PhanSo tru(PhanSo p2) {
		double hieu = (this.tuSo * p2.mauSo) - (p2.tuSo * this.mauSo); 
		double mauSoChung = this.mauSo * p2.mauSo;
		
		PhanSo phanSo = new PhanSo();
		phanSo.setTuSo(hieu);
		phanSo.setMauSo(mauSoChung);
		
		return phanSo;
	}
	
	public PhanSo nhan(PhanSo p2) {
		PhanSo phanSo = new PhanSo();
		phanSo.tuSo = this.tuSo * p2.tuSo;
		phanSo.mauSo = this.mauSo * p2.mauSo;
		return phanSo;
	}
	
	public PhanSo chia(PhanSo p2) {
		PhanSo phanSo = new PhanSo();
		phanSo.tuSo = this.tuSo * p2.mauSo;
		phanSo.mauSo = this.mauSo * p2.tuSo;
		return phanSo;
	}
}
