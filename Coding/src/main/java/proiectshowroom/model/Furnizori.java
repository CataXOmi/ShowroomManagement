package proiectshowroom.model;

public class Furnizori {
    private Integer id_furnizor;
    private String Denumire;
    private String Adresa;
    private String Oras;
    private String Cod_postal;
    private String Stampila;

    public Furnizori() {

    }

    public Furnizori(Integer id_furnizor, String Denumire, String Adresa, String Oras, String Cod_postal, String Stampila) {
        this.id_furnizor = id_furnizor;
        this.Denumire = Denumire;
        this.Adresa = Adresa;
        this.Oras = Oras;
        this.Cod_postal = Cod_postal;
        this.Stampila = Stampila;
    }

    public Integer getId_furnizor() {
        return id_furnizor;
    }

    public void setId_furnizor(Integer id_furnizor) {
        this.id_furnizor = id_furnizor;
    }

    public String getDenumire() {
        return Denumire;
    }

    public void setDenumire(String denumire) {
        Denumire = denumire;
    }

    public String getAdresa() {
        return Adresa;
    }

    public void setAdresa(String adresa) {
        Adresa = adresa;
    }

    public String getOras() {
        return Oras;
    }

    public void setOras(String oras) {
        Oras = oras;
    }

    public String getCod_postal() {
        return Cod_postal;
    }

    public void setCod_postal(String cod_postal) {
        Cod_postal = cod_postal;
    }

    public String getStampila() {
        return Stampila;
    }

    public void setStampila(String stampila) {
        Stampila = stampila;
    }
}
