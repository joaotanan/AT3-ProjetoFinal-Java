public class Professor extends Pessoa {

    public Professor(String nome, int idade) {
        super(nome, idade);
    }

    @Override
    public String getTipo() {
        return "Professor";
    }
}
