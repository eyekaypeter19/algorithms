package TwoPointers;

class BackspaceCompare {

    public static boolean compare(String str1, String str2) {
        int high1 = str1.length() - 1;
        int high2 = str2.length() - 1;
        while (high1 >= 0 || high2 >= 0) {
            int i1 = getNextValidCharIndex(str1, high1);
            int i2 = getNextValidCharIndex(str2, high2);
            if(i1 < 0 && i2 < 0) {
                return true;
            }
            //we have reached the end of either one of the strings
            if (i1 < 0 || i2 < 0) {
                return false;
            }
            if(str1.charAt(i1) != str2.charAt(i2)) {
                return false;
            }
            high1 = i1 -1;
            high2 = i2 -1;
        }
        return true;
    }

    public static int getNextValidCharIndex(String string, int currentIndex) {
        int backSpaceCount = 0;
        while(currentIndex>=0) {
            if(string.charAt(currentIndex) == '#') {
                backSpaceCount ++;
            } else if (backSpaceCount > 0) {
                backSpaceCount -- ;
            } else {
                break;
            }
            currentIndex--;
        }
        return currentIndex;
    }

    public static void main(String[] args) {
        System.out.println(BackspaceCompare.compare("xy#z", "xzz#"));
        System.out.println(BackspaceCompare.compare("xy#z", "xyz#"));
        System.out.println(BackspaceCompare.compare("xp#", "xyz##"));
        System.out.println(BackspaceCompare.compare("xywrrmp", "xywrrmu#p"));
    }
}