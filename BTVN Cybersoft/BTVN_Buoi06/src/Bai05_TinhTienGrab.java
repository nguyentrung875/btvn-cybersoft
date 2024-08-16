import java.util.Scanner;

public class Bai05_TinhTienGrab {

	final static int GRAB_CAR_1KM = 8000;
	final static int GRAB_SUV_1KM = 9000;
	final static int GRAB_BLACK_1KM = 10000;

	final static int GRAB_CAR_19KM = 7500;
	final static int GRAB_SUV_19KM = 8500;
	final static int GRAB_BLACK_19KM = 9500;

	final static int GRAB_CAR_TREN_19KM = 7000;
	final static int GRAB_SUV_TREN_19KM = 8000;
	final static int GRAB_BLACK_TREN_19KM = 9000;

	final static int TIEN_CHO_GRAB_CAR = 2000;
	final static int TIEN_CHO_GRAB_SUV = 3000;
	final static int TIEN_CHO_GRAB_BLACK = 3500;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		xuLy(scan);
	}

	public static void menuLoaiXe() {
		System.out.println("==========LOẠI XE==========");
		System.out.println("1. Grab Car");
		System.out.println("2. Grab SUV");
		System.out.println("3. Grab Black");
		System.out.println("0. Thoát");
		System.out.print("Vui lòng chọn loại xe: ");
	}

	public static void xuLy(Scanner scan) {
		System.out.print("Vui lòng nhập số km đi được: ");
		double soKm = scan.nextDouble();
		System.out.print("Vui lòng nhập thời gian chờ: ");
		double tgCho = scan.nextDouble();
		int loaiXe;
		do {
			menuLoaiXe();
			loaiXe = scan.nextInt();

			if (loaiXe == 0) {
				System.out.println("Đã thoát chương trình:");
			} else if (loaiXe == 1 || loaiXe == 2 || loaiXe == 3) {
				System.out.println("-----Bạn cần thanh toán-----");
				double tienXe = tinhTienGrab(loaiXe, soKm);
				double tienCho = tinhTienCho(loaiXe, tgCho);
				double tongTien = tienXe + tienCho;
				System.out.println("Tiền xe: " + tienXe);
				System.out.println("Tiền chờ: " + tienCho);
				System.out.println("Tổng tiền: " + tongTien);
			} else {
				System.out.println("Vui lòng chọn đúng menu!");
			}
		} while (loaiXe != 0);
	}

	public static double tinhTien1Km(int loaiXe, double soKm) {
		double total = 0;
		switch (loaiXe) {
		case 1:
			total = GRAB_CAR_1KM;
			break;
		case 2:
			total = GRAB_SUV_1KM;
			break;
		case 3:
			total = GRAB_BLACK_1KM;
			break;
		}
		return total;
	}

	public static double tinhTienTren1KmDen19Km(int loaiXe, double soKm) {
		double total = 0;
		if (soKm <= 19) {
			switch (loaiXe) {
			case 1:
				total = GRAB_CAR_19KM * (soKm - 1);
				break;
			case 2:
				total = GRAB_SUV_19KM * (soKm - 1);
				break;
			case 3:
				total = GRAB_BLACK_19KM * (soKm - 1);
				break;
			}
		} else {
			switch (loaiXe) {
			case 1:
				total = GRAB_CAR_19KM * 18;
				break;
			case 2:
				total = GRAB_SUV_19KM * 18;
				break;
			case 3:
				total = GRAB_BLACK_19KM * 18;
				break;
			}
		}
		return total;
	}

	public static double tinhTienTren19Km(int loaiXe, double soKm) {
		double total = 0;
		switch (loaiXe) {
		case 1:
			total = GRAB_CAR_TREN_19KM * (soKm - 19);
			break;
		case 2:
			total = GRAB_SUV_TREN_19KM * (soKm - 19);
			break;
		case 3:
			total = GRAB_BLACK_TREN_19KM * (soKm - 19);
			break;
		}
		return total;
	}

	public static double tinhTienGrab(int loaiXe, double soKm) {
		double total = 0;
		if (soKm <= 1) {
			total = tinhTien1Km(loaiXe, soKm);
		} else if (soKm <= 19) {
			total = tinhTien1Km(loaiXe, soKm) + tinhTienTren1KmDen19Km(loaiXe, soKm);
		} else {
			total = tinhTien1Km(loaiXe, soKm) + tinhTienTren1KmDen19Km(loaiXe, soKm) + tinhTienTren19Km(loaiXe, soKm);
		}
		return total;
	}

	public static double tinhTienCho(int loaiXe, double tgCho) {
		double tienCho = 0;
		if (tgCho > 3) { // Chờ trên 3 phút mới bắt đầu tính tiền
			switch (loaiXe) {
			case 1:
				tienCho = Math.ceil((tgCho - 3) / 3) * TIEN_CHO_GRAB_CAR;
				break;
			case 2:
				tienCho = Math.ceil((tgCho - 3) / 3) * TIEN_CHO_GRAB_SUV;
				break;
			case 3:
				tienCho = Math.ceil((tgCho - 3) / 3) * TIEN_CHO_GRAB_BLACK;
				break;
			}
		}
		return tienCho;
	}
	
}
