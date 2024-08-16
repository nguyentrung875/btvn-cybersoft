package BTCuoiKhoa;

public class Validation {

	public int tryParseInt(String text) {
		try {
			return Integer.parseInt(text);
		} catch (NumberFormatException e) {
			System.out.println("Vui lòng chỉ nhập số nguyên!");
			return -1;
		}
	}
	
	public double tryParseDouble(String text) {
		try {
			return Double.parseDouble(text);
		} catch (NumberFormatException e) {
			System.out.println("Vui lòng chỉ nhập số thực!");
			return -1;
		}
	}

	public boolean checkBlankString(String str) {
		if (str.isBlank()) {
			System.out.println("Vui lòng không để trống trường thông tin!");
			return true;
		}
		return false;
	}

	public boolean checkOnlyNumber(String str) {
		String regex = "[0-9]+";
		str = str.trim();
		if (!str.matches(regex)) {
			System.out.println("Vui lòng chỉ nhập chữ số tại đây!");
			return false;
		}
		return true;
	}
	
	public boolean checkPhoneNumber(String phone) {
		String regex = "[0-9]{10}";
		phone = phone.trim();
		if (!phone.matches(regex)) {
			System.out.println("SDT phải có 10 chữ số, vui lòng nhập lại!");
			return false;
		}
		return true;
	}
	
	public boolean checkVietnameseName(String name) {
		String regex = "[A-Za-zÁÀẢÃẠáàảãạÂẤẦẨẪẬâấầẩẫậĂẮẰẲẴẶăắằẳẵặĐđÉÈẺẼẸéèẻẽẹÊẾỀỂỄỆêếềểễệÓÒỎÕỌóòỏõọÔỐỒỔỖỘôốồổỗộƠỚỜỞỠỢơớờởỡợÍÌỈĨỊíìỉĩịÚÙỦŨỤúùủũụƯỨỪỬỮỰưứừửữựÝỲỶỸỴýỳỷỹỵ\\s]+";		
		
		if (!name.matches(regex)) {
			System.out.println("Họ tên chỉ bao gồm ký tự chữ, vui lòng nhập lại!");
			return false;
		}
		return true;
	}
}
