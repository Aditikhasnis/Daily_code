class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashMap<Integer, HashSet<Integer> > map = new HashMap<>();
        HashSet<Integer> seti = new HashSet<>();
        HashSet<Integer> row = new HashSet<>();
        HashMap<Integer, HashSet<Character>> boxes = new HashMap<>();
        for(int i=0;i<board.length;i++)
        {
            
            for(int j=0;j<board[i].length;j++)
            {

                

                if(board[i][j]!='.')
                {
                  if((map.containsKey(j) && map.get(j).contains(board[i][j]-'1'))|| row.contains(board[i][j]-'1'))
                  {
                    return false;
                  }
                  
                  if(!map.containsKey(j))
                  {
                    map.put(j, new HashSet<>());
                  }
                  map.get(j).add(board[i][j]-'1');
                  row.add(board[i][j]-'1');
                char c = board[i][j];
                int boxIndex = (i / 3) * 3 + (j / 3);
                if (!boxes.containsKey(boxIndex)) boxes.put(boxIndex, new HashSet<>());
                if (boxes.get(boxIndex).contains(c)) return false;
                boxes.get(boxIndex).add(c);
                }
                
            }
            row.clear();
        }

        return true;
    }
}