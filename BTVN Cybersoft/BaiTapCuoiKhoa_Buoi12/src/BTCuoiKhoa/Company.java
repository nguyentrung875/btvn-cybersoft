package BTCuoiKhoa;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Company {
	public static double availableShares = 100; //Cổ phần còn lại mà công ty có thể share
	private String name = "Cybersoft";
	private String taxCode = "123456";
	private double monthlyRevenue = 90000;
	private ArrayList<Personnel> personnelList;

	// Getter - setter
	
	public double getMonthlyRevenue() {
		return monthlyRevenue;
	}
	public void setMonthlyRevenue(double monthlyRevenue) {
		if (monthlyRevenue < 0) {
			System.out.println("Doanh thu tháng phải lớn hơn 0!");
		} else {
			this.monthlyRevenue = monthlyRevenue;
		}
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTaxCode() {
		return taxCode;
	}

	public void setTaxCode(String taxCode) {
		this.taxCode = taxCode;
	}

	public ArrayList<Personnel> getPersonnelList() {
		return personnelList;
	}

	// Constructor
	public Company() {
		this.personnelList = new ArrayList<Personnel>();
	}

	public Company(String name, String taxCode, double monthlyRevenue) {
		this.personnelList = new ArrayList<Personnel>();
		this.name = name;
		this.taxCode = taxCode;
		this.monthlyRevenue = monthlyRevenue;
	}

	// Input - output
	public void sampleDate() {
		Personnel person;
		person = new Employee(1, "Trung", "0931789181", 24);
		this.personnelList.add(person);
		person = new Employee(2, "Thanh", "0827777212", 30);
		this.personnelList.add(person);
		person = new Employee(3, "Bình", "0827147212", 30);
		this.personnelList.add(person);
		person = new Employee(4, "Cường", "0827777182", 20);
		this.personnelList.add(person);
		person = new Employee(5, "Lan", "0984777182", 24);
		this.personnelList.add(person);
		person = new Employee(6, "Thành", "0984684135", 10);
		this.personnelList.add(person);
		person = new Employee(7, "Chương", "0984684135", 30);
		this.personnelList.add(person);
		person = new Employee(8, "Luân", "0984684135", 25);
		this.personnelList.add(person);
		person = new Employee(9, "Hùng", "0984684135", 24);
		this.personnelList.add(person);
		person = new Employee(10, "Thuận", "0984684135", 28);
		this.personnelList.add(person);

		person = new Manager(11, "Hồng", "0984684135", 15);
		this.personnelList.add(person);
		person = new Manager(12, "Dũng", "0984684135", 30);
		this.personnelList.add(person);
		person = new Manager(13, "Ngọc", "0984684135", 25);
		this.personnelList.add(person);
		
		person = new Director(20, "GĐ Huệ", "0984587618", 30, 15);
		this.personnelList.add(person);
		Company.availableShares -= ((Director)person).getCompanyShares();
		person = new Director(21, "GĐ Trung", "0984587618", 30, 5);
		this.personnelList.add(person);
		Company.availableShares -= ((Director)person).getCompanyShares();
	}
	
	//1. Nhập thông tin công ty
	public void enter(Scanner scan) {
		Validation valid = new Validation();
		System.out.println("=======NHẬP THÔNG TIN CÔNG TY=======");
		this.enterCompanyName(scan, valid);
		this.enterTaxNumber(scan, valid);
		this.enterMonthlyRevenue(scan, valid);
	}
	
	public void enterCompanyName(Scanner scan, Validation valid) {
		while (true) {
			System.out.print("Tên: ");
			this.name = scan.nextLine();
			if (!valid.checkBlankString(this.name)) break;
		}
	}
	
	public void enterTaxNumber(Scanner scan, Validation valid) {
		while (true) {
			System.out.print("Mã số thuế: ");
			this.taxCode = scan.nextLine();
			if (valid.checkOnlyNumber(this.taxCode)) break;
		}
	}
	
	public void enterMonthlyRevenue(Scanner scan, Validation valid) {
		while (true) {
			System.out.print("Doanh thu tháng: ");
			double revenue = valid.tryParseDouble(scan.nextLine());
			if (revenue >= 0) {
				this.setMonthlyRevenue(revenue);
				break;
			} else {
				System.out.println("Doanh thu tháng phải >= 0");
			}
		}
	}
	
	//2. Xuất thông tin công ty
	public void display() {
		System.out.println("=====THÔNG TIN CÔNG TY=====");
		System.out.println("Tên công ty: " + this.name);
		System.out.println("Mã số thuế: " + this.taxCode);
		System.out.println("Doanh thu tháng: " + this.monthlyRevenue);
	}
	// Business methods

	//3. Phân bổ nhân viên vào trưởng phòng
	public void allocateEmployee(Scanner scan) {
		System.out.println("===PHÂN BỔ NHÂN VIÊN===");
		do {
			System.out.println("Nhập phím bất kỳ để tiếp tục phân bổ nhân viên");
			System.out.println("Nhập 0 để thoát");
			String chon = scan.nextLine();
			if (chon.equals("0")) break;

			Employee employee = chooseEmployee(scan);
			this.allocate(scan, employee);
		} while (true);
	}

	public void allocate(Scanner scan, Employee e) {
		Manager newManager = chooseManager(scan);
		Manager oldManager = e.getManager();

		if (oldManager != null) { // TH nhân viên đã có trưởng phòng quản lý cũ
			oldManager.decreaseEmployee();
		}

		// Phân bổ trưởng phòng mới
		e.setManager(newManager);
		newManager.increaseEmployee();
		System.out.println("Đã phân bổ nhân viên!");
	}

	public Employee chooseEmployee(Scanner scan) {
		Validation valid = new Validation();
		Employee e = null;
		this.displayEmployee();
		do {
			System.out.print("Vui lòng nhập ID nhân viên bạn muốn phân bổ: ");
			int id = valid.tryParseInt(scan.nextLine());
			if (id != -1) e = this.findEmployeeById(id);
		} while (e == null);
		return e;
	}

	public Manager chooseManager(Scanner scan) {
		Validation valid = new Validation();
		Manager m = null;
		this.displayManager();
		do {
			System.out.print("Vui lòng nhập ID trưởng phòng quản lý: ");
			int id = valid.tryParseInt(scan.nextLine());
			if (id != -1) m = this.findManagerById(id);
		} while (m == null);
		return m;
	}

	public void displayEmployee() {
		System.out.println("---DANH SÁCH NHÂN VIÊN---");
		for (Personnel person : personnelList) {
			if (person instanceof Employee) {
				person.display();
			}
		}
	}

	public void displayManager() {
		System.out.println("---DANH SÁCH TRƯỞNG PHÒNG---");
		for (Personnel person : personnelList) {
			if (person instanceof Manager) {
				person.display();
			}
		}
	}

	public Employee findEmployeeById(int id) {
		for (Personnel person : personnelList) {
			if (person instanceof Employee && person.getId() == id) {
				return (Employee) person;
			}
		}
		return null;
	}

	public Manager findManagerById(int id) {
		for (Personnel person : personnelList) {
			if (person instanceof Manager && person.getId() == id) {
				return (Manager) person;
			}
		}
		return null;
	}

	//4. Thêm nhận sự mới
	public void addPersonnel(Scanner scan) {
		Validation valid = new Validation();
		Personnel newPerson;
		boolean flag = true;
		do {
			System.out.println("===THÊM NHÂN SỰ MỚI===");
			System.out.println("1. Thêm nhân viên");
			System.out.println("2. Thêm trưởng phòng");
			System.out.println("3. Thêm giám đốc");
			System.out.println("0. Quay lại!");
			System.out.print("Vui lòng chọn: ");
			int chon = valid.tryParseInt(scan.nextLine());
			switch (chon) {
			case 1:
				newPerson = new Employee();
				newPerson.enter(scan, valid);
				if (this.add(newPerson)) {
					System.out.println("Nhập 1 để phân bổ nhân viên." + "\nNhập phím bất kỳ để tiếp tục thêm nhân sự");
					chon = valid.tryParseInt(scan.nextLine());
					if (chon == 1) this.allocate(scan, (Employee) newPerson);
				}
				break;
			case 2:
				newPerson = new Manager();
				newPerson.enter(scan, valid);
				this.add(newPerson);
				break;
			case 3:
				newPerson = new Director();
				newPerson.enter(scan, valid);
				if (this.add(newPerson)) {
					Company.availableShares -= ((Director) newPerson).getCompanyShares();
				}
				break;
			case 0:
				flag = false;
				break;
			default:
				break;
			}
		} while (flag);
	}

	private boolean add(Personnel person) {
		for (Personnel personel : personnelList) {
			if (personel.getId() == person.getId()) {
				System.out.println("Không thêm được nhân sự. ID đã tồn tại trong danh sách!");
				return false;
			}
		}

		this.personnelList.add(person);
		System.out.println("Đã thêm nhân sự mới!");
		return true;
	}

	//5. Xóa nhân sự
	public void removePersonnel(Scanner scan) {
		Validation valid = new Validation();
		System.out.println("===XÓA NHÂN SỰ===");
		System.out.print("Nhập ID nhân sự cần xóa: ");
		int delID = valid.tryParseInt(scan.nextLine());
		Personnel delPerson = this.findPersonById(delID);

		// Return nếu không có id không tồn tại trong danh sách
		if (delPerson == null) {
			System.out.println("Không tìm thấy ID cần xóa trong danh sách!");
			return;
		}

		// Xóa nhân sự
		if (delPerson instanceof Employee) {
			this.removeEmployee((Employee) delPerson);
		} else if (delPerson instanceof Manager) {
			this.removeManager((Manager) delPerson);
		} else if (delPerson instanceof Director) {
			this.removeDirector((Director) delPerson);
		}
		System.out.println("Xóa nhân sự thành công!");
	}

	private Personnel findPersonById(int id) {
		for (Personnel person : personnelList) {
			if (person.getId() == id) {
				return person;
			}
		}
		return null;
	}

	private void removeEmployee(Employee e) {
		// Tìm trưởng phòng quản lý nhân viên giảm 1 nhân viên dưới quyền
		Manager manager = e.getManager();
		if (manager != null) {
			manager.decreaseEmployee();
		}

		// Xóa nhân viên khỏi dah sách
		this.personnelList.remove(e);
	}

	private void removeManager(Manager m) {
		// Ngắt kết nối các nhân viên liên quan đến trưởng phòng
		for (Personnel person : personnelList) {
			if (person instanceof Employee) {
				Employee e = (Employee) person;
				if (e.getManager() != null && e.getManager().equals(m)) {
					((Employee) person).setManager(null);
				}
			}
		}

		// Xóa trưởng phòng khỏi danh sách
		this.personnelList.remove(m);
	}

	private void removeDirector(Director d) {
		//Tính lại số cổ phần còn lại của công ty
		Company.availableShares += d.getCompanyShares();
		//Xóa giám đốc khỏi danh sách
		this.personnelList.remove(d);
	}

	//6. Xuất danh sách nhân sự trong công ty
	public void displayPersonnel() {
		System.out.println("---DANH SÁCH NHÂN SỰ TOÀN CÔNG TY---");
		for (Personnel person : personnelList) {
			person.display();
		}
	}

	//7. Tính tổng lương công ty
	public double calculateSalary() {
		double totalSalary = 0;
		for (Personnel person : personnelList) {
			person.calculateSalary();
			totalSalary += person.getMonthlySalary();
		}
		return totalSalary;
	}

	//8. Tìm nhân viên thường có lương cao nhất
	public void findEmloyeeMaxSalary() {
		// Tính lương cho toàn bộ công ty
		this.calculateSalary();

		// Tìm giá trị lương cao nhất của nhân viên thường
		double max = -1;
		for (Personnel person : personnelList) {
			if (person instanceof Employee && person.getMonthlySalary() > max) {
				max = person.getMonthlySalary();
			}
		}

		// Hiển thị tất cả các nhân viên có lương cao nhất
		System.out.println("---Danh sách nhân viên thường lương cao nhất---");
		for (Personnel person : personnelList) {
			if (person instanceof Employee && person.getMonthlySalary() == max) {
				person.display();
			}
		}
	}

	//9. Tìm trưởng phòng có số lượng nhân viên dưới quyền nhiều nhất
	public void findManagerWithMostEmployee() {
		// Tìm số lượng nhân viên dưới quyền nhiều nhất
		int max = 0;
		for (Personnel person : personnelList) {
			if (person instanceof Manager) {
				Manager mana = (Manager) person;
				if (mana.getEmployeeNumber() > max) {
					max = mana.getEmployeeNumber();
				}
			}
		}

		// Kiểm tra đã phân bổ nhân viên hay chưa
		if (max == 0) {
			System.out.println("Bạn chưa phân bổ nhân viên vào trưởng phòng");
			return;
		}

		// Hiển thị tất cả trưởng vào thỏa điều kiện
		System.out.println("---Danh sách trưởng phòng có số lượng nhân viên dưới quyền nhiều nhất---");
		for (Personnel person : personnelList) {
			if (person instanceof Manager) {
				Manager mana = (Manager) person;
				if (mana.getEmployeeNumber() == max) {
					mana.display();
				}
			}
		}
	}

	//10. Sắp xếp nhân viên toàn công ty theo thứ tự abc
	public void sortPersonnelByName() {
		Collections.sort(this.personnelList, new Comparator<Personnel>() {
			@Override
			public int compare(Personnel o1, Personnel o2) {
				return o1.getFullName().compareToIgnoreCase(o2.getFullName());
			}
		});
	}

	//11. Sắp xếp nhân viên theo thứ tự lương giảm dần
	public void sortPersonnelBySalaryDESC() {
		this.calculateSalary();
		Collections.sort(this.personnelList, (o1, o2) -> Double.compare(o2.getMonthlySalary(), o1.getMonthlySalary()));
	}

	//12. Tìm giám đốc có số lượng cổ phần nhiều nhất
	public void findDirectorWithMostShares() {
		// Tìm giá trị cổ phần lớn nhất
		double max = -1;
		for (Personnel person : personnelList) {
			if (person instanceof Director) {
				Director boss = (Director) person;
				if (boss.getCompanyShares() > max) {
					max = boss.getCompanyShares();
				}
			}
		}

		// Hiển thị các giám đốc có cổ phần nhiều nhất
		System.out.println("---Danh sách giám đốc có số lượng cổ phần nhiều nhất---");
		for (Personnel person : personnelList) {
			if (person instanceof Director) {
				Director boss = (Director) person;
				if (boss.getCompanyShares() == max) {
					boss.display();
				}
			}
		}
	}

	//13. Tính và xuất tổng thu nhập của từng giám đốc
	public void calculateIncomeDirector() {
		double companyProfit = this.monthlyRevenue - this.calculateSalary();
		double directorProfit;

		System.out.println("---Tổng thu nhập của các giám đốc---");
		for (Personnel person : personnelList) {
			if (person instanceof Director) {
				Director director = (Director) person;
				directorProfit = director.getMonthlySalary() + director.getCompanyShares() * companyProfit / 100;
				System.out.println("Giám đốc: " + director.getFullName() + " - Tổng thu nhập: " + directorProfit);
			}
		}
	}
}
