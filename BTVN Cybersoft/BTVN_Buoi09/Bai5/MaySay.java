
public class MaySay extends ThietBiDien {
	private String cheDoSay;

	public MaySay(String loaiMay, String congSuat, String chucNang, String cheDoSay) {
		super(loaiMay, congSuat, chucNang);
		this.cheDoSay = cheDoSay;
	}
	
	@Override
	public void xuatThongTin() {
		super.xuatThongTin();
		System.out.println("Chức năng đặc biệt: " + this.cheDoSay);
	}
	
	public void batCheDoSay() {
		System.out.println("Đã bật chế độ " + this.cheDoSay);
	}

}
