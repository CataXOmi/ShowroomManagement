package proiectshowroom.model;

public class Locatii {
    private Integer id_locatie;
    private String Adresa;
    private String Cod_postal;
    private String Oras;
    private Integer id_tara;

    public Locatii() {

    }

    public Locatii(Integer id_locatie, String Adresa, String Cod_postal, String Oras, Integer id_tara) {
        this.id_locatie = id_locatie;
        this.Adresa = Adresa;
        this.Cod_postal = Cod_postal;
        this.Oras = Oras;
        this.id_tara = id_tara;
    }

    public Integer getId_locatie() {
        return id_locatie;
    }

    public void setId_locatie(Integer id_locatie) {
        this.id_locatie = id_locatie;
    }

    public String getAdresa() {
        return Adresa;
    }

    public void setAdresa(String adresa) {
        Adresa = adresa;
    }

    public String getCod_postal() {
        return Cod_postal;
    }

    public void setCod_postal(String cod_postal) {
        Cod_postal = cod_postal;
    }

    public String getOras() {
        return Oras;
    }

    public void setOras(String oras) {
        Oras = oras;
    }

    public Integer getId_tara() {
        return id_tara;
    }

    public void setId_tara(Integer id_tara) {
        this.id_tara = id_tara;
    }
}
