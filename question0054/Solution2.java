package question0054;

import java.util.ArrayList;
import java.util.List;

/**
 * 用top、bottom、left、right这4个变量来控制旋转。
 *
 * 时间复杂度是O(p)，其中p为矩阵中的元素个数。空间复杂度是O(1)。
 *
 * 执行用时：0ms，击败100%。消耗内存：35.4MB，击败41.86%。
 */
public class Solution2 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        int m = matrix.length;
        if (m == 0) {
            return list;
        }
        int n = matrix[0].length;
        int top = 0, bottom = m - 1, left = 0, right = n - 1;
        while (top <= bottom && left <= right) {
            for (int i = left; i <= right; i++) {
                list.add(matrix[top][i]);
            }
            top++;
            for (int i = top; i <= bottom; i++) {
                list.add(matrix[i][right]);
            }
            right--;
            if (bottom >= top) {
                for (int i = right; i >= left; i--) {
                    list.add(matrix[bottom][i]);
                }
                bottom--;
            }
            if (right >= left) {
                for (int i = bottom; i >= top; i--) {
                    list.add(matrix[i][left]);
                }
                left++;
            }
        }
        return list;
    }
}
