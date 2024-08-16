package Bai2;

import java.util.Scanner;

public class VanDongVien {
	private String hoTen;
	private int tuoi;
	private String monThiDau;
	private double canNang;
	private double chieuCao;
	
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	public int getTuoi() {
		return tuoi;
	}
	public void setTuoi(int tuoi) {
		this.tuoi = tuoi;
	}
	public String getMonThiDau() {
		return monThiDau;
	}
	public void setMonThiDau(String monThiDau) {
		this.monThiDau = monThiDau;
	}
	public double getCanNang() {
		return canNang;
	}
	public void setCanNang(double canNang) {
		this.canNang = canNang;
	}
	public double getChieuCao() {
		return chieuCao;
	}
	public void setChieuCao(double chieuCao) {
		this.chieuCao = chieuCao;
	}
	
	//Constructor
	public VanDongVien() {}
	public VanDongVien(String hoTen, int tuoi, String monThiDau, double canNang, double chieuCao) {
		this.hoTen = hoTen;
		this.tuoi = tuoi;
		this.monThiDau = monThiDau;
		this.canNang = canNang;
		this.chieuCao = chieuCao;
	}
	public void nhap() {
		Scanner scan = new Scanner(System.in);
		System.out.println("---Vui lòng nhập thông tin vận dộng viên---");
		System.out.print("Tên: ");
		this.hoTen = scan.nextLine();
		System.out.print("Tuổi: ");
		this.tuoi = Integer.parseInt(scan.nextLine());
		System.out.print("Môn thi đấu: ");
		this.monThiDau = scan.nextLine();
		System.out.print("Cân nặng: ");
		this.canNang = Double.parseDouble(scan.nextLine());
		System.out.print("Chiều cao: ");
		this.chieuCao = Double.parseDouble(scan.nextLine());
	}
	public void xuat() {
		System.out.println("-----Xuất thông tin vận động viên-----");
		System.out.println("Họ tên: " + this.hoTen);
		System.out.println("Tuổi: " + this.tuoi);
		System.out.println("Môn thi đấu: " + this.monThiDau);
		System.out.println("Cân nặng: " + this.canNang);
		System.out.println("Chiều cao: " + this.chieuCao);
	}
	public void soSanh(VanDongVien vdv2) {
		if (this.chieuCao > vdv2.chieuCao) {
			System.out.println(this.getHoTen() + " cao hơn " + vdv2.getHoTen());
		} else if (this.chieuCao < vdv2.chieuCao) {
			System.out.println(this.getHoTen() + " thấp hơn " + vdv2.getHoTen());
		} else 	if (this.canNang > vdv2.canNang) {
			System.out.println("Chiều cao bằng nhau. " + this.getHoTen()+ " nặng hơn " + vdv2.getHoTen());
		} else if (this.canNang < vdv2.canNang) {
			System.out.println("Chiều cao bằng nhau. " + this.getHoTen()+ " nhẹ hơn " + vdv2.getHoTen());
		} else if (this.canNang == vdv2.canNang) {
			System.out.println("Chiều cao và cân nặng 2 vận động viên bằng nhau");
		}
	}
	
	
	
	
}
