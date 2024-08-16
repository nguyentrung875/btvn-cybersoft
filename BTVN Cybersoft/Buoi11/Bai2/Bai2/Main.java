package Bai2;

public class Main {

	public static void main(String[] args) {
		VanDongVien vdv1 = new VanDongVien();
		vdv1.nhap();
		vdv1.xuat();
		
		VanDongVien vdv2 = new VanDongVien();
		vdv2.nhap();
		vdv2.xuat();
		
		vdv1.soSanh(vdv2);
	}

}
