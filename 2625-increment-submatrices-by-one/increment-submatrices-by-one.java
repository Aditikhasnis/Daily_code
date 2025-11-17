class Solution {
    public int[][] rangeAddQueries(int n, int[][] queries) {
        int[][] arr = new int[n][n];
        Arrays.stream(arr).forEach(row-> Arrays.fill(row,0));
        //Brute force solution 
        for(int[] q : queries)
        {
            for(int i=q[0];i<=q[q.length-2];i++)
            {
                for(int j=q[1];j<=q[q.length-1];j++)
                {
                    arr[i][j]+=1;
                }
            }
        }
        return arr;
    }
}