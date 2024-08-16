import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		DanhSachSinhVien dssv = new DanhSachSinhVien();
		dssv.sampleData();
		xuLyMenu(dssv);
	}

	public static void inMenu() {
		System.out.println("==========MENU==========");
		System.out.println("1. Nhập sinh viên");
		System.out.println("2. Xuất danh sách sinh viên");
		System.out.println("3. Tính điểm trung bình và Xếp loại từng sinh viên");
		System.out.println("4. In ra SV có ĐTB cao nhất. ");
		System.out.println("5. In ra tất cả sinh viên Yếu");
		System.out.println("6. Tìm sinh viên theo tên");
		System.out.println("7. Tìm sinh viên theo mã ");
		System.out.println("8. Xóa 1 sinh viên theo mã");
		System.out.println("0. Thoát");
	}

	public static void xuLyMenu(DanhSachSinhVien dssv) {
		Scanner scan = new Scanner(System.in);
		SinhVien sv = new SinhVien();
		int chon;

		do {
			inMenu();
			System.out.print("Vui lòng chọn: ");
			chon = Integer.parseInt(scan.nextLine());
			switch (chon) {
			case 0:
				System.out.println("Đã thoát chương trình!");
				break;
			case 1:
				sv.nhap();
				dssv.themSinhVien(sv);
				break;
			case 2:
				dssv.xuat();
				break;
			case 3:
				dssv.tinhDTBVaXepLoai(); 
				dssv.xuat();
				break;
			case 4:
				dssv.inSinhVienDTBCaoNhat();
				break;
			case 5:
				dssv.inSinhVienYeu();
				break;
			case 6:
				dssv.timSinhVienTheoTen(scan);
				break;
			case 7:
				dssv.timSinhVienTheoMa(scan);
				break;
			case 8:
				dssv.xoaSinhVienTheoMa(scan);
				break;
			default:
				System.out.println("Vui lòng chọn đúng menu!");
				break;
			}
		} while (chon != 0);
	}

}
