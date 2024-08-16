import java.util.Scanner;

public class Bai02 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int a = 26;
		int b = -24;
		int c = 101;
		
		int soLe = 0; //số lượng số lẻ
		int soChan = 0; //số lượng số chẵn
		
		if (a % 2 == 0) {
			soChan++;
		} else {
			soLe++;
		}
		
		if (b % 2 == 0) {
			soChan++;
		} else {
			soLe++;
		}
		
		if (c % 2 == 0) {
			soChan++;
		} else {
			soLe++;
		}
		
		System.out.println(soLe + " số lẻ");
		System.out.println(soChan + " số chẵn");
	}

}
