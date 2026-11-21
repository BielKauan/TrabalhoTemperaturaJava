
import java.util.Scanner;

public class GerenciadorTemperaturasSemanais {

    static double[] temperaturas = new double[7];
    static String[] diasDaSemana ={
        "Domingo",
        "Segunda",
        "Terça",
        "Quarta",
        "Quinta",
        "Sexta",
        "Sábado"
        };
    static boolean temperaturasRegistradas = false;
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int opcao;

        do{
            System.out.println("\n===== GERENCIADOR DE TEMPERATURAS =====");
            System.out.println("1 - Inserir temperaturas");
            System.out.println("2 - Mostrar todas as temperaturas");
            System.out.println("3 - Calcular média semanal");
            System.out.println("4 -  Indicar dia mais quente e mais frio");
            System.out.println("5 - Sair");
            System.out.print("Escolha uma opção: ");


            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                   for (int i = 0; i < 7; i++){

                    System.out.print("Digite a temperatura de " + diasDaSemana[i] + ": ");
                    temperaturas[i] = scanner.nextDouble();

                    while (temperaturas[i] < -20 || temperaturas[i] > 50){

                        System.out.println("Temperaturas inválida: Digite entre -20°C e 50°C.");

                        System.out.print("Digite novamente a temperatura de " + diasDaSemana[i] + ": ");
                        temperaturas[i] = scanner.nextDouble();

                    }
                   }
                   System.out.println("Temperaturas registradas com sucesso!");

                   temperaturasRegistradas = true;
                   break;
                
                
                case 2:

                    if (temperaturasRegistradas){

                        System.out.println("\n===== TEMPERATURAS DA SEMANA =====");

                        for (int i = 0; i < 7; i++){
                            System.out.println(diasDaSemana[i] + ": " + temperaturas[i] + "°C");

                        }
                    } else {
                        System.out.println("Voce ainda não registrou as temperaturas: ");

                    } break;
                
                case 3:
                    if (temperaturasRegistradas){

                        double media = calcularMediaSemanal();

                        System.out.printf("A média semanal é: %.2f°C%n", media);
                    }else{
                       System.out.println("Cadastre as temperaturas primeiro.");
                    }
                    break;

                case 4:

                    if (temperaturasRegistradas){

                        mostrarDiasMaisQuentesEFrios();
                    }else{
                        System.out.println("Cadastre as temperaturas primeiro.");
                    }
                    break;
                    

                case 5:
                    System.out.println("Encerrando o sistema...");
                    break;

                default:
                    System.out.println("Opção indiválida! Escolha entre 1 e 5.");
                            }
    } while (opcao != 5);

    scanner.close();
}

static double calcularMediaSemanal(){

    double soma = 0;

    for (int i = 0; i < 7; i++) {
        soma += temperaturas[i];

    }
    return soma / 7;
}
static void mostrarDiasMaisQuentesEFrios(){
    double maiorTemperatura = temperaturas[0];
    double menorTemperatura = temperaturas[0];

    for (int i = 1; i < 7; i++){
        if (temperaturas[i] > maiorTemperatura) {
            maiorTemperatura = temperaturas[i];

        }
    if (temperaturas[i] < menorTemperatura){
        menorTemperatura = temperaturas[i];
    }
    }

    System.out.println("\n===== DIAS MAIS QUENTES =====");

    for(int i = 0; i < 7; i++){
        if (temperaturas[i] == maiorTemperatura){
            System.out.println(diasDaSemana[i] +": " + maiorTemperatura + "°C");
        }
    }
    System.out.println("\n===== DiAS MAIS FRIOS =====");

    for (int i = 0; i < 7; i++){

        if (temperaturas[i] == menorTemperatura){
            System.out.println(diasDaSemana[i] + ": " + menorTemperatura + "°C");
        }
    }
}
}