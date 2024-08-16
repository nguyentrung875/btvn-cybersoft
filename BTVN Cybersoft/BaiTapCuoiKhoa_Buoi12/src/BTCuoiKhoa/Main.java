package BTCuoiKhoa;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Validation valid = new Validation();
		Company company = new Company();
		company.sampleDate();
		
		xuLy(scan, company, valid);
	}

	public static void inMenu() {
		System.out.println("==========QUẢN LÝ NHÂN SỰ==========");
		System.out.println("1. Nhập thông tin công ty");
		System.out.println("2. Xuất thông tin công ty");
		System.out.println("3. Phân bổ nhân viên");
		System.out.println("4. Thêm nhân sự");
		System.out.println("5. Xóa nhân sự");
		System.out.println("6. Xuất danh sách nhân sự");
		System.out.println("7. Tính và xuất tổng lương");
		System.out.println("8. Tìm nhân viên có lương cao nhất");
		System.out.println("9. Tìm trưởng phòng có số lượng nhân viên dưới quyền nhiều nhất");
		System.out.println("10. Sắp xếp nhân viên toàn công ty theo thứ tự abc");
		System.out.println("11. Sắp xếp nhân viên theo thứ tự lương giảm dần");
		System.out.println("12. Tìm giám đốc có số lượng cổ phần nhiều nhất");
		System.out.println("13. Tính và xuất tổng thu nhập của từng giám đốc");
		System.out.println("0. Thoát chương trình");
		System.out.print("Vui lòng chọn: ");
	}
	
	public static void xuLy(Scanner scan, Company company, Validation valid) {
		Integer chon = 0;
		do {
			inMenu();
			chon = valid.tryParseInt(scan.nextLine());
//			chon = Integer.parseInt(scan.nextLine());
			switch (chon) {
			case 1:
				company.enter(scan);
				break;
			case 2:
				company.display();
				break;
			case 3:
				company.allocateEmployee(scan);
				break;
			case 4:
				company.addPersonnel(scan);
				break;
			case 5:
				company.removePersonnel(scan);
				break;
			case 6:
				company.displayPersonnel();
				break;
			case 7:
				double total = company.calculateSalary();
				company.displayPersonnel();
				System.out.println("------------------------\nTổng lương công ty: " + total);
				break;
			case 8:
				company.findEmloyeeMaxSalary();
				break;
			case 9:
				company.findManagerWithMostEmployee();
				break;
			case 10:
				company.sortPersonnelByName();
				company.displayPersonnel();
				break;
			case 11:
				company.sortPersonnelBySalaryDESC();
				company.displayPersonnel();
				break;
			case 12:
				company.findDirectorWithMostShares();
				break;
			case 13:
				company.calculateIncomeDirector();
				break;
			case 0:
				System.out.println("Đã thoát chương trình!");
				break;
			default:
				System.out.println("Vui lòng chọn đúng menu! ");
				break;
			}
		} while (chon != 0);
	}

}
