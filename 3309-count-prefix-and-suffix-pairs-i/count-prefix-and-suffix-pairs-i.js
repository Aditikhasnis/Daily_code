/**
 * @param {string[]} words
 * @return {number}
 */
var countPrefixSuffixPairs = function(words) {

    let count=0;
    for(let i=0;i<words.length;i++)
    {
        word=words[i];
        for(let j=i+1;j<words.length;j++)
        {
            if(word===words[j].substring(0,word.length) && word===words[j].substring(words[j].length-word.length,words[j].length))
            {
                count++;
            }

        }
    }

    return count;
    
};