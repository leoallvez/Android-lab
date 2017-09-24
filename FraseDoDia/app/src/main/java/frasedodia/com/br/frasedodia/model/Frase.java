
package frasedodia.com.br.frasedodia.model;

public class Frase {

    private String autor;
    private String texto;

    public Frase(String texto, String autor) {
        this.texto = texto;
        this.autor = autor;
    }

    public String getAutor() {
        return autor;
    }

    public String getTexto() {
        return texto;
    }

}
