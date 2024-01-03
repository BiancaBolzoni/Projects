public class Cosmetico extends Loja {
    private double taxaComercializacao;
    
    public double getTaxaComercializacao() {
        return taxaComercializacao;
    }

    public void setTaxaComercializacao(double taxaComercializacao) {
        this.taxaComercializacao = taxaComercializacao;
    }

    public Cosmetico(String nome,double quantidadeFuncionarios,double salarioBaseFuncionario,Endereco endereco,Data dataFundacao,int quantMaxEstoque,double taxaComercializacao){
        super( nome, quantidadeFuncionarios, salarioBaseFuncionario,endereco, dataFundacao,quantMaxEstoque);
        this.taxaComercializacao = taxaComercializacao;
    } 
      
    @Override
    public String toString(){
        return "Loja:" + "\n" +
        "nome: " + getNome() + "\n" +
        "quantidadeFuncionarios: " + getQuantidadeFuncionarios() + "\n" +
        "salarioBaseFuncionario: " + getSalarioBaseFuncionario() + "\n" +
        "Endereço:" + getEndereco() + "\n" +
        "data de Fundação:" + getDataFundacao()+ "\n" +
        "produtos em Estoque: " + getEstoqueProdutos() + "\n" +
        "taxa de Comercialização" + taxaComercializacao;
    }
}
