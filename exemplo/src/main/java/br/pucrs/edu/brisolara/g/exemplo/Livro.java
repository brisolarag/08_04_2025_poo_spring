package br.pucrs.edu.brisolara.g.exemplo;

public class Livro {
    private int id;
    public int getId() {return this.id;}

    private String titulo;
    public String getTitulo() {return this.titulo;}
    public void setTitulo(String titulo) {this.titulo = titulo;}

    private int ano;
    public int getAno() {return this.ano;}
    public void setAno(int ano) {this.ano = ano;}

    private String author;
    public String getAuthor() {return this.author;}
    public void setAuthor(String author) {this.author = author;}

    public Livro(int id, String titulo, int ano, String author) {
        this.id = id;
        this.titulo = titulo;
        this.ano = ano;
        this.author = author;
    }
}
