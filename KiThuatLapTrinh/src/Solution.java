import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import javax.swing.plaf.basic.BasicSplitPaneDivider;

public class Solution {
	public int minimumRounds(int[] tasks) {
		HashMap<Integer, Integer> map = new HashMap<>();
		int ans = 0;
		for (int i : tasks) {
			map.put(i, map.getOrDefault(i, 0) + 1);
		}

		for (int cnt : map.keySet()) {
			if (cnt % 3 == 0)
				ans += cnt / 3;
			else if (cnt % 3 == 1) {
				if (cnt < 3) {
					ans = -1;
					break;
				} else
					ans += (cnt - 4) / 3 + 2;
			} else
				ans += (cnt + 1) / 3;
		}
		return ans;
	}

	private double divide(double a,double b){
		System.out.println(a/b);
		return a/b;
	}
	public static void main(String[] args) {
		Solution s= new Solution();
		System.out.println(s.divide(3, 0));
	}
}
