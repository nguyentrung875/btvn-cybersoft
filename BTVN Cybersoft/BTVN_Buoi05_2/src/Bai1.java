
public class Bai1 {
	//In tất cả các số nguyên dương lẻ/chẵn nhỏ hơn 100
	public static void main(String[] args) {
		//Dùng bước nhảy
		System.out.println("Số nguyên dương chẵn: ");
		for (int i = 0; i < 100; i+=2) {
			System.out.print(i + " ");
		}
		
		//Dùng %2
		System.out.println("\nSố nguyên dương lẻ: ");
		int number = 1;
		while (number < 100) {
			if (number % 2 != 0) {
				System.out.print(number + " ");
			}
			number++;
		}
		
	}

}
