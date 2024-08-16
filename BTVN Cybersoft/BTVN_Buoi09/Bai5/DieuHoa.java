
public class DieuHoa extends ThietBiDien {
	private String cheDoDacBiet;
	
	public DieuHoa(String loaiMay, String congSuat, String chucNang, String cheDo) {
		super(loaiMay, congSuat, chucNang);
		this.cheDoDacBiet = cheDo;
	}
	
	
	@Override
	public void xuatThongTin() {
		super.xuatThongTin();
		System.out.println("Chức năng đặc biệt: " + this.cheDoDacBiet);
	}



	public void batCheDoDacBiet() {
		System.out.println("Đã bật chế độ " + this.cheDoDacBiet);
	}

}
