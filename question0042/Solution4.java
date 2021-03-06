package question0042;

/**
 * See analysis: https://blog.csdn.net/qq_41231926/article/details/82682179
 *
 * Solution3的改进，空间换时间。
 *
 * 时间复杂度和空间复杂度均是O(n)，其中n为height数组的长度。
 *
 * 执行用时：3ms，击败88.60%。消耗内存：38.1MB，击败78.65%。
 */
public class Solution4 {
    public int trap(int[] height) {
        int n = height.length, result = 0;
        if (n == 0 || n == 1) {
            return result;
        }
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];
        leftMax[0] = height[0];
        rightMax[n - 1] = height[n - 1];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(height[i], leftMax[i - 1]);
            rightMax[n - 1 - i] = Math.max(height[n - 1 - i], rightMax[n - i]);
        }
        for (int i = 1; i < n - 1; i++) {
            int min = Math.min(leftMax[i - 1], rightMax[i + 1]);
            if (min > height[i]) {
                result += min - height[i];
            }
        }
        return result;
    }
}
