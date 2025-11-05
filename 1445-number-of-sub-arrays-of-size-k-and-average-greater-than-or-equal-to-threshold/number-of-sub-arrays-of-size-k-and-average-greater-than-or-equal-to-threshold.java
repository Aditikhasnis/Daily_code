class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int _windowSize=0;
        int result=0;
        int j=0;
        int sum=0;
        for(int i=0;i<arr.length+1;i++)
        {
            if(_windowSize==k)
            {
                int avg = sum/k;
                if(avg>=threshold)
                {
                   result++;
                }
                sum-=arr[j];
                j++;

            }
            if(i<arr.length)
            {
              sum+=arr[i];
            }
            if(_windowSize<k)
            {
                _windowSize++;
            }
            
        }

        return result;
    }
}