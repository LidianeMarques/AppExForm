package com.example.appexform;

import java.io.Serializable;
import java.util.List;

/**
 * Programação para Dispositivos Móveis I.
 * INTERFACE DO USUÁRIO
 * Crie um form para receber dados de um pessoa com as seguintes informações abaixo.
 * <p>
 * Nome:
 * idade
 * Sexo:
 * Estilo musicais favorito: Rock, Sertanejo, Pagode, Forró, Outro.
 * <p>
 * NOTA: para o sexo, utilize RadioButton e para o estilo musical utilize Checkbox.
 * <p>
 * Por fim, apresente os dados inseridos em um TextView.
 */

public class Pessoa implements Serializable {
    private String nome;
    private int idade;
    private String sexo;
    private List<String> estiloMusical;


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public List<String> getEstiloMusical() {
        return estiloMusical;
    }

    public List<String> setEstiloMusical(List<String> estiloMusical) {
        this.estiloMusical = estiloMusical;
        return estiloMusical;
    }

    @Override
    public String toString() {
        return "Seja bem-vindo, " + nome + "." +
                "\n\nSua idade é de : " + idade + "," +
                "\nSeu gênero é: " + sexo + "," +
                "\nSeu gosto musical: " + estiloMusical.toString().replace("[", "").replace("]", "") + ".";
    }
}
