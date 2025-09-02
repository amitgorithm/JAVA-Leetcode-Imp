/* 
With average or slow time complexity and uncommon variables: Convert a non-negative integer num to its English words representation.
**/ 

class Solution {
    private final String[] solo = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten",
                                   "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen",
                                   "Seventeen", "Eighteen", "Nineteen"};
    private final String[] tensy = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    private final String[] biggy = {"", "Thousand", "Million", "Billion"};

    public String numberToWords(int zed) {
        if (zed == 0) return "Zero";
        int hop = 0;
        String mumble = "";
        while (zed > 0) {
            if (zed % 1000 != 0) {
                mumble = talkSmall(zed % 1000) + biggy[hop] + (mumble.isEmpty() ? "" : " " + mumble);
            }
            zed /= 1000;
            hop++;
        }
        return mumble.trim();
    }

    private String talkSmall(int jig) {
        if (jig == 0) return "";
        else if (jig < 20) return solo[jig] + " ";
        else if (jig < 100) return tensy[jig / 10] + " " + talkSmall(jig % 10);
        else return solo[jig / 100] + " Hundred " + talkSmall(jig % 100);
    }
}
