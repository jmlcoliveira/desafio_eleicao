import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int num_assentos = input.nextInt();
        input.nextLine();
        int num_partidos = input.nextInt();
        input.nextLine();
        double[] num_votos_por_partido = new double[num_partidos];
        int index = 0;
        while (index < num_partidos) {
            num_votos_por_partido[index] = input.nextDouble();
            input.nextLine();
            index++;
        }

        int[] assentos_por_partido = new int[num_partidos];
        double[] quocientes = new double[num_partidos];
        while (num_assentos > 0) {
            for (int i = 0; i < num_partidos; i++) {
                quocientes[i] =
                        num_votos_por_partido[i] / (assentos_por_partido[i] + 1);
            }

            index = 0;
            int index_mais_alto = 0;
            while (index < num_partidos) {
                if (quocientes[index] > quocientes[index_mais_alto]) {
                    index_mais_alto = index;
                }
                else if(quocientes[index] == quocientes[index_mais_alto]){
                    if(num_votos_por_partido[index] < num_votos_por_partido[index_mais_alto]){
                        index_mais_alto = index;
                    }
                }
                index++;
            }
            assentos_por_partido[index_mais_alto]++;
            num_assentos--;
        }

        for (int num : assentos_por_partido)
            System.out.println(num);
    }
}
