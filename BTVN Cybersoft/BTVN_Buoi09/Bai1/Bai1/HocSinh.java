package Bai1;

public class HocSinh {
	private String ten;
	private int tuoi;
	private double diemToan;
	private double diemLy;
	private double diemHoa;
	private double diemTrungBinh;
	
	
	public HocSinh(String ten, int tuoi, double diemToan, double diemLy, double diemHoa) {
		this.ten = ten;
		this.tuoi = tuoi;
		this.diemToan = diemToan;
		this.diemLy = diemLy;
		this.diemHoa = diemHoa;
	}

	public void xuatThongTin() {
		System.out.println("-----Thông tin học sinh-----");
		System.out.println("Tên: " + this.ten);
		System.out.println("Tuổi: " + this.tuoi);
		System.out.println("Điểm Trung Bình: " + this.diemTrungBinh);
	}
	
	public void tinhDiemTrungBinh() {
		this.diemTrungBinh = (this.diemToan + this.diemLy + this.diemHoa)/3;
	}
}
