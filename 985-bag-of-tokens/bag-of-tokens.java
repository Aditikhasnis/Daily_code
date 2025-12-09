class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        int left = 0;
        int right = tokens.length-1;
        int score=0;
        int max_score=0;
        Arrays.sort(tokens);
        while(left<=right)
        {
            if(power>=tokens[left])
            {
                power-=tokens[left];
                score+=1;
                max_score=Math.max(max_score,score);
                left++;
                
            }
            else if(score>0)
            {
                power+=tokens[right];
                right--;
                score-=1;

            }
            else {
                break;
            }
        }

        return max_score;
        
    }
}