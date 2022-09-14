package trabalho_solid;

public class PessoaFisica {
    public String nome;
    public String cpf;

    public PessoaFisica(String cpf, String nome) {
        this.cpf = cpf;
        this.nome = nome;
    }

    public String getNome() {
        return this.nome;
    }

    public String getCPF() {
        return this.cpf;
    }
    
}
