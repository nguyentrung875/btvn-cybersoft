
public class ThietBiDien {
	protected String loaiMay;
	protected String congSuat;
	protected String chucNang;
	
	public ThietBiDien(String loaiMay, String congSuat, String chucNang) {
		this.loaiMay = loaiMay;
		this.congSuat = congSuat;
		this.chucNang = chucNang;
	}
	
	public void xuatThongTin() {
		System.out.println("-----Thông tin-----");
		System.out.println("Loại máy: " + this.loaiMay);
		System.out.println("Công suất: " + this.congSuat);
		System.out.println("Chức năng chính: " + this.chucNang);
	}
	
	public void batChucNang() {
		System.out.println("Đã bật chức năng " + this.chucNang);
	}
	
	public void tatChucNang() {
		System.out.println("Đã tắt toàn bộ chức năng");
	}

	
}

