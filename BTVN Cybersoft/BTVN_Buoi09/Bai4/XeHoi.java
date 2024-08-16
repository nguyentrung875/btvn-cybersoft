
public class XeHoi extends PhuongTienGiaoThong {
	private int soChoNgoi;
	
	public XeHoi(String hangSanXuat, String mauSac, int namSanXuat, int soChoNgoi) {
		super(hangSanXuat, mauSac, namSanXuat);
		this.soChoNgoi = soChoNgoi;
	}
	
	@Override
	public void xuatThongTin() {
		super.xuatThongTin();
		System.out.println("Số chỗ: " + this.soChoNgoi);
	}

}
