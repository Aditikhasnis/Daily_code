class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {

         boolean one=false;
         boolean two=false;
         boolean  three=false;
         for (int i=0;i<triplets.length;i++)
         {
            if (triplets[i][0]<=target[0] && triplets[i][1]<=target[1] && triplets[i][2]<=target[2])
            {
                if(triplets[i][0]==target[0])
                {
                    one=true;
                }
                if(triplets[i][1]==target[1])
                {
                    two=true;
                }
                if(triplets[i][2]==target[2])
                {
                    three=true;
                }
                
            }

         }

         return one && two && three;

        
    }
}