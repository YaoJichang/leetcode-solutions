class Solution {
    public int removeElement(int[] nums, int val) {
        int m= nums.length;
        int [] location = new int [m];
        int count = 0;
        int pos = 0;
        for (int i=0;i<m;i++){
            if (nums[i] == val)
            count++;
            else{
            location[pos]=nums[i];
            pos++;
        }
    }
        for (int i=0;i<pos;i++){
            nums[i]=location[i];
        }
        return m-count;
}   
}
