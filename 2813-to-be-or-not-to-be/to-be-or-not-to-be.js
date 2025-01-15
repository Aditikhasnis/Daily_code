/**
 * @param {string} val
 * @return {Object}
 */
var expect = function(val) {

   function Be(val1)
   {
        if(val1===val)
        {
            return true;
        }
        else
        {
            throw new Error("Not Equal");
        }

   }
    
    function Bee(val1)
    {
        if(val1!==val)
        {
            return true;
        }
        else
        {
            throw new Error("Equal");
        }
    }

    return {
        toBe:Be,
        notToBe:Bee
    };
};

/**
 * expect(5).toBe(5); // true
 * expect(5).notToBe(5); // throws "Equal"
 */