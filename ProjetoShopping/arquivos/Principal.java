

public class Principal {
    public static void main(String[] args){

        
        int opcao = 0;
        while(opcao!=3){

        System.out.println("Escolha a opção desejada:");
        System.out.println("1 - Criar uma Loja");
        System.out.println("2 - Criar um Produto");
        System.out.println("3 - Sair");
        opcao = Teclado.leInt();

        switch (opcao) {
            case 1:
            Loja loja1 = new Loja(Teclado.leString("Digite o nome da Loja:"),Teclado.leDouble("DIGITE A QUANTIDADE DE FUNCIONARIOS"),
            Teclado.leDouble("DIGITE O SALARIO BASE"), 
            new Endereco(Teclado.leString("Digite o nome da rua:"),
            Teclado.leString("Digite o numero do endereço:"),
            Teclado.leString("Digite o complemento se tiver:"),
            Teclado.leString("Digite o CEP:"),
            Teclado.leString("Digite a cidade:"),
            Teclado.leString("Digite o estado:"),
            Teclado.leString("Digite o pais:")),
            new Data(Teclado.leInt("digite o dia:"), Teclado.leInt("digite o mes:"), Teclado.leInt("digite o ano:")),Teclado.leInt("digite a quantidade max de estoque de produtos"));
            System.out.println("Loja criada com sucesso!");
            System.out.println(loja1.toString());
                           
                break;
            case 2:
            Produto produto1 = new Produto(Teclado.leString("Digite o nome do produto:"),Teclado.leDouble("Digite o preço do produto:"),
            new Data(Teclado.leInt("digite o dia de validade:"), Teclado.leInt("digite o mes de validade:"), Teclado.leInt("digite o ano de validade:"))
            );
            System.out.println("Produto criado com sucesso!");
            if(produto1.estaVencido(new Data(20,10,2023))){
                System.out.println("PRODUTO VENCIDO");
            }else{
                System.out.println("PRODUTO NÃO VENCIDO");
            }


                break;
        
            default:
            System.out.println("Opção inválida");
                break;
        }


        }


    }
}
