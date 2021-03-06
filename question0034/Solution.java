package question0034;

/**
 * floor()函数：寻找nums数组中值小于target的最大值所在的索引。
 *
 * ceil()函数：寻找nums数组中值大于target的最小值所在的索引。
 *
 * 时间复杂度是O(logn)，其中n是nums数组的长度。空间复杂度是O(1)。
 *
 * 执行用时：1ms，击败99.30%。消耗内存：42.3MB，击败73.31%。
 */
public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        result[0] = floor(nums, target);
        result[1] = ceil(nums, target);
        return result;
    }

    private int floor(int[] nums, int target) {
        int left = -1, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            if (target <= nums[mid]) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        if (left + 1 < nums.length && nums[left + 1] == target) {
            return left + 1;
        }
        return -1;
    }

    private int ceil(int[] nums, int target) {
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (target >= nums[mid]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        if (right - 1 >= 0 && nums[right - 1] == target) {
            return right - 1;
        }
        return -1;
    }
}
