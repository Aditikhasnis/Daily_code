class Solution {
    public boolean isMatch(String s, String p) {
        return matchHelper(s, p, 0, 0, new Boolean[s.length()+1][p.length()+1]);
    }

    private boolean matchHelper(String s, String p, int i, int j, Boolean[][] memo) {
        if (memo[i][j] != null) return memo[i][j];

        // If we've reached end of pattern
        if (j == p.length()) {
            return memo[i][j] = (i == s.length());
        }

        // Check if current chars match
        boolean firstMatch = (i < s.length() &&
                (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.'));

        // If next char in pattern is '*'
        if (j + 1 < p.length() && p.charAt(j + 1) == '*') {
            // Case 1: Skip "char*" in pattern
            // Case 2: If first matches, consume one char in s
            memo[i][j] = (matchHelper(s, p, i, j + 2, memo) ||
                          (firstMatch && matchHelper(s, p, i + 1, j, memo)));
        } else {
            // Normal case: just move forward if chars match
            memo[i][j] = firstMatch && matchHelper(s, p, i + 1, j + 1, memo);
        }

        return memo[i][j];
    }
}
