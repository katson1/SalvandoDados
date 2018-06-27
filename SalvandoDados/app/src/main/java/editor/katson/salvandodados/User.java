package editor.katson.salvandodados;

/**
 * Created by Xoi on 29/06/2017.
 */

public class User {

    private String nome;
    private String cpf;

    public User(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;

    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
