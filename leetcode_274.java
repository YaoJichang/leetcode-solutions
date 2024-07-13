//题解的第二种方法应当掌握
class Solution {
    public int hIndex(int[] citations) {   
        int n = citations.length;
        int h_index = 0;
        Arrays.sort(citations);
        int max = citations[n-1];
        int min = n>citations[0]?citations[0]:n;
        for (int i =min;i<=max;i++){
            int res = 0;
            for (int j=0;j<n;j++){
                if (citations[j]>=i)
                res++;
                if (res>=i){
                    h_index = Math.max(h_index,i);
                }
            
            }
        }
        return h_index;
         
    }
}
