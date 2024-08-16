
public class MainBai5 {

	public static void main(String[] args) {
		DieuHoa dieuHoa = new DieuHoa("Điều hòa", "2000W", "làm lạnh", "khử ẩm");
		MaySay maySay = new MaySay("Máy sấy", "1000W", "làm nóng", "sấy siêu tốc");
		
		dieuHoa.xuatThongTin();
		dieuHoa.batChucNang();
		dieuHoa.batCheDoDacBiet();
		dieuHoa.tatChucNang();
		
		maySay.xuatThongTin();
		maySay.batChucNang();
		maySay.batCheDoSay();
		maySay.tatChucNang();
	}

}
