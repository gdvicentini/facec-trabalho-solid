## Trabalho Trimestal 1 em Java

O trabalho consiste em criar uma conta bancária em linguagem Java, de forma a tentar utilizar os princípios do S.O.L.I.D.
Essa conta bancária utilizará de Hashtable e HashMap para atribuir relações de chave e valor, para poder testar a sua execução diretamente no console, sem a necessidade de atribuir um banco da dados.
O programa conta com uma cadeia de telas de menu no console, onde cada opção desencadeia uma nova tela.

Os passos para a utilização do programa são:
1 - Cadastrar Pessoa Física:
    * Informar nome e cpf;
    * Os dados fornecidos serão utilizados para eventuais validações futuras;

2 - Cadastrar uma Conta Corrente ou Conta Poupança:
    * Informar o cpf criado na etapa anterior;
    * Com o cpf validado (cpf existe!), receberá um número de agência e conta (através de numeros randômicos);
    * Informar uma senha;

3 - Acessar a Conta Criada:
    * Na tela inicial, escolher opção de acessar conta;
    * Informar se vai acessar uma conta corrente ou conta poupança;
    * Informar dados da conta para validação;

4 - Realizar ações referentes à conta:
    * Realizar ações de sacar, depositar, transferir ou conferir saldo;
    * Validações das ações estão realizadas na classe AbstractConta
