/**
 * @param {string[]} words
 * @return {string[]}
 */
var stringMatching = function(words) {


    words.sort((a,b)=> a.length-b.length);
    let res=[];
    for(let i=0;i<words.length;i++)
    {
        let word = words[i];
        for(let j=i+1 ;j<words.length;j++)
        {
            if(words[j].includes(word))
            {
                res.push(word);
                break;

            }
        }
    }

    return res;

    
};