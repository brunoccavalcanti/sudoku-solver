import java.util.Scanner;

public class Game {

    public static void start() {
        Scanner sc = new Scanner(System.in);
        var gs = new GameState();

        System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
        System.out.println("Início de jogo");

        int[] vectorBoard =  new int[]{ 8, 5, 0, 0, 0, 2, 4, 0, 0, 7, 2, 0, 0, 0, 0, 0, 0, 9, 0, 0, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 7, 0, 0, 2, 3, 0, 5, 0, 0, 0, 9, 0, 0 ,0, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 8, 0, 0, 7, 0, 0, 1, 7, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 6, 0, 4, 0};
        Board.printBoard(vectorBoard);

        int[][] board = Util.transformarEm2D(vectorBoard);
        gs.setBoard(board);

        userInsert(gs, sc);

        gs.setLine(ColumnEnum.valueOf(gs.getCoordenades().substring(0, 1).toUpperCase()).getDescricao());
        gs.setCol(Integer.parseInt(gs.getCoordenades().substring(1, 2)) - 1);

        if(verifyLine(gs) && verifyColumn(gs)) {
            gs.setNumberInBoard();
        } else {
            System.out.println("Impossível colocar " + gs.getNumber() + " nessa posição");
        }

        Util.clearConsole();
        Board.printBoard(Util.transformarEm1D(gs.getBoard()));

        sc.close();
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
