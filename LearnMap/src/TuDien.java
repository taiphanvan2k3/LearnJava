import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
public class TuDien {
	private Map<String, String> dict = new TreeMap<String, String>();
	
	
	public Map<String, String> getDict() {
		return dict;
	}

	public void themTuVung(String tuKhoa, String yNghia) {
		this.dict.put(tuKhoa, yNghia);
	}

	public void xoaTu(String tuKhoa) {
		this.dict.remove(tuKhoa);
	}

	public String traTu(String tuKhoa) {
		return this.dict.get(tuKhoa);
	}

	public void inTuKhoa() {
		Set<String> s = this.dict.keySet();
		System.out.println(s.toString());
	}

	public int soLuongTuKhoa() {
		return this.dict.size();
	}

	public void xoaTuVung(String tukhoa) {
		this.dict.remove(tukhoa);
	}

	public void xoaTatCaTuVung() {
		this.dict.clear();
	}
	public void inThongTinTuVung(String tuKhoa,String yNghia) {
		System.out.println(tuKhoa+":"+yNghia);
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		TuDien dictionary = new TuDien();
		while (true) {
			System.out.println("============MENU===========");
			System.out.println("0.Thoát chương trình");
			System.out.println("1.Thêm từ vựng");
			System.out.println("2.Tra từ vựng.");
			System.out.println("3.Xoá từ.");
			System.out.println("4.In danh sách từ vựng");
			System.out.println("5.In số lượng từ.");
			System.out.println("6.Xoá tất cả từ khoá.");
			System.out.print("Mời bạn nhập lựa chọn:");
			int lc = sc.nextInt();
			sc.nextLine();
			if(lc==0)
				break;
			if (lc == 1 || lc == 2 || lc == 3) {
				System.out.print("Nhập từ vựng:");
				String str = sc.nextLine();
				str = str.toLowerCase();
				if (lc == 1) {
					System.out.print("Nhập ý nghĩa từ vựng:");
					String yNghia = sc.nextLine();
					dictionary.themTuVung(str, yNghia);
				} else if (lc == 2)
					dictionary.inThongTinTuVung(str, dictionary.traTu(str));
				 else
					dictionary.xoaTu(str);
			} else if (lc == 4) {
				for(Map.Entry<String,String>word :dictionary.getDict().entrySet()) {
					dictionary.inThongTinTuVung(word.getKey(), word.getValue());
				}
			}
			else if(lc==5)
				System.out.println("Số lượng từ có trong từ điển: "+dictionary.soLuongTuKhoa());
			else dictionary.xoaTatCaTuVung();
		}
	}
}
