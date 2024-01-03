public class Shopping {
    private String nome;
    private Endereco endereco;
    private Loja[] lojas;

    public Shopping(String nome,Endereco endereco,int quantMaxLojas){
        this.lojas = new Loja[quantMaxLojas];
        this.nome = nome;
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Loja[] getLojas() {
        return lojas;
    }

    public void setLojas(Loja[] lojas) {
        this.lojas = lojas;
    }
    @Override
    public String toString(){
        return "Nome do Shopping: " + nome +"\n"
        + "Endereço: " + endereco + "\n"
        +"Lojas: " + lojas;
    }
    public boolean insereLoja(Loja lojaInserida){
        boolean batata = false;
        for(int i =0;i<lojas.length;i++){
            if(lojas[i]==null){
                lojas[i] = lojaInserida;
                batata = true;
                return batata;
                
            }
        }
        return batata;

    }


    public boolean removeLoja(String nomeLoja){
        for(int i=0;i<lojas.length; i++){
            if(lojas[i]!=null){
            if(lojas[i].getNome() == nomeLoja){
                lojas[i]= null;
                return true;
            }
        }}
        return false;
    }
    public int quantidadeLojasPorTipo(String tipoLoja) {
        int contador = 0; 
    
        if (tipoLoja.equalsIgnoreCase("cosmetico") || tipoLoja.equalsIgnoreCase("cosmético")) {
            for (int i = 0; i < lojas.length; i++) {
                if (lojas[i] != null && lojas[i] instanceof Cosmetico) {
                    
                    contador++;
                }
            }
        } else if (tipoLoja.equalsIgnoreCase("alimentação") || tipoLoja.equalsIgnoreCase("Alimentaçao") ) {
            for (int i = 0; i < lojas.length; i++) {
                if (lojas[i] != null && lojas[i] instanceof Alimentacao) {
                     
                    contador++;
                }
            }
        } else if (tipoLoja.equalsIgnoreCase("bijuteria")) {
            for (int i = 0; i < lojas.length; i++) {
                if (lojas[i] != null && lojas[i] instanceof Bijuteria) {
                    
                    contador++;
                }
            }
        } else if (tipoLoja.equalsIgnoreCase("Informática") || tipoLoja.equalsIgnoreCase("Informatica")) {
            for (int i = 0; i < lojas.length; i++) {
                if (lojas[i] != null && lojas[i] instanceof Informatica) {
                    
                    contador++;
                }
            }
        } else if (tipoLoja.equalsIgnoreCase("Vestuário")|| tipoLoja.equalsIgnoreCase("Vestuario")) {
            for (int i = 0; i < lojas.length; i++) {
                if (lojas[i] != null && lojas[i] instanceof Vestuario) {
                    
                    contador++;
                }
            }
        }
        if (contador == 0) {
            return -1;
        }
    
        return contador;
    }
    
    public Informatica lojaSeguroMaisCaro(){
        int x = quantidadeLojasPorTipo("Informatica");
        if(x>0){       
         int posiçãoLojaSeguroMaisCaro = 0; 
        for(int i=0;i<lojas.length; i++){
            if(lojas[i] instanceof Informatica && ((Informatica)lojas[i]).getSeguroEletronicos() > ((Informatica)lojas[posiçãoLojaSeguroMaisCaro]).getSeguroEletronicos() ){
               posiçãoLojaSeguroMaisCaro = i;
            }
            
        }
       
        return ((Informatica)lojas[posiçãoLojaSeguroMaisCaro]);
    
       
    }else{
        return null;
    }
    }
    }
