package com.Challengel.Literatura.objetos;

public class IdiomaCount {

    private String idioma;
    private long count;

    public IdiomaCount(String idioma, long count) {
        this.idioma = idioma;
        this.count = count;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }
}
