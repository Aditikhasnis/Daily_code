/**
 * @param {string} s
 * @return {number}
 */
var numberOfSubstrings = function(s) {

    let vis={};
    let l=0;
    let r=0;

    let count=0;

    const n=s.length;
    while(r<n)
    {
        vis[s[r]]=(vis[s[r]] || 0) + 1;
        r++;
        while(Object.keys(vis).length===3)
        {
            count+=(n-r+1);
            vis[s[l]]--;
            if(vis[s[l]]===0)
            {
                delete vis[s[l]];
            }
            l++;
        } 
    }

    if(Object.keys(vis).length===3)
    {
        count++;
    }
    return count;
    
};