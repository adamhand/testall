package LeetCode.test79_wordSearch;

public class WordSearch {
    public boolean exist(char[][] board, String word) {
        char[] w = word.toCharArray();
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                if(exist(board, w, i, j,0))
                    return true;
            }
        }
        return false;
    }

    /**
     * 利用异或操作为为每个位置的char记录是否被访问。字母的ascii码小于128，
     * 这里异或256即10000000，异或0即是本身，所以低位没变，
     * 但是高位改变，没有字母能和异或后的结果相等，也就达到了记录是否被访问的效果，节省空间还方便。
     * @param board
     * @param w
     * @param x
     * @param y
     * @param i
     * @return
     */
    public boolean exist(char[][] board, char[] w, int x, int y, int i){
        if(i == w.length)
            return true;
        if(x < 0 || y < 0 || (x == board.length) || (y == board[x].length))
            return false;
        if(board[x][y] != w[i])
            return false;

        board[x][y] ^= 256;
        boolean exist = exist(board, w, x + 1, y, i + 1) ||
                        exist(board, w, x - 1, y ,i + 1) ||
                        exist(board, w, x, y + 1, i + 1) ||
                        exist(board, w, x, y - 1, i + 1);
        board[x][y] ^=256;

        return exist;
    }

    public static void main(String[] args) {
        char[][] board = {
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}
        };
        String word = "ABCCED";
        new WordSearch().exist(board, word);
    }
}
