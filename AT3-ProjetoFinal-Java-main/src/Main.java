import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        PessoaDAO dao = new PessoaDAO();

        int opc = 0;

        while (opc != 3) {
            System.out.println("\n===== MENU =====");
            System.out.println("1 - Cadastrar");
            System.out.println("2 - Consultar");
            System.out.println("3 - Sair");
            System.out.print("Opção: ");
            opc = sc.nextInt();
            sc.nextLine();

            switch (opc) {
                case 1:
                    System.out.println("1 - Aluno");
                    System.out.println("2 - Professor");
                    System.out.print("Escolha: ");
                    int tipo = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Nome: ");
                    String nome = sc.nextLine();

                    System.out.print("Idade: ");
                    int idade = sc.nextInt();
                    sc.nextInt();

                    Pessoa p = (tipo == 1) ? new Aluno(nome, idade) : new Professor(nome, idade);
                    dao.cadastrar(p);
                    break;

                case 2:
                    dao.consultar();
                    break;

                case 3:
                    System.out.println("Encerrando...");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }
        }

        sc.close();
    }
}
