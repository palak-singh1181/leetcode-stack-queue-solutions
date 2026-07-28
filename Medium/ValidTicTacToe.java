
public class ValidTicTacToe {


    public static boolean validTicTacToe(String[] board) {


        int xCount = 0;
        int oCount = 0;


        for (String row : board) {

            for (char c : row.toCharArray()) {

                if (c == 'X')
                    xCount++;

                else if (c == 'O')
                    oCount++;
            }
        }


        boolean xWin = win(board, 'X');
        boolean oWin = win(board, 'O');


        if (xWin && oWin)
            return false;


        if (xWin)
            return xCount == oCount + 1;


        if (oWin)
            return xCount == oCount;


        return xCount == oCount || xCount == oCount + 1;
    }



    public static boolean win(String[] board, char player) {


        for (int i = 0; i < 3; i++) {

            if (board[i].charAt(0) == player &&
                board[i].charAt(1) == player &&
                board[i].charAt(2) == player)

                return true;
        }



        for (int i = 0; i < 3; i++) {

            if (board[0].charAt(i) == player &&
                board[1].charAt(i) == player &&
                board[2].charAt(i) == player)

                return true;
        }



        if (board[0].charAt(0) == player &&
            board[1].charAt(1) == player &&
            board[2].charAt(2) == player)

            return true;



        if (board[0].charAt(2) == player &&
            board[1].charAt(1) == player &&
            board[2].charAt(0) == player)

            return true;


        return false;
    }



    public static void main(String[] args) {


        String[] board1 = {
            "O  ",
            "   ",
            "   "
        };


        System.out.println(validTicTacToe(board1));


        String[] board2 = {
            "XOX",
            " X ",
            "   "
        };


        System.out.println(validTicTacToe(board2));


        String[] board3 = {
            "XOX",
            "O O",
            "XOX"
        };


        System.out.println(validTicTacToe(board3));
    }
}