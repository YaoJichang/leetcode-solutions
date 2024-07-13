class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        int count = 1;
        int [] numsNew =new int [n];
        numsNew [0] = nums [0];
        int front =0;
        int back = 1;
        int pos = 1;
        while(true){
             if (back == n)
            break;
            
            if (nums[front]==nums[back]){
                back++;
                continue;
            }
            if (nums[front]!=nums[back]){
                numsNew[pos] = nums[back];
                pos++;
                count++;
                front = back;
                back++;
                continue;
            }
           
        }
        for (int i=0;i<n;i++)
        nums[i]=numsNew[i];
        return count;

    }
}
