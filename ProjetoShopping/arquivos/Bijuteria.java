public class Bijuteria extends Loja {
   private double metaVendas;

public double getMetaVendas() {
    return metaVendas;
}

public void setMetaVendas(double metaVendas) {
    this.metaVendas = metaVendas;
} 
public Bijuteria(String nome,double quantidadeFuncionarios,double salarioBaseFuncionario,Endereco endereco,Data dataFundacao,int quantMaxEstoque,double metaVendas){
    super(nome,quantidadeFuncionarios,salarioBaseFuncionario,endereco,dataFundacao,quantMaxEstoque);
    this.metaVendas = metaVendas;
}
@Override
    public String toString(){
        return "Loja:" + "\n" +
        "nome: " + getNome() + "\n" +
        "quantidadeFuncionarios: " + getQuantidadeFuncionarios() + "\n" +
        "salarioBaseFuncionario: " + getSalarioBaseFuncionario() + "\n" +
        "Endereço:" + getEndereco() + "\n" +
        "data de Fundação:" + getDataFundacao() + "\n" +
        "produtos em Estoque: " + getEstoqueProdutos() + "\n" +
        "meta de Vendas:" + metaVendas;
    }
}
