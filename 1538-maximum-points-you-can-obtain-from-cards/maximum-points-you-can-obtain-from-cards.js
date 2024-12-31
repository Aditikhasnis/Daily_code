/**
 * @param {number[]} cardPoints
 * @param {number} k
 * @return {number}
 */
var maxScore = function(cardPoints, k) {

    const n =cardPoints.length;
    let l=0;
    let r=n-k;
    function sum(nums,j){
        let sumi=0;
        for(let i=0;i<j;i++)
        {
            sumi+=nums[i];

        }
        return sumi
    }
    let mini_sum=sum(cardPoints,n-k);
    let res=mini_sum
    while(r<n)
    {
        res+=(cardPoints[r]-cardPoints[l]);
        l++;
        r++;
        mini_sum=Math.min(mini_sum,res);
        
    }

    return sum(cardPoints,n)-mini_sum;


    
};