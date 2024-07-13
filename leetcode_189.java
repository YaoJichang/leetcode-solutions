class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        int []temp = new int[n]; 
        int pos = k % n;
        int first =0;
        for (int i = 0; i<n-pos ; i ++){
            temp[i+pos] = nums[i];
        }
        for(int i = n-pos; i<n; i++){
            temp [first] = nums [i];
            first ++;
        }

    for (int i=0;i<n;i++){
        nums[i]=temp[i];
    }

    }
}
