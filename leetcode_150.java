class Solution {
    public int evalRPN(String[] tokens) {
        Deque <Integer> st = new LinkedList<Integer> ();
        int result = 0;
        int len = tokens.length;
        if (len == 1)
        return Integer.valueOf(tokens[0]);


        for (int i = 0;i<len;i++){
            if(tokens[i].equals("+")){
                int first = st.pop();
                int last = st.pop();
                result = first+last;
                st.push(result);
            }

          else if(tokens[i].equals("*")){
                int first = st.pop();
                int last = st.pop();
                result = first*last;
                st.push(result);
            }

           else if(tokens[i].equals("-")){
                int first = st.pop();
                int last = st.pop();
                result = last-first;
                st.push(result);
            }

           else if(tokens[i].equals("/")){
                int first = st.pop();
                int last = st.pop();
                result = last/first;
                st.push(result);
            }

        else{
                st.push(Integer.valueOf(tokens[i])); //注意怎么把String类型转换为整型
                 
            }
        }

        return result;

    }
}
