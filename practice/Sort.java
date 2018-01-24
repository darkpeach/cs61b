public class Sort {
    /** Sorts strings destructively. */
    public static void sort(String[] input){
        int smallestIndex = findSmallest(input, 0);
        swap(input, smallestIndex, 0);
        sort(input, 1);


    }
    /** destrunctively sort a array from given index. */
    public static void sort(String[] input, int start){
        if(input.length == start){
            return;
        }

        int smallestIndex = findSmallest(input, start);
        swap(input, smallestIndex, start);
        sort(input, start + 1);
    }
    /** Return the smallest index in arrry from given start */
    public static int findSmallest(String[] x, int start){
        int smallestIndex = start;
        for(int i = start; i < x.length; i++){
            int cmp = x[i].compareTo(x[smallestIndex]);
            if(cmp < 0){
                smallestIndex = i;
            }
        }
        return smallestIndex;
    }
     /** Swap item A with item B. */
     public static void swap(String[] x, int a, int b){
         String temp = x[a];
         x[a] = x[b];
         x[b] = temp;
     }

}
