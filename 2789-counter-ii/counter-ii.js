/**
 * @param {integer} init
 * @return { increment: Function, decrement: Function, reset: Function }
 */
var createCounter = function(init) {
    CurrentCount=init
    function inc()
    {
        CurrentCount++;
        return CurrentCount;
    }
    function dec()
    {
        CurrentCount--;
        return CurrentCount;
    }
    function set()
    {
        CurrentCount=init;
        return init;

    }

    return {
        increment:inc,
        decrement:dec,
        reset:set
    };

    
};

/**
 * const counter = createCounter(5)
 * counter.increment(); // 6
 * counter.reset(); // 5
 * counter.decrement(); // 4
 */