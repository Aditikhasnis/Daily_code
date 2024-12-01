from math import gcd

class Solution:
    def canMeasureWater(self, x: int, y: int, target: int) -> bool:
     
        if target > x + y:
            return False
        

        if target == x or target == y or target == x + y:
            return True

        return target % gcd(x, y) == 0