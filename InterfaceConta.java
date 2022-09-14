package trabalho_solid;

public interface InterfaceConta {
    void depositar(Double valor);
    void sacar(Double valor);
    void transferir(Double valor);
    Double getSaldo();
}
