//题解中的KMP算法应该关注
class Solution {
    public int strStr(String haystack, String needle) {
        int m = haystack.length();
        int n = needle.length();
        int temp = 1;
        if (n>m)
        return -1;
        if(n==m){
            if (haystack.equals(needle)){
                return 0;
            }
            else{
                return -1;
            }
        }
        for (int i =0; i<m;i++){
            if (haystack.charAt(i)==needle.charAt(0)){
                if (n== 1)
                return i;
                for (int j = i+1;j<i+n;j++){
                    if(j>=m)
                    return -1;
                    if (haystack.charAt(j)==needle.charAt(temp)){
                        temp++;
                        if(temp == n)
                        return i;
                        continue;
                    }
                    else{
                        temp = 1;
                        break;
                    }
                }
            }
        }
        return -1;
    }
}
