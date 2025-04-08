package br.pucrs.edu.brisolara.g.exemplo;

import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

import org.apache.tomcat.util.json.JSONParser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/livros")
public class LivroController {
    private ArrayList<Livro> livros;

    public LivroController() {
        this.livros = new ArrayList<Livro>();
        this.livros.add(new Livro(1, "livro1", 2020));
        this.livros.add(new Livro(2, "livro2", 2021));
        this.livros.add(new Livro(3, "livro3", 2022));
        this.livros.add(new Livro(4, "livro4", 2023));
        this.livros.add(new Livro(5, "livro5", 2024));
        this.livros.add(new Livro(6, "livro6", 2025));
    }

    @GetMapping("")
    public ArrayList<Livro> getLivros() {
        return this.livros;
    }
    

 @GetMapping("/")
 public String getMensagemInicial() {
    return "Aplicacao Spring-Boot funcionando!";
 }

 @GetMapping("/anos")
 public ArrayList<Integer> getAnos() {
    ArrayList<Integer> anos = new ArrayList<Integer>();

    for (Livro livro : this.livros) {
        anos.add(livro.getAno());
    }
    return anos;
 }

 @GetMapping("/titulos")
 public ArrayList<String> getTitulos() {
    ArrayList<String> titulos = new ArrayList<String>();

    for (Livro livro : this.livros) {
        titulos.add(livro.getTitulo());
    }
    return titulos;
 }

 


}
