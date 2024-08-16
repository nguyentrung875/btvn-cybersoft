package BTCuoiKhoa;

import java.util.Scanner;

public class Director extends Personnel {
//	private static double availableShares = 100; //Cổ phần còn lại mà công ty có thể share
	private double companyShares = 0; //Cổ phần của mỗi giám đốc
	
	//Getter - setter
	public double getCompanyShares() {
		return companyShares;
	}

	public boolean setCompanyShares(double companyShares) {
		if (companyShares < 0) {
			System.out.println("Số cổ phần chỉ được nằm trong khoảng 0 - " + Company.availableShares + "%");
			return false;
		} else if (companyShares > Company.availableShares) {
			System.out.println("Công ty chỉ còn " + Company.availableShares + "% cổ phần");
			return false;
		} else {
			this.companyShares = companyShares;
			return true;
		}
	}

	//Constructor
	public Director() {
		this.daySalary = 300;
	}

	public Director(int id, String fullName, String phone, int workDay, double shares) {
		super(id, fullName, phone, workDay);
		this.setCompanyShares(shares);
		this.daySalary = 300;
	}
	
	//Input - output
	@Override
	public void enter(Scanner scan, Validation valid) {
		super.enter(scan, valid);
		do {
			System.out.print("Số cổ phần: ");
			double shares = Double.parseDouble(scan.nextLine());
			if (this.setCompanyShares(shares)) break;
		} while (true);
	}
	
	@Override
	public void display() {
		super.display();
		System.out.printf("%s %-15s", "Cổ phần:", this.companyShares);
		System.out.println("\tChức vụ: Giám đốc");
	}
	
	@Override
	public void calculateSalary() {
		this.monthlySalary = this.daySalary * this.workDay;
	}

}
