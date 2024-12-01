import java.util.Scanner;

public class Game {

    public static void start(int[] startBoard) {
        boolean finish = false;
        Scanner sc = new Scanner(System.in);
        int[][] board = Util.transformarEm2D(startBoard);
        var gs = new GameState();
        gs.setBoard(board);

        while (!finish) {
            Board.printBoard(Util.transformarEm1D(gs.getBoard()));

            userInsert(gs, sc);
            if (gs.getNumber() == 00) finish = true;

            gs.setLine(ColumnEnum.valueOf(gs.getCoordenades().substring(0, 1).toUpperCase()).getDescricao());
            gs.setCol(Integer.parseInt(gs.getCoordenades().substring(1, 2)) - 1);

            if (verifyLine(gs) && verifyColumn(gs) && verifyQuadrant(gs)) {
                gs.setNumberInBoard();
            } else {
                System.out.println("Impossível colocar " + gs.getNumber() + " nessa posição");
            }

            Util.clearConsole();
        }
        sc.close();
    }

    private static boolean verifyQuadrant(GameState gs) {
        for (int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                if (gs.getBoard()[i][j] == gs.getNumber()) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean verifyColumn(GameState gs) {
        for (int i = 0; i < 9; i++) {
            if (gs.getBoard()[i][gs.getCol()] == gs.getNumber()) {
                return false;
            }
        }
        return true;
    }

    private static boolean verifyLine(GameState gs) {
        for (int i = 0; i < 9; i++) {
            if (gs.getBoard()[gs.getLine()][i] == gs.getNumber()) {
                return false;
            }
        }
        return true;
    }

    private static void userInsert(GameState gs, Scanner sc) {
        System.out.print("Insira o numero:");
        gs.setNumber(sc.nextInt());

        System.out.print("Insira as coordenadas [linha/coluna]: ");
        gs.setCoordenades(sc.next());
    }
}
