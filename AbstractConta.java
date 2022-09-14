package trabalho_solid;

public abstract class AbstractConta implements InterfaceConta {
    private Double saldo = 0.0;
    private String conta = "";
    private String senha = "";

    public AbstractConta(String conta, String senha) {
        this.conta = conta;
        this.senha = senha;
    }

    public String getConta() {
        return this.conta;
    }

    public String getSenha() {
        return this.senha;
    }

    @Override
    public void depositar(Double valor) {
        // TODO Auto-generated method stub
        if (valor <= 0.0)
            throw new RuntimeException("Valor invalido");

        this.saldo +=valor;
    }
    

    @Override
    public void sacar(Double valor) {
        // TODO Auto-generated method stub
        if (valor <= 0.0)
            throw new RuntimeException("Valor invalido");
            
        if ((this.saldo - valor) <= 0.0)
            throw new RuntimeException("Valor invalido para débito");
        
            this.saldo -= valor;
    }

    @Override
    public void transferir(Double valor) {
        // TODO Auto-generated method stub
        if (valor <= 0.0)
            throw new RuntimeException("Valor invalido");
            
        if ((this.saldo - valor) <= 0.0)
            throw new RuntimeException("Valor invalido para débito");
        
            this.saldo -= valor;
    }

    @Override
    public Double getSaldo() {
        return this.saldo;
    }

}
