package Bai4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class DanhSachPhuongTien {
	ArrayList<PhuongTienGiaoThong> danhSach;

	public DanhSachPhuongTien() {
		this.danhSach = new ArrayList<PhuongTienGiaoThong>();
	}

	public void sampleData() {
		PhuongTienGiaoThong phuongTien = new PhuongTienGiaoThong("Honda", "Airblade", 2008, 150);
		this.danhSach.add(phuongTien);
		phuongTien = new PhuongTienGiaoThong("Ducati", "Monster", 2008, 200);
		this.danhSach.add(phuongTien);
		phuongTien = new Oto("Vinfast", "VF5", 2018, 200, (byte) 5, "Điện");
		this.danhSach.add(phuongTien);
		phuongTien = new Oto("Vinfast", "VF9", 2018, 180, (byte) 7, "Điện");
		this.danhSach.add(phuongTien);
		phuongTien = new Oto("Ford", "Everest", 2010, 200, (byte) 7, "Xăng");
		this.danhSach.add(phuongTien);
		phuongTien = new Oto("Vinfast", "LUX 2.0", 2018, 200, (byte) 5, "Xăng");
		this.danhSach.add(phuongTien);
		phuongTien = new Oto("Toyota", "Inova", 2005, 190, (byte) 7, "Xăng");
		this.danhSach.add(phuongTien);
		phuongTien = new Oto("Toyota", "Camry", 2006, 180, (byte) 7, "Xăng");
		this.danhSach.add(phuongTien);

	}

	public void them(PhuongTienGiaoThong pt) {
		this.danhSach.add(pt);
		System.out.println("Đã thêm phương tiện mới!");
	}

	public void xuat() {
		if (this.danhSach.size() <= 0) {
			System.out.println("Không có phương tiện nào trong danh sách");
			return;
		}

		System.out.println("===Danh sách phương tiện giao thông===");
		for (PhuongTienGiaoThong phuongTien : danhSach) {
			phuongTien.xuat();
		}
	}

	public void xuatOto() {
		System.out.println("=======Danh sách ô tô=======");
		if (this.danhSach.size() <= 0) {
			System.out.println("Không có phương tiện nào trong danh sách");
			return;
		}

		for (int i = 0; i < this.danhSach.size(); i++) {
			if (this.danhSach.get(i) instanceof Oto) {
				this.danhSach.get(i).xuat();
			}
		}
	}

	public void xuatOtoCungVanToc() {
		ArrayList<Oto> danhSachOto = new ArrayList<Oto>();
		for (PhuongTienGiaoThong phuongTien : danhSach) {
			if (phuongTien instanceof Oto) {
				danhSachOto.add((Oto) phuongTien);
			}
		}

		boolean flag = false;
		System.out.println("=======Các ô tô có cùng vận tốc=======");
		for (Oto oto : danhSachOto) {
			if (Collections.frequency(danhSachOto, oto) > 1) {
				oto.xuat();
				flag = true;
			}
		}

		if (!flag) {
			System.out.println("Không có ô tô nào cùng vận tốc");
		}
	}

}
