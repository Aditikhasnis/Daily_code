/**
 * @param {string[]} words
 * @param {number[][]} queries
 * @return {number[]}
 */
var vowelStrings = function(words, queries) {

let MySet = new Set(['a', 'e', 'i', 'o', 'u']);

    let curr=0;
    const n =words.length;
    let prefix_sum= new Array(n).fill(0);
    for(let i=0 ;i<n;i++)
    {
        let first=words[i][0];
        let last=words[i][words[i].length-1];
        if(MySet.has(first) && MySet.has(last))
        {
            curr++;
        }
        prefix_sum[i]=curr;
    }
    console.log(prefix_sum);
    let res=[];

    for(let i=0;i<queries.length;i++)
    {

        let start=queries[i][0]-1;
        let end=queries[i][1];
        res.push(prefix_sum[end]-(prefix_sum[start]||0));

    }

    return res;


    
};