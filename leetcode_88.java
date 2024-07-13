class Solution {
public void merge(int[] nums1, int m, int[] nums2, int n) {
    // 如果 nums1 中已经有元素，将 nums2 的元素复制到 nums1 的末尾
    if (m != 0) {
        for (int i = m; i < m + n; i++) {
            nums1[i] = nums2[i - m]; // 注意这里的索引调整
        }
    } else {
        // 如果 nums1 是空的，直接复制 nums2 的所有元素到 nums1
        for (int i = 0; i < n; i++) {
            nums1[i] = nums2[i];
        }
    }
    
    // 对合并后的 nums1 进行排序
    Arrays.sort(nums1);
}
}
