package renan.carvalho.agendertransfer;

public class Poo {
    private String nome;
    private String email;
    private String enderecoCasa;
    private String enderecoTrabalho;
    private int telefone;
    private boolean sexo;
    private String senha;
    private String senhaConfirmacao;

    // Construtor
    public Poo() {
        this.nome = nome;
        this.email = email;
        this.enderecoCasa = enderecoCasa;
        this.enderecoTrabalho = enderecoTrabalho;
        this.telefone = telefone;

        this.senha = senha;
        this.senhaConfirmacao = senhaConfirmacao;
        this.sexo = sexo;

    }

    public void setNome(String nome){

        this.nome = nome;

    }
    public String getNome(){
        return nome;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public String getEmail(){
        return email;

    }
    public void setEnderecoCasa(String enderecoCasa){
        this.enderecoCasa = enderecoCasa;
    }
    public String getEnderecoCasa(){
        return enderecoCasa;
    }


    public String getEnderecoTrabalho() {
        return enderecoTrabalho;
    }
    public void setEnderecoTrabalho(String enderecoTrabalho) {
        this.enderecoTrabalho = enderecoTrabalho;
    }

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    public boolean isSexo() {
        return sexo;
    }

    public void setSexo(boolean sexo) {
        this.sexo = sexo;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getSenhaConfirmacao() {
        return senhaConfirmacao;
    }

    public void setSenhaConfirmacao(String senhaConfirmacao) {
        this.senhaConfirmacao = senhaConfirmacao;
    }



}
