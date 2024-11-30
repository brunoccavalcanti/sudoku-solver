public class Util {

    public static int[][] transformarEm2D(int[] vetor) {
        int colunas = 9; // Número fixo de colunas
        int linhas = (int) Math.ceil((double) vetor.length / colunas); // Calcula o número de linhas necessárias

        // Criação do array 2D com as dimensões calculadas
        int[][] matriz = new int[linhas][colunas];

        // Preenchendo a matriz com os valores do vetor
        for (int i = 0; i < vetor.length; i++) {
            matriz[i / colunas][i % colunas] = vetor[i];
        }

        return matriz;
    }

    public static int[] transformarEm1D(int[][] matriz) {
        // Calcula o tamanho total necessário para o vetor 1D
        int totalElementos = 0;
        for (int[] linha : matriz) {
            totalElementos += linha.length;
        }

        // Cria o vetor unidimensional
        int[] vetor = new int[totalElementos];

        // Preenche o vetor 1D com os elementos do array 2D
        int indice = 0;
        for (int[] linha : matriz) {
            for (int elemento : linha) {
                vetor[indice++] = elemento;
            }
        }

        return vetor;
    }

    public final static void clearConsole()
    {
        try
        {
            final String os = System.getProperty("os.name");

            Runtime.getRuntime().exec("cls");
        }
        catch (final Exception e)
        {
            //System.out.println("Erro ao limpar console");
        }
    }
}
