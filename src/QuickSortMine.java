/**
 * Created by kevin on 2017/9/18.
 */
public class QuickSortMine {
    public static void main(String[] args) {
        int[] a = new int[]{2,7,4,5,10,1,9,3,8,6};
//        int[] a = new int[]{2, 2, 2};
        sort(a, 0, a.length - 1);
        for (int i : a) {
            System.out.print(i+"\t");
        }

    }


    public static void sort(int[] a, int start, int end) {
        if (start < end) {
            int position = dividedAndPosition(a, start, end);
            sort(a, start, position - 1);
            sort(a, position + 1, end);
        }
    }

    /**
     * 这个方法的目的就只有一个：随机选中一个数字，并把这个数字通过与其他数据调换位置从事是这个数字在数组中是正确的位置
     * @param a     the target arrays
     * @param start start position
     * @param end   end position
     * @return      the selected number's target postition
     */
    public static int dividedAndPosition(int[] a, int start, int end) {
        int baseData = a[end];
        //这里必须使用while循环，while里面的每一次循环只允许左右各比较之后置换一次位置，在到达最终正确位置的时候可能需要置换n多次
        while (start < end) {
            //从左边开始遍历数据和基础值比对
            while (start < end && a[start] <= baseData) {
                start++;
            }
            //此处判断是因为上面的操作直接导致start == end
            if (start < end) {
                int tmp = a[start];
                a[start] = a[end];
                a[end] = tmp;
                //调换完位置之后这个位置的数据其实是已经比对过的，不需要再次参加比对
                end--;
            }

            //从右边开始遍历数据
            while (start < end && a[end] >= baseData) {
                end--;
            }

            if (start < end) {
                int tmp = a[end];
                a[end] = a[start];
                a[start] = tmp;
                //调换完位置之后start的这个位置其实已经比对过了
                start++;
            }

        }

        return end;
    }


    public void sortIntegers2(int[] A) {
        // write your code here
        sort(A,0,A.length-1);
    }
}
