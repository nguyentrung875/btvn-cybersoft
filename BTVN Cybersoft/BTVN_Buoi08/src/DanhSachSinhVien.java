import java.util.ArrayList;
import java.util.Scanner;

public class DanhSachSinhVien {
	//1.Attributes
	private ArrayList<SinhVien> listSinhVien;
	
	
	//2.Getter, setter

	public ArrayList<SinhVien> getListSinhVien() {
		return listSinhVien;
	}
	
	
	//3.Constructor
	public DanhSachSinhVien() {
		this.listSinhVien = new ArrayList<SinhVien>();
	}


	//4. Input, output
	public void sampleData() {
		SinhVien sv;;
		sv = new SinhVien("Nguyễn Văn Trung","001", 9, 8, 7);
		this.listSinhVien.add(sv);
		sv = new SinhVien("Lê Minh Trí","002", 10, 9, 10);
		this.listSinhVien.add(sv);
		sv = new SinhVien("Tạ Huy Cường","003", 3, 4, 5);
		this.listSinhVien.add(sv);
		sv = new SinhVien("Vũ Văn Hải","004", 8, 5, 7);
		this.listSinhVien.add(sv);
		sv = new SinhVien("Trần Huy Hùng","005", 1, 3, 5);
		this.listSinhVien.add(sv);
		sv = new SinhVien("Phan Mạnh Hải","006", 9, 10, 10);
		this.listSinhVien.add(sv);
	}
	//Thêm sinh viên vào danh sách
	public boolean ktraMaTonTai(SinhVien sv) {
		for (SinhVien sinhVien : listSinhVien) {
			if (sinhVien.getMa().equals(sv.getMa())) return true;
		}
		return false;
	}
	public void themSinhVien(SinhVien sv) {
		if (ktraMaTonTai(sv)) {
			System.out.println("Mã sinh viên đã tồn tại, không thêm được sinh viên");
		} else {
			this.listSinhVien.add(sv);
			System.out.println("Đã thêm sinh viên!");
		}
	}
	
	public void xuat() {
		System.out.println("----------DANH SÁCH SINH VIÊN----------");
		for (SinhVien sinhVien : listSinhVien) {
			sinhVien.xuat();
		}
	}

	//5. Methods
	public void tinhDTBVaXepLoai() {
		for (SinhVien sinhVien : listSinhVien) {
			sinhVien.tinhDiemTrungBinh();
			sinhVien.xepLoai();
		}
	}
	
	public void xepLoai() {
		for (SinhVien sinhVien : listSinhVien) {
			sinhVien.xepLoai();
		}
	}
	
	//In ra SV có ĐTB cao nhất. 
	public double tinhDTBCaoNhat() {
		double max = 0;
		for (SinhVien sinhVien : listSinhVien) {
			if (sinhVien.getDtb() > max) {
				max = sinhVien.getDtb();
			}
		}
		return max;
	}
	
	public void inSinhVienDTBCaoNhat() {
		double max = tinhDTBCaoNhat();
		System.out.println("-----Sinh viên có điểm trung bình cao nhất-----");
		for (SinhVien sinhVien : listSinhVien) {
			if (sinhVien.getDtb() == max) {
				sinhVien.xuat();
			}
		}
	}
	
	//In ra tất cả sinh viên Yếu. 
	public void inSinhVienYeu() {
		System.out.println("-----Danh sách sinh viên yếu-----");
		for (SinhVien sinhVien : listSinhVien) {
			if (sinhVien.getHocLuc().equalsIgnoreCase("Yếu")) {
				sinhVien.xuat();
			}
		}
	}
	
	//Tìm sinh viên theo tên. 
	public void timSinhVienTheoTen(Scanner scan) {
		System.out.println("--------------------------");
		System.out.print("Nhập tên sinh viên cần tìm: ");
		String tenCanTim = scan.nextLine();;
		boolean flag = false;
		for (SinhVien sinhVien : listSinhVien) {
			if (sinhVien.getTen().toLowerCase().contains(tenCanTim.toLowerCase())) {
				sinhVien.xuat();
				flag = true;
			}
		}
		if (!flag) {
			System.out.println("Không tìm thấy tên sinh viên!");
		}
	}
	
	//Tìm sinh viên theo mã 
	public void timSinhVienTheoMa(Scanner scan) {
		System.out.println("--------------------------");
		System.out.print("Nhập mã sinh viên cần tìm: ");
		String maCanTim = scan.nextLine();
		for (SinhVien sinhVien : listSinhVien) {
			if (sinhVien.getMa().equals(maCanTim)) {
				sinhVien.xuat();
				return;
			}
		}
		System.out.println("Không tìm thấy mã sinh viên");
	}
	
	//Xóa sinh viên theo mã 
	public void xoaSinhVienTheoMa(Scanner scan) {
		System.out.println("--------------------------");
		System.out.print("Nhập mã sinh viên cần xóa: ");
		String maCanXoa = scan.nextLine();
		for (SinhVien sinhVien : listSinhVien) {
			if (sinhVien.getMa().equals(maCanXoa)) {
				listSinhVien.remove(sinhVien);
				System.out.println("Đã xóa sinh viên!");
				return;
			}
		}
		System.out.println("Không tìm thấy mã sinh viên!");
	}

}
