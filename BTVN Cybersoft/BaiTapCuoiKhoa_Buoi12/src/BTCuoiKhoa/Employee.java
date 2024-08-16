package BTCuoiKhoa;

import java.util.Scanner;

public class Employee extends Personnel {
	private Manager manager = null;
	
	//Getter - setter
	public Manager getManager() {
		return manager;
	}
	public void setManager(Manager manager) {
		this.manager = manager;
	}
	
	//Constructor
	public Employee() {
		this.daySalary = 100;
	}

	public Employee(int id, String fullName, String phone, int workDay) {
		super(id, fullName, phone, workDay);
		this.daySalary = 100;
	}
	
	//Input - output
	@Override
	public void enter(Scanner scan, Validation valid) {
		super.enter(scan, valid);
	}

	@Override
	public void display() {
		super.display();
		if (manager != null) {
			System.out.printf("%s %-15s", "Người QL:", this.manager.fullName +" (ID:"+ this.manager.id +")");
		} else {
			System.out.printf("%s %-15s", "Người QL:", "Chưa có");
		}
		System.out.println("\tChức vụ: Nhân viên");
	}
	
	//Methods
	@Override
	public void calculateSalary() {
		this.monthlySalary = this.daySalary * this.workDay;
	}
	

}
