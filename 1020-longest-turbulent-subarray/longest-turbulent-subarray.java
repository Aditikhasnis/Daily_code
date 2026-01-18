class Solution {
    public int maxTurbulenceSize(int[] arr) {
        int result=1;
        int incount=0;
        int deccount=0;
        int count=0;
        for(int i=0;i<arr.length-1;i++)
        {
            if(arr[i]<arr[i+1])
            {
               incount++;
               deccount=Math.max(0,--deccount);
               if(incount>=2)
               {
                incount=1;
                count=1;
               }
               else{
                count++;
               }
            }
            else if(arr[i]>arr[i+1]){
                deccount++;
                incount=Math.max(0,--incount);
                if(deccount>=2)
               {
                  deccount=1;
                  count=1;
               }
               else{
                count++;
               }

            }
            else{
                count=0;
                incount=0;
                deccount=0;
            }
            result=Math.max(count+1,result);

    }
    return result;
}
}