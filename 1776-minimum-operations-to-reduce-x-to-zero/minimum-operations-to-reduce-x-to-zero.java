class Solution {

        
            public int BinarySearch(int low , int high , int[] prefix , int target){
            while(low<=high){
                int mid = low + (high-low) / 2 ;
                if(prefix[mid]==target){
                    return mid;
                }
                else if ( prefix[mid]>target){
                    high=mid-1;
                }
                else {
                    low = mid +1;
                }
            }
            return -1;
        }
        public int minOperations(int[] nums, int x) {
            int n = nums.length;
            int sum=0;
            int[] prefix = new int[n];
            prefix[0]=nums[0];
            int[] suffix = new int[n];
            suffix[n-1]=nums[n-1];
            for(int i=1;i<nums.length;i++){
                prefix[i]=nums[i]+prefix[i-1];
            }
            for(int i=n-2 ; i>=0 ;i--){
                suffix[i]=nums[i]+suffix[i+1];
            }
            int mini=Integer.MAX_VALUE;
            for(int j=n-1;j>=0;j--){
                int target = x - suffix[j];
                if(x==suffix[j]){
                    mini=Math.min(mini,n-j);
                    continue;
                }
                if(target<0){
                    break;
                }
                int index = BinarySearch(0,j-1,prefix,target);
                if(index==-1 || index > j ){
                    continue;
                }
                mini=Math.min(mini,(n-j) + index+1);
            }
            int searchLast = BinarySearch(0,n-1,prefix,x);
            if(mini==Integer.MAX_VALUE && searchLast==-1){
                mini=-1;
            }
            return searchLast!=-1 ? Math.min(mini,searchLast+1):mini;

        }
}