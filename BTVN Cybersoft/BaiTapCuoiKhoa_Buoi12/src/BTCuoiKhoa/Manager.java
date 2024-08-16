package BTCuoiKhoa;

public class Manager extends Personnel {
	private int employeeNumber = 0;
	
	//Getter - setter
	public int getEmployeeNumber() {
		return employeeNumber;
	}

	public void setEmployeeNumber(int employeeNumber) {
		this.employeeNumber = employeeNumber;
	}

	//Constructor
	public Manager() {
		this.daySalary = 200;
	}

	public Manager(int id, String fullName, String phone, int workDay) {
		super(id, fullName, phone, workDay);
		this.daySalary = 200;
	}
	
	//Input - output
	@Override
	public void display() {
		super.display();
		System.out.printf("%s %-3s", "NV dưới quyền:", this.employeeNumber);
		System.out.println("\t\tChức vụ: Trưởng phòng");
	}
	//Methods
	@Override
	public void calculateSalary() {
		this.monthlySalary = this.daySalary * this.workDay + this.employeeNumber * 100;
	}
	
	public void increaseEmployee() {
		this.employeeNumber++;
	}
	
	public void decreaseEmployee() {
		this.employeeNumber--;
	}
	

}
