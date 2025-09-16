class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashMap<Integer, HashSet<Character>> cols = new HashMap<>();
        HashMap<Integer, HashSet<Character>> boxes = new HashMap<>();
        
        for (int i = 0; i < 9; i++) {
            HashSet<Character> row = new HashSet<>();
            
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c == '.') continue;

                // Row check
                if (row.contains(c)) return false;
                row.add(c);

                // Column check
                if (!cols.containsKey(j)) cols.put(j, new HashSet<>());
                if (cols.get(j).contains(c)) return false;
                cols.get(j).add(c);

                // Box check
                int boxIndex = (i / 3) * 3 + (j / 3);
                if (!boxes.containsKey(boxIndex)) boxes.put(boxIndex, new HashSet<>());
                if (boxes.get(boxIndex).contains(c)) return false;
                boxes.get(boxIndex).add(c);
            }
        }
        return true;
    }
}
