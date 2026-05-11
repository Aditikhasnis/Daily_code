class Solution {
     public int findTheFirst(int low , int high, int[] nums )
    {
        while (low<high)
        {
            int mid = low + (high-low)/2;
            if(nums[mid]<=nums[high] && nums[low]<=nums[mid])
            {
                return low;
            }
            else if (nums[high]<nums[mid])
            {
                low=mid+1;
            }
            else{
                high = mid;
            }
        }
        return low;
    }
    public int binarySearch(int low , int high , int target , int[] nums)
    {
        while(low<=high)
        {
            int mid = low + (high-low)/2;
            if(nums[mid]>target)
            {
                high=mid-1;
            }
            else if (nums[mid]==target)
            {
                return mid;
            }
            else{
                low =mid+1;
            }
        }
        return -1;
    }
    public int search(int[] nums, int target) {
        int first = findTheFirst(0,nums.length-1,nums);
        Arrays.sort(nums);
        int mid = binarySearch(0,nums.length-1,target,nums);
        if(mid==-1)
        {
            return -1;
        }
        return (mid+first)%nums.length;
    }
}