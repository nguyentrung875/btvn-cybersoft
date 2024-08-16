package bai3;

public class TroChoi {
	private String ten;
	private int soLuot;
	
	public TroChoi(String ten, int soLuot) {
		this.ten = ten;
		this.soLuot = soLuot;
	}

	public void batDau() {
		System.out.println("Trò chơi bắt đầu");
	}
	
	public void ketThuc() {
		System.out.println("Trò chơi kết thúc");
	}
}
