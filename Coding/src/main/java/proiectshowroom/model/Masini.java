package proiectshowroom.model;

public class Masini {
    private Integer id_masina;
    private String Model_Masina;
    private Integer Cai_putere;
    private Integer An_fabricatie;
    private String Combustibil;
    private Integer Kilometraj;
    private String Norma_poluare;
    private String Culoare;
    private String Tip_volan;
    private String Cutie_viteze;
    private String Transmisie;
    private Integer Numar_portiere;
    private Double Pret;
    private Integer id_cumparator;
    private Integer id_furnizor;
    private Integer id_dealer;

    public Masini() {

    }

    public Masini(Integer id_masina, String Model_Masina, Integer Cai_putere, Integer An_fabricatie, String Combustibil, Integer Kilometraj, String Norma_poluare, String Culoare, String Tip_volan, String Cutie_viteze, String Transmisie, Integer Numar_portiere, Double Pret, Integer id_cumparator, Integer id_furnizor, Integer id_dealer) {
        this.id_masina = id_masina;
        this.Model_Masina = Model_Masina;
        this.Cai_putere = Cai_putere;
        this.An_fabricatie = An_fabricatie;
        this.Combustibil = Combustibil;
        this.Kilometraj = Kilometraj;
        this.Norma_poluare = Norma_poluare;
        this.Culoare = Culoare;
        this.Tip_volan = Tip_volan;
        this.Cutie_viteze = Cutie_viteze;
        this.Transmisie = Transmisie;
        this.Numar_portiere = Numar_portiere;
        this.Pret = Pret;
        this.id_cumparator = id_cumparator;
        this.id_furnizor = id_furnizor;
        this.id_dealer = id_dealer;
    }

    public Integer getId_masina() {
        return id_masina;
    }

    public void setId_masina(Integer id_masina) {
        this.id_masina = id_masina;
    }

    public String getModel_Masina() {
        return Model_Masina;
    }

    public void setModel_Masina(String model_Masina) {
        Model_Masina = model_Masina;
    }

    public Integer getCai_putere() {
        return Cai_putere;
    }

    public void setCai_putere(Integer cai_putere) {
        Cai_putere = cai_putere;
    }

    public Integer getAn_fabricatie() {
        return An_fabricatie;
    }

    public void setAn_fabricatie(Integer an_fabricatie) {
        An_fabricatie = an_fabricatie;
    }

    public String getCombustibil() {
        return Combustibil;
    }

    public void setCombustibil(String combustibil) {
        Combustibil = combustibil;
    }

    public Integer getKilometraj() {
        return Kilometraj;
    }

    public void setKilometraj(Integer kilometraj) {
        Kilometraj = kilometraj;
    }

    public String getNorma_poluare() {
        return Norma_poluare;
    }

    public void setNorma_poluare(String norma_poluare) {
        Norma_poluare = norma_poluare;
    }

    public String getCuloare() {
        return Culoare;
    }

    public void setCuloare(String culoare) {
        Culoare = culoare;
    }

    public String getTip_volan() {
        return Tip_volan;
    }

    public void setTip_volan(String tip_volan) {
        Tip_volan = tip_volan;
    }

    public String getCutie_viteze() {
        return Cutie_viteze;
    }

    public void setCutie_viteze(String cutie_viteze) {
        Cutie_viteze = cutie_viteze;
    }

    public String getTransmisie() {
        return Transmisie;
    }

    public void setTransmisie(String transmisie) {
        Transmisie = transmisie;
    }

    public Integer getNumar_portiere() { return Numar_portiere; }

    public void setNumar_portiere(Integer numar_portiere) {
        Numar_portiere = numar_portiere;
    }

    public Double getPret() {
        return Pret;
    }

    public void setPret(Double pret) {
        Pret = pret;
    }

    public Integer getId_cumparator() {
        return id_cumparator;
    }

    public void setId_cumparator(Integer id_cumparator) {
        this.id_cumparator = id_cumparator;
    }

    public Integer getId_furnizor() {
        return id_furnizor;
    }

    public void setId_furnizor(Integer id_furnizor) {
        this.id_furnizor = id_furnizor;
    }

    public Integer getId_dealer() {
        return id_dealer;
    }

    public void setId_dealer(Integer id_dealer) {
        this.id_dealer = id_dealer;
    }
}
