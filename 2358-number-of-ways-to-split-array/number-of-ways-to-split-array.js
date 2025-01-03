/**
 * @param {number[]} nums
 * @return {number}
 */
var waysToSplitArray = function(nums) {


    function sum()
    {
        let s=0;
        for(let i=0;i<nums.length;i++)
        {
            s+=nums[i];

        }
        return s;
    }

    const s1=sum();
    let s2=0;
    let valid=0;
    for(let i=0;i<nums.length-1;i++)
    {

        s2+=nums[i];

        if(s2>=(s1-s2))
        {
            valid++;

        }

    }

    return valid;
    
};