package BaiTapBuoi11;

public class Main {

	public static void main(String[] args) {
		System.out.println("---Phân số 1---");
		PhanSo phanSo1 = new PhanSo();
		phanSo1.nhap();
		
		System.out.println("---Phân số 2---");
		PhanSo phanSo2 = new PhanSo();
		phanSo2.nhap();
		
		System.out.println("Tổng 2 phân số: ");
		PhanSo tong = phanSo1.cong(phanSo2);
		tong.xuat();
		
		System.out.println("Hiệu 2 phân số: ");
		PhanSo hieu = phanSo1.tru(phanSo2);
		hieu.xuat();
		
		System.out.println("Tích 2 phân số: ");
		PhanSo tich = phanSo1.nhan(phanSo2);
		tich.xuat();
		
		System.out.println("Thương 2 phân số: ");
		PhanSo thuong = phanSo1.chia(phanSo2);
		thuong.xuat();
	}

}
