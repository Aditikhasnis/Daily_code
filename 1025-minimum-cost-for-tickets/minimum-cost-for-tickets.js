/**
 * @param {number[]} days
 * @param {number[]} costs
 * @return {number}
 */
var mincostTickets = function(days, costs) {
    const n = days.length;
    const memo = new Map();

    function solve(index, reach) {
        if (index >= n) {
            return 0; 
        }

        const key = `${index}-${reach}`;
        if (memo.has(key)) {
            return memo.get(key); 
        }

        if (days[index] <= reach) {
            
            const result = solve(index + 1, reach);
            memo.set(key, result);
            return result;
        }

        const cost1 = costs[0] + solve(index + 1, days[index]);
        const cost7 = costs[1] + solve(index + 1, days[index] + 6);
        const cost30 = costs[2] + solve(index + 1, days[index] + 29);

        const result = Math.min(cost1, cost7, cost30);
        memo.set(key, result); 
        return result;
    }

    return solve(0, 0);
};