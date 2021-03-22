package proiectshowroom.model;

public class Taxe {
    private Integer id_taxa;
    private String Nume_taxa;
    private Double Pret;
    private String Clasa;

    public Taxe() {

    }

    public Taxe(Integer id_taxa, String Nume_taxa, Double Pret, String Clasa) {
        this.id_taxa = id_taxa;
        this.Nume_taxa = Nume_taxa;
        this.Pret = Pret;
        this.Clasa = Clasa;
    }

    public Integer getId_taxa() {
        return id_taxa;
    }

    public void setId_taxa(Integer id_taxa) {
        this.id_taxa = id_taxa;
    }

    public String getNume_taxa() {
        return Nume_taxa;
    }

    public void setNume_taxa(String nume_taxa) {
        Nume_taxa = nume_taxa;
    }

    public Double getPret() {
        return Pret;
    }

    public void setPret(Double pret) {
        Pret = pret;
    }

    public String getClasa() {
        return Clasa;
    }

    public void setClasa(String clasa) {
        Clasa = clasa;
    }
}
