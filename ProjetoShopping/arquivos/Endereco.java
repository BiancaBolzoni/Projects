import java.util.Scanner;

public class Endereco {
    private String nomeDaRua;
    private String cidade;
    private String estado;
    private String pais;
    private String cep;
    private String numero;
    private String complemento;
    public String getNomeDaRua() {
        return nomeDaRua;
    }
    public void setNomeDaRua(String nomeDaRua) {
        this.nomeDaRua = nomeDaRua;
    }
    public String getCidade() {
        return cidade;
    }
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }
    public String getPais() {
        return pais;
    }
    public void setPais(String pais) {
        this.pais = pais;
    }
    public String getCep() {
        return cep;
    }
    public void setCep(String cep) {
        this.cep = cep;
    }
    public String getNumero() {
        return numero;
    }
    public void setNumero(String numero) {
        this.numero = numero;
    }
    public String getComplemento() {
        return complemento;
    }
    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }
    Scanner leitorScanner = new Scanner(System.in);

    public Endereco(String nomeDaRua,String cidade,String estado,String pais,String cep,String numero,String complemento){
        this.cep = cep;
        this.cidade = cidade;
        this.complemento = complemento;
        this.estado = estado;
        this.nomeDaRua = nomeDaRua;
        this.numero = numero;
        this.pais = pais;
    }
    /*public Endereco(){
        
    }*/
    
    /*public void adicionarEndereco(){ 
        System.out.println("CEP:");
        this.cep = leitorScanner.nextLine();
        System.out.println("Rua:");
        this.nomeDaRua = leitorScanner.nextLine();
        System.out.println("Numero:");
        this.numero = leitorScanner.nextLine();
        System.out.println("Complemento:");
        this.complemento = leitorScanner.nextLine();
        System.out.println("Cidade:");
        this.cidade = leitorScanner.nextLine();
        System.out.println("Estado:");
        this.estado = leitorScanner.nextLine();
        System.out.println("País:");
        this.pais = leitorScanner.nextLine();
    }*/

    @Override
    public String toString(){
        return "Nome da Rua: " + nomeDaRua +
        "\n" + "Numero: " + numero + 
        "\n" + "Complemento: " + complemento +
        "\n" + "CEP: " + cep +
        "\n" + "Cidade: " + cidade +
        "\n" + "Estado:" + estado +
        "\n" + "Pais:" + pais;
    }
    
}
