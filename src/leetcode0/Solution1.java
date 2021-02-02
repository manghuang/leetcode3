package leetcode0;

public class Solution1 {

    public int characterReplacement(String s, int k) {
        if(s == null || s.length() == 0){
            return 0;
        }
        int length = s.length();
        if(k < 0){
            return -1;
        }else if(k >= length){
            return length;
        }

        char[] chars = s.toCharArray();

        //滑动窗口，双向，仅从两端开始是不够的，这是因为默认将第一个字母作为整个区间要变成的字母
//        int ans = 0;
//        for (int i = 0; i < length; i++) {
//            if(i != 0 && chars[i] == chars[i-1]){
//                continue;
//            }
//            int remindNum = k;
//            int j = i+1;
//            for (; j < length; j++) {
//                if(chars[j] != chars[i]){
//                    if(remindNum > 0){
//                        remindNum--;
//                    }else {
//                        break;
//                    }
//                }
//            }
//            ans = Math.max(ans, j-i);
//            if(j == length){
//                break;
//            }
//        }
//        for (int i = length-1; i >= 0; i--) {
//            if(i != length-1 && chars[i] == chars[i+1]){
//                continue;
//            }
//            int remindNum = k;
//            int j = i-1;
//            for (; j >= 0; j--) {
//                if(chars[j] != chars[i]){
//                    if(remindNum > 0){
//                        remindNum--;
//                    }else {
//                        break;
//                    }
//                }
//            }
//            ans = Math.max(ans, i - j);
//            if(j == 0){
//                break;
//            }
//        }
//        return ans;

        // 双指针, 以区间内最多的那一部分为基准,贪心思想
        // 为什么right到了最右端，right-left 即为结果
        int ans = 0;
        int[] num = new int[26];
        int maxNum = 0;
        int left = 0;
        int right = 0;
        for (; right < length ; right++) {
            int chNum = chars[right] - 'A';
            num[chNum] ++;
            maxNum = Math.max(maxNum, num[chNum]);

            if(right - left + 1 - maxNum > k){
                num[chars[left] - 'A']--;
                left++;
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        int ans = new Solution1().characterReplacement("ABAB", 2);
        System.out.println(ans);
    }
}
