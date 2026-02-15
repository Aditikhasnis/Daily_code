class Solution {
    public static int rightBoundary(int[] arr, int target, int low, int high) {
        int ans = high ;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] < target) {
                ans=mid;
                low = mid + 1;
            } else if(arr[mid] > target) {
                high = mid - 1;
                return ans;
            }
            else{
                ans=mid;
                low=mid+1;
            }
        }
        return ans;
    }

    // left boundary: smallest index where arr[mid] >= target
    public static int leftBoundary(int[] arr, int target, int low, int high) {
        int ans = low;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] < target) {
                low=mid + 1;
            } else if (arr[mid] > target) {
                high=mid - 1;
            }
            else{
                ans=mid;
                high=mid-1;
            }
        }
        return ans;
    }

    public int maximumBeauty(int[] nums, int k) {
        Arrays.sort(nums);
        int result = 0;
        int end=0;
        for (int i = 0; i < nums.length; i++) {

            while(end<nums.length && nums[end]-nums[i]<=2*k)
            {
                end++;
            }
            result=Math.max(result,end-i);

        }
        return result;
    }
}
