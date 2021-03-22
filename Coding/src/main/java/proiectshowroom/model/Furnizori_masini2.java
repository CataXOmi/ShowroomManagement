package proiectshowroom.model;

public class Furnizori_masini2 {

    private String Denumire;
    private Integer Numar_masini;
    private Integer Media_preturilor;
    private Integer Media_kilometrilor;

    public Furnizori_masini2() {

    }

    public Furnizori_masini2(String Denumire, Integer Numar_masini, Integer Media_preturilor, Integer Media_kilometrilor) {
        this.Denumire = Denumire;
        this.Numar_masini = Numar_masini;
        this.Media_preturilor = Media_preturilor;
        this.Media_kilometrilor = Media_kilometrilor;
    }

    public String getDenumire() {
        return Denumire;
    }

    public void setDenumire(String denumire) {
        Denumire = denumire;
    }

    public Integer getNumar_masini() {
        return Numar_masini;
    }

    public void setNumar_masini(Integer numar_masini) {
        Numar_masini = numar_masini;
    }

    public Integer getMedia_preturilor() {
        return Media_preturilor;
    }

    public void setMedia_preturilor(Integer media_preturilor) {
        Media_preturilor = media_preturilor;
    }

    public Integer getMedia_kilometrilor() {
        return Media_kilometrilor;
    }

    public void setMedia_kilometrilor(Integer media_kilometrilor) {
        Media_kilometrilor = media_kilometrilor;
    }
}
