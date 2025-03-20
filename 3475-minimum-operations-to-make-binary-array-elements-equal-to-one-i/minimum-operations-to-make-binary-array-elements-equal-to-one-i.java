class Solution {
    public int minOperations(int[] nums) {


      int j=0;
      int i=0;
      int count=0;
      while (j+2<nums.length)
      {

        if(nums[j]==0)
        {
            count++;
            nums[j+1]^=1;
            nums[j+2]^=1;
        }

        j++;

      }

      return (nums[j] + nums[j+1] == 2) ? count:-1;

        
    }
}