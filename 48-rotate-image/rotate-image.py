class Solution:
    def rotate(self, matrix: List[List[int]]) -> None:
        """
        Do not return anything, modify matrix in-place instead.
        """
        n = len(matrix)
        for i in range(n):
            for j in range(i, n):
                matrix[i][j], matrix[j][i] = matrix[j][i], matrix[i][j]
    
        for i in range(n):
            matrix[i].reverse()
    
        return matrix
    
    #     for i in range(n):
    #         for j in range(i + 1, n):  
    #             matrix[i][j], matrix[j][i] = matrix[j][i], matrix[i][j]
    
    # # Step 2: Reverse each row to complete the 90-degree clockwise rotation
    # for i in range(n):
    #     matrix[i].reverse() 


            
            



        
        