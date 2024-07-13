//Arraylist增删元素方便,hashmap查询元素方便，两个一起用，实现O(1)时间复杂度
//好好学习这两种数据结构的知识！
class RandomizedSet {
    ArrayList<Integer> nums;
    HashMap <Integer,Integer> indices;
    Random random;

    public RandomizedSet() {
        nums = new ArrayList<Integer>();
        indices = new HashMap<Integer,Integer>();
        random = new Random();
    }
    
    public boolean insert(int val) {
        if (indices.containsKey(val)) {
            return false;
        }  //注意这个containsKey!
       
        int index = nums.size(); // 类似于nums.length() 注意下标0也有元素
        nums.add(val);  //注意这个add
        indices.put(val,index) ; // 注意这个put
        return true;
    }

//这个删除的操作比较奇特
    public boolean remove(int val) {
        if (!indices.containsKey(val))
        return false;
        int index = indices.get(val);
        int last = nums.get(nums.size()-1); //记住这个get
        nums.set (index,last); //记住这个set
        nums.remove(nums.size()-1);
        indices.put(last,index); // 如果简单地删除一个元素而不进行替换操作，那么 HashMap 中存储的其他元素索引就会失效或不准确
        indices.remove(val); //记住这个remove
        return true;

    }
    
    //不要以为直接用hashmap就行（看题解评论区）
    public int getRandom() {
        int randomIndex = random.nextInt(nums.size());
        return nums.get(randomIndex);//记住这个get

    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
