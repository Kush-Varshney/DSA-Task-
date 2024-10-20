class Solution {
    public int[] getAverages(int[] nums, int k) {
        int n = nums.length;
        int[] result = new int[n];
        if (k >= (n + 1) / 2) {   // If result is all -1's because k too big.
            for (int i = n - 1; i >= 0; i--)  result[i] = -1;
            return result;
        }
        
        for (int i = k - 1; i >= 0; i--)  result[i] = -1;
        for (int i = n - k; i < n; i++)   result[i] = -1;
        
        int windowSize = 2 * k + 1;
        double sum = 0;
        for (int i = 0; i < windowSize; i++)  sum += nums[i];
        result[k] = (int)(sum / windowSize);

        for (int i = k + 1; i < n - k; i++) {
            sum = sum + nums[i + k] - nums[i - k - 1];
            result[i] = (int)(sum / windowSize);
        }
        return result;
    }
}