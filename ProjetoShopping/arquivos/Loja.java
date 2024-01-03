public class Loja{
    private String nome;
    private double quantidadeFuncionarios;
    private double salarioBaseFuncionario;
    private Endereco endereco;
    private Data dataFundacao;
    private Produto[] estoqueProdutos;


    public Produto[] getEstoqueProdutos() {
        return estoqueProdutos;
    }

    public void setEstoqueProdutos(Produto[] estoqueProdutos) {
        this.estoqueProdutos = estoqueProdutos;
    }

    public Loja(String nome,double quantidadeFuncionarios,Endereco endereco,Data dataFundacao,int quantMaxEstoque){
        this.nome = nome;
        this.quantidadeFuncionarios = quantidadeFuncionarios;
        salarioBaseFuncionario = -1.0 ; 
        this.endereco = endereco;
        this.dataFundacao = dataFundacao; 
        this.estoqueProdutos = new Produto[quantMaxEstoque];      
    }

    public Loja(String nome,double quantidadeFuncionarios,double salarioBaseFuncionario,Endereco endereco,Data dataFundacao,int quantMaxEstoque){
        this.nome = nome;
        this.quantidadeFuncionarios = quantidadeFuncionarios;       
        this.salarioBaseFuncionario = salarioBaseFuncionario;
        this.endereco = endereco;
        this.dataFundacao = dataFundacao;   
        this.estoqueProdutos = new Produto[quantMaxEstoque];     

    }
    public Loja(){
        this.nome = null;
        this.quantidadeFuncionarios = 0;
        salarioBaseFuncionario = -1.0 ; 
        this.endereco = null;;
        this.dataFundacao = null;      
    }


    public String getNome(){
        return nome;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    public double getQuantidadeFuncionarios(){
        return quantidadeFuncionarios;
    }
    public void setQuantidadeFuncionarios(int quantidadeFuncionarios){
        this.quantidadeFuncionarios = quantidadeFuncionarios;
    }
    public double getSalarioBaseFuncionario(){
        return salarioBaseFuncionario;
    }
    public void setSalarioBaseFuncionario(double salarioBaseFuncionario){
        this.salarioBaseFuncionario = salarioBaseFuncionario;
    }
    public void setEndereco(Endereco endereco){
        this.endereco = endereco;
    }
    public Endereco getEndereco(){
        return endereco;
    }
    public void setDataFundacao(Data dataFundacao){
        this.dataFundacao = dataFundacao;
    }
    public Data getDataFundacao(){
        return dataFundacao;
    }

    @Override
    public String toString(){
        return "Loja: "+ "\n" + 
        "nome: " + nome +"\n" + 
        "quantidadeFuncionarios: " + quantidadeFuncionarios +"\n" + 
        "salarioBaseFuncionario: " + salarioBaseFuncionario + "\n" +
        "Endereço:" + endereco + "\n" +
        "data de Fundação:" + dataFundacao + "\n" + 
        "produtos em Estoque: " + estoqueProdutos
        ;
    }
    public double gastosComSalario(){
        if(salarioBaseFuncionario>-1){
            return quantidadeFuncionarios*salarioBaseFuncionario;
        }else{
            return -1;
        }
    }
    public char tamanhoDaLoja(){
        if(quantidadeFuncionarios<10){
            return 'P';        
        
        }else if(quantidadeFuncionarios<=30){
            return 'M';
        }else{
            return 'G';
        }
    }
    public void imprimeProdutos(){
        for(int i=0;i<estoqueProdutos.length; i++){
            System.out.println( "Produto " + i + ":" + estoqueProdutos[i]);
        }
    }
    public boolean insereProduto(Produto produto){
        boolean batata = false;
        for(int i=0;i<(estoqueProdutos.length); i++){
            
            if(estoqueProdutos[i]== null) {
                 estoqueProdutos[i] =produto ;
                System.out.println("produto cadastrado");
                batata = true;
                return batata;
            }
        }
        return batata;

    }
    public boolean removeProduto(String nomeProduto){
        for(int i=0;i<estoqueProdutos.length; i++){
            if(estoqueProdutos[i]!=null){
            if(estoqueProdutos[i].getNome() == nomeProduto){
                estoqueProdutos[i]= null;
                return true;
            }
            }
        }
        return false;
    }
}