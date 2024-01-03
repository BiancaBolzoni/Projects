public class Informatica extends Loja {
    private double seguroEletronicos;

    public double getSeguroEletronicos() {
        return seguroEletronicos;
    }

    public void setSeguroEletronicos(double seguroEletronicos) {
        this.seguroEletronicos = seguroEletronicos;
    }
    
    public Informatica(String nome,double quantidadeFuncionarios,double salarioBaseFuncionario,Endereco endereco,Data dataFundacao,int quantMaxEstoque,double seguroEletronicos){
        super(nome,quantidadeFuncionarios,salarioBaseFuncionario,endereco,dataFundacao,quantMaxEstoque);
        this.seguroEletronicos = seguroEletronicos;
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
        "seguro Eletronicos" + seguroEletronicos;
    }
}
