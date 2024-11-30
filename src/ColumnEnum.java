public enum ColumnEnum {

    A(0),
    B(1),
    C(2),
    D(3),
    E(4),
    F(5),
    G(6),
    H(7),
    I(8);

    private int colNumb;

    ColumnEnum(int descricao) {
        this.colNumb = descricao;
    }

    public int getDescricao() {
        return colNumb;
    }
}
