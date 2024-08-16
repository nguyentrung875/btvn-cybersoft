import java.util.Scanner;

public class Bai1 {
	//Xây dựng trò kéo búa bao

	public static void main(String[] args) {
		boolean flag = true;
		String ketQua;
		int diemNguoi = 0;
		int diemMay = 0;
		Scanner scan = new Scanner(System.in);

		do {
			inMenu();		
			int chon = Integer.parseInt(scan.nextLine());
			if (chon == 1 || chon == 2 || chon == 3) {
				ketQua = xetThangThua(chon);
				System.out.println("Người Chơi " + ketQua + " Máy");
				
				//tính tỷ số
				if (ketQua == "Thắng") {
					diemNguoi++;
				} else if (ketQua == "Thua") {
					diemMay++;
				} else {
					diemNguoi += 0;
					diemMay += 0;
				}
			} else if (chon == 0) {
				flag = false;
			} else {
				System.out.println("Vui lòng nhập đúng!!!");
			}
			System.out.println("***TỶ SỐ HIỆN TẠI***\nNgười " + diemNguoi + " - " + diemMay +" Máy");
			System.out.println("------------------------------");
		} while (flag);
	}

	public static void inMenu() {
		System.out.println("1. Kéo");
		System.out.println("2. Búa");
		System.out.println("3. Bao");
		System.out.println("0. Thoát");
	}

	public static String luaChon(int chon) {
		switch (chon) {
		case 1:
			return "Kéo";
		case 2:
			return "Búa";
		default:
			return "Bao";
		}
	}
	
	public static String xetThangThua(int chon) {
		String ketQua = null;
		int may = (int) (Math.random() * 3 + 1); //máy random 1,2,3
		System.out.println(may);
		String nguoiChon = luaChon(chon);
		System.out.print("Người chơi ra " + nguoiChon);
		String mayChon = luaChon(may);
		System.out.println(" | Máy ra " + mayChon);

		switch (nguoiChon) {
		case "Kéo":
			if (mayChon == "Kéo") {
				ketQua = "Hòa";
			} else if (mayChon == "Búa") {
				ketQua = "Thua";
			} else {
				ketQua = "Thắng";
			}
			break;
		case "Búa":
			if (mayChon == "Kéo") {
				ketQua = "Thắng";
			} else if (mayChon == "Búa") {
				ketQua = "Hòa";
			} else {
				ketQua = "Thua";
			}
			break;
		case "Bao":
			if (mayChon == "Kéo") {
				ketQua = "Thua";
			} else if (mayChon == "Búa") {
				ketQua = "Thắng";
			} else {
				ketQua = "Hòa";
			}
			break;
		}
		return ketQua;
	}
	
	
}
