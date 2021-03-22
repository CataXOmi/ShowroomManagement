package proiectshowroom.model;

public class Facturi {
    private Integer id_taxa;
    private Integer id_masina;
    private Integer Numar_factura;
    private Double Suma;

    public Facturi() {

    }

    public Facturi(Integer id_taxa, Integer id_masina, Integer Numar_factura, Double Suma) {
        this.id_taxa = id_taxa;
        this.id_masina = id_masina;
        this.Numar_factura = Numar_factura;
        this.Suma = Suma;
    }

    public Integer getId_taxa() {
        return id_taxa;
    }

    public void setId_taxa(Integer id_taxa) {
        this.id_taxa = id_taxa;
    }

    public Integer getId_masina() {
        return id_masina;
    }

    public void setId_masina(Integer id_masina) {
        this.id_masina = id_masina;
    }

    public Integer getNumar_factura() {
        return Numar_factura;
    }

    public void setNumar_factura(Integer numar_factura) {
        Numar_factura = numar_factura;
    }

    public Double getSuma() {
        return Suma;
    }

    public void setSuma(Double suma) {
        Suma = suma;
    }
}
