package Bai2;

public class XeHoi {
	private String hangSanXuat;
	private String mauSac;
	private int namSanXuat;
	
	public XeHoi(String hangSanXuat, String mauSac, int namSanXuat) {
		this.hangSanXuat = hangSanXuat;
		this.mauSac = mauSac;
		this.namSanXuat = namSanXuat;
	}

	public void xuatThongTin() {
		System.out.println("-----Thông tin xe-----");
		System.out.println("Hãng sản xuất: " + this.hangSanXuat);
		System.out.println("Màu: " + this.mauSac);
		System.out.println("Năm sản xuất: " + this.namSanXuat);
	}
}
