package BTCuoiKhoa;

import java.util.Objects;
import java.util.Scanner;
import BTCuoiKhoa.Validation;

public abstract class Personnel {
	//Attributes
	protected int id;
	protected String fullName;
	protected String phone;
	protected int workDay;
	protected double daySalary = 0;
	protected double monthlySalary = -1;
	
	//Getter - setter
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getWorkDay() {
		return workDay;
	}
	public boolean setWorkDay(int workDay) {
		if (workDay < 0 || workDay > 30) {
			System.out.println("Số ngày làm việc phải từ 0 - 30 ngày");
			return false;
		} else {
			this.workDay = workDay;
			return true;
		}
	}
	public double getMonthlySalary() {
		return monthlySalary;
	}
	
	//Constructor
	public Personnel() {
		
	}
	public Personnel(int id, String fullName, String phone, int workDay) {
		super();
		this.id = id;
		this.fullName = fullName;
		this.phone = phone;
		this.workDay = workDay;
	}
	
	//Input - output
	public void enter(Scanner scan, Validation valid) {
		System.out.println("=======THÊM NHÂN SỰ=======");
		this.enterID(scan, valid);
		this.enterFullName(scan, valid);
		this.enterPhone(scan, valid);
		this.enterWorkDay(scan, valid);
	}
	
	public void enterID(Scanner scan, Validation valid) {
		while (true) {
			System.out.print("Mã số: ");
			this.id = valid.tryParseInt(scan.nextLine());
			if (this.id != -1 && this.id > 0) {
				break;
			} else {
				System.out.println("ID phải là số nguyên dương");
			}
		}
	}
	
	public void enterFullName(Scanner scan, Validation valid) {
		while (true) {
			System.out.print("Họ tên: ");
			this.fullName = scan.nextLine();
			if (valid.checkBlankString(this.fullName)) continue;
			if (valid.checkVietnameseName(this.fullName)) break;
		}
	}
	
	public void enterPhone(Scanner scan, Validation valid) {
		while (true) {
			System.out.print("Số điện thoại: ");
			this.phone = scan.nextLine();
			if (valid.checkPhoneNumber(this.phone)) break;
		}
	}
	
	public void enterWorkDay(Scanner scan, Validation valid) {
		while (true) {
			System.out.print("Nhập số ngày làm việc: ");
			int day = valid.tryParseInt(scan.nextLine());
			if (this.setWorkDay(day)) break;
		}
	}
	
	public void display() {
		System.out.printf("%s %-5s", "ID:", this.id);
		System.out.printf("%s %-15s", "Tên:", this.fullName);
		System.out.printf("%s %-15s", "SĐT:", this.phone);
		System.out.printf("%s %-10s", "Lương:", this.monthlySalary);
	}
	
	public void calculateSalary() {
	}
}
