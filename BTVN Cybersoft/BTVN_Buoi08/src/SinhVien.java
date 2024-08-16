import java.util.Scanner;

public class SinhVien {
	//1.Attributes
	private String ten;
	private String ma;
	private double toan;
	private double ly;
	private double hoa;
	private double dtb = -1;
	private String hocLuc = "Chưa xếp loại";
	
	//2.Getter, setter

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public String getMa() {
		return ma;
	}

	public void setMa(String ma) {
		this.ma = ma;
	}

	public double getToan() {
		return toan;
	}

	public void setToan(double toan) {
		this.toan = toan;
	}

	public double getLy() {
		return ly;
	}

	public void setLy(double ly) {
		this.ly = ly;
	}

	public double getHoa() {
		return hoa;
	}

	public void setHoa(double hoa) {
		this.hoa = hoa;
	}

	public double getDtb() {
		return dtb;
	}

	public String getHocLuc() {
		return hocLuc;
	}

	//3.Constructor
	public SinhVien() {

	}

	public SinhVien(String ten, String ma, double toan, double ly, double hoa) {
		super();
		this.ten = ten;
		this.ma = ma;
		this.toan = toan;
		this.ly = ly;
		this.hoa = hoa;
	}

	
	
	//4. Input, output
	public void nhap() {
		Scanner scan = new Scanner(System.in);
		System.out.println("-----Mời bạn nhập-----");
		System.out.print("Tên sinh viên: ");
		this.ten = scan.nextLine();
		System.out.print("Mã sinh viên: ");
		this.ma = scan.nextLine();
		System.out.print("Điểm toán: ");
		this.toan = nhapDiem(scan);
		System.out.print("Điểm lý: ");
		this.ly = nhapDiem(scan);
		System.out.print("Điểm hóa: ");
		this.hoa = nhapDiem(scan);
	}
	
	
	public double nhapDiem(Scanner scan) {
		double diem = -1;
		do {
			diem = scan.nextDouble();
			if (diem < 0 || diem > 10) {
				System.out.print("Thang điểm từ 0 - 10.\nVui lòng nhập lại: ");
			}
		} while (diem < 0 || diem > 10);
		return diem;
	}
	
	public void xuat() {
		System.out.printf("%s%-20s", "Tên: ", this.ten);
		System.out.printf("%s%-10s", "Mã: ", this.ma);
		System.out.printf("%s%-10s", "Toán: ", this.toan);
		System.out.printf("%s%-10s", "Lý: " , this.ly);
		System.out.printf("%s%-10s", "Hóa: ", this.hoa);
		System.out.printf("%s%-10.2f", "ĐTB: ", this.dtb);
		System.out.printf("%s%-10s", "Xếp loại: ", this.hocLuc);
		System.out.println();
	}
	//5. Methods
	public double tinhDiemTrungBinh() {
		this.dtb = (this.toan + this.ly + this.hoa)/3;
		return this.dtb;
	}
	
	public void xepLoai() {
		double diemTrungBinh = tinhDiemTrungBinh();
		if (diemTrungBinh >= 9) {
			this.hocLuc = "Xuất sắc";
		} else if (diemTrungBinh >= 8){
			this.hocLuc = "Giỏi";
		} else if (diemTrungBinh >= 7) {
			this.hocLuc = "Khá";
		} else if (diemTrungBinh >= 6) {
			this.hocLuc = "Trung bình";
		} else {
			this.hocLuc = "Yếu";
		}
	}
	

}
