public class Alimentacao extends Loja{
    private Data dataAlvara;

    public Data getDataAlvara() {
        return dataAlvara;
    }

    public void setDataAlvara(Data dataAlvara) {
        this.dataAlvara = dataAlvara;
    }

    public Alimentacao(String nome,double quantidadeFuncionarios,double salarioBaseFuncionario,Endereco endereco,Data dataFundacao,Data dataAlvara,int quantMaxEstoque){
        super(nome,quantidadeFuncionarios,salarioBaseFuncionario,endereco,dataFundacao, quantMaxEstoque);
        this.dataAlvara = dataAlvara;
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
        "data Alvará:" + dataAlvara;
    }
}
