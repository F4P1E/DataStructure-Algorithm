public class P5ClosestSum {
    public static void main(String[] args) {
        closestSum(new int[]{-3, -2, -1, 0, 2, 5, 6});  // expected 0 at indices 1 and 4
        closestSum(new int[]{-9, -1, 0, 5, 15});  // expected 1 at indices 1 and 2
        closestSum(new int[]{1, 2, 3, 4, 5});  // expected 3 at indices 0 and 1
        closestSum(new int[]{-100, -50, -3, -1, 6, 60, 80});  // expected 3 at indices 2 and 4
    }

    static void closestSum(int[] a) {
        int left = 0;
        int right = a.length - 1;
        int closest = Integer.MAX_VALUE;
        int closestLeftIdx = left;
        int closestRightIdx = right;

        while (left < right) {
            int sum = a[left] + a[right];
            if (sum == 0) {  // optimal result found, no need to continue
                System.out.printf("Found closet sum = %d at indices %d and %d\n", sum, left, right);
                return;
            }
            if (Math.abs(sum) < closest) {  // this new sum is closer than the current sum
                closest = Math.abs(sum);
                closestLeftIdx = left;
                closestRightIdx = right;
            }
            if (sum > 0) {  // try to make the new sum smaller
                right--;
            } else {  // try to make the new sum bigger
                left++;
            }
        }
        System.out.printf("Found closet sum = %d at indices %d and %d\n", closest, closestLeftIdx, closestRightIdx);
    }
}