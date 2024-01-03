public class Vestuario extends Loja {
    private boolean produtosImportados;

    public boolean isProdutosImportados() {
        return produtosImportados;
    }

    public void setProdutosImportados(boolean produtosImportados) {
        this.produtosImportados = produtosImportados;
    }
    public boolean getProdutosImportados(){
        return produtosImportados;
    }

    public Vestuario(String nome,double quantidadeFuncionarios,double salarioBaseFuncionario,Endereco endereco,Data dataFundacao,boolean produtosImportados,int quantMaxEstoque){
        super( nome, quantidadeFuncionarios, salarioBaseFuncionario,endereco, dataFundacao,quantMaxEstoque);
        this.produtosImportados = produtosImportados;
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
        "Produtos  Importados:" + produtosImportados;
    }
}
