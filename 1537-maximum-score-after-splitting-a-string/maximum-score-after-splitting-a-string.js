/**
 * @param {string} s
 * @return {number}
 */
var maxScore = function(s) {

    let dict= {}    
    max=0;
    for(let i=0;i<s.length;i++)
    {
        if(s[i]==='1')
        {
            dict[s[i]]=(dict[s[i]] || 0)+1;
        }
    }
    let count=0;

    for(let i=0;i<s.length-1;i++)
    {
        if(s[i]==='0')
        {
            count++;
        }
        else{
            if(dict[s[i]] && dict[s[i]]>0 )
            {
                dict[s[i]]-=1;
            }
        }

        max=Math.max(max,count+(dict['1'] || 0));
        
    }

    return max;
    
};