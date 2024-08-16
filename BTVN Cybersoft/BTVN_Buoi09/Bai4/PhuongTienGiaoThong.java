
public class PhuongTienGiaoThong {
	protected String hangSanXuat;
	protected String mauSac;
	protected int namSanXuat;
	
	public PhuongTienGiaoThong(String hangSanXuat, String mauSac, int namSanXuat) {
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
