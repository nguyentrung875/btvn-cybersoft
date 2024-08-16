
public class Bai3 {
	//Có bao nhiêu số chia hết cho 3 từ 0 - 1000
	public static void main(String[] args) {
		int dem = 0;
		int number = 0;
		
		while (number <= 1000) {
			dem++;
			System.out.print(number + " ");
			number += 3;
		}
		System.out.println("\nDùng while: Có " + dem + " số chia hết cho 3 từ 0 - 1000");
		
		dem = 0;
		for (int i = 0; i <= 1000; i++) {
			if (i % 3 == 0) {
				dem++;
				System.out.print(i + " ");
			}
		}
		System.out.println("\nDùng for: Có " + dem + " số chia hết cho 3 từ 0 - 1000");

		
		
	}

}
