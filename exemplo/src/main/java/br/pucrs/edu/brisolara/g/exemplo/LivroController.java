package br.pucrs.edu.brisolara.g.exemplo;

import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import org.apache.tomcat.util.json.JSONParser;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/biblioteca")
public class LivroController {
    private ArrayList<Livro> livros;

    public LivroController() {
        this.livros = new ArrayList<Livro>();
        this.livros.add(new Livro(1, "livro1", 2020, "autor1"));
        this.livros.add(new Livro(2, "livro2", 2021, "autor2"));
        this.livros.add(new Livro(3, "livro3", 2022, "autor3"));
        this.livros.add(new Livro(4, "livro4", 2023, "autor4"));
        this.livros.add(new Livro(5, "livro5", 2024, "autor5"));
        this.livros.add(new Livro(6, "livro6", 2025, "autor6"));
    }

    @GetMapping("/livros")
    public ArrayList<Livro> getLivros() {
        return this.livros;
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


 @GetMapping("/autores")
 public ArrayList<String> getAutores() {
    ArrayList<String> autores = new ArrayList<String>();

    for (Livro livro : this.livros) {
        autores.add(livro.getAuthor());
    }
    return autores;
 }


 @GetMapping("/livrosautor/{autor}")
    public List<Livro> getLivrosDoAutorPath(@PathVariable(value="autor") String autor) {
    return livros.stream()
    .filter(livro->livro.getAuthor().equals(autor))
    .toList();
}

@GetMapping("/livrosautor")
    public List<Livro> getLivrosDoAutorQuery(@RequestParam(value = "autor") String autor) {
    return livros.stream()
    .filter(livro->livro.getAuthor().equals(autor))
    .toList();
}

@PostMapping("/novolivro")
    public boolean cadastraLivroNovo(@RequestBody final Livro livro) {
    livros.add(livro);
    return true;
}
 


}
