public class Data {
    private int dia;
    private int mes;
    private int ano;
  
    public Data(int dia,int mes,int ano){
        
        this.ano = ano;
        int x = 0;
        if(mes<13 && mes>0){
            this.mes = mes;
            x += 1;
        }

        //VALIDAÇÃO DIAS DOS MESES:
        int z = 0;
        if(mes==2){
            if(verificaAnoBissexto()){
            if(dia<=29){
                this.dia = dia;
                z += 1;
            }
            }else{
                if(dia<=28){
                    this.dia = dia;
                    z += 1;
                }
            }
        }
        if(mes==4 || mes==6 || mes==9 || mes==11){
            if(dia<=30){
                this.dia = dia;
                z += 1;
            }
        }else{
            if(dia<=31){
                this.dia = dia;
                z += 1;
            }
        } //----------------------
        

        if(z==0 || x==0){
            System.out.println("Erro! Data inválida!");
            ano = 2000;
            mes = 1;
            dia = 1;
        }

    } 
    
    public boolean verificaAnoBissexto(){
        
        if((ano%4 == 0 && ano%100 != 0) || (ano%4 == 0 && ano%100 == 0 && ano%400==0) ){
            return true;
        }else{
            return false;
        }
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    @Override
    public String toString(){
        return "Data: " + dia + '/' + mes + '/' + ano ;
    }
    
}
