public class Produto {
    private String nome;
    private double preco;
    private Data dataValidade;
    Data dataAtual;

    public Produto(String nome,double preco,Data dataValidade){
        this.nome = nome;
        this.preco = preco;
        this.dataValidade = dataValidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
    public void setDataValidade(Data dataValidade){
        this.dataValidade = dataValidade;
    }
    public Data getDataValidade(){
        return dataValidade;
    }
    
    public boolean estaVencido(Data dataAtual){
        if(dataValidade.getAno()<dataAtual.getAno()){
            return true;
        }else if(dataValidade.getAno()== dataAtual.getAno() && dataValidade.getMes()<dataAtual.getMes()){
            return true;
        }else if(dataValidade.getAno()== dataAtual.getAno() && dataValidade.getMes()==dataAtual.getMes() && dataValidade.getDia()<dataAtual.getDia()){
            return true;
        }else{
            return false;}
    }
    @Override
    public String toString(){
        return "Nome: " + nome + "\n" + "Preço: " + preco + "\n" + "Data de Validade:" + dataValidade;
    }
    
}
