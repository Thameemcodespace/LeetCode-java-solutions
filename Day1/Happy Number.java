        class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();
		
		while (!set.contains(n)) {
			set.add(n);
			int answerTillNow = 0;
			int num = n; 
			while (num > 0) {
				int digit = num % 10;
				answerTillNow = answerTillNow + (digit * digit);
				num = num/10;
			}
			n = answerTillNow;
		}
		if (n == 1) {
			return true;
		}

		return false;
    }
}
