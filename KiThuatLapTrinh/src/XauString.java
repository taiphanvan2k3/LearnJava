import java.util.Arrays;

public class XauString {
	public static void main(String[] args) {
		String s1 = "Phan Văn Tài";
		String s2="Xin chào, mình là Tài.Mình sinh năm 2003";
		String[] words = s1.split(" ");
		String [] words2=s2.split("\\.|\\, ");
		//System.out.println(words[words.length - 1]);
		for(String str:words2)
			System.out.println(str);
	}
}
