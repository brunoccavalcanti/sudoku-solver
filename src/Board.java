public class Board {

    public static void printBoard(int[] a) {
        String P = "0121213121213121214";
        String[] R = {"╔═╤╦╗", "║ │║║x", "╟─┼╫╢", "╠═╪╬╣", "╚═╧╩╝"};
        StringBuilder r = new StringBuilder();

        for (var X : P.chars().toArray()) {
            var replacement = P.replace("1", R[X - '0'].length() > 5 ? "151" : "111");

            for (var x : replacement.chars().toArray()) {
                r.append(R[X - '0'].charAt(x - '0'));
            }

            r.append("\n");
        }

        for (int i : a) {
            var value = i > 0 ? String.valueOf(i) : " ";
            r = new StringBuilder(r.toString().replaceFirst("x", value));
        }

        System.out.println(r.toString());
    }

}
