
public class XeMay extends PhuongTienGiaoThong {
	private String dungTich;
		
	public XeMay(String hangSanXuat, String mauSac, int namSanXuat, String dungTich) {
		super(hangSanXuat, mauSac, namSanXuat);
		this.dungTich = dungTich;
	}
	
	@Override
	public void xuatThongTin() {
		super.xuatThongTin();
		System.out.println("Dung tích: " + this.dungTich);
	}

}
