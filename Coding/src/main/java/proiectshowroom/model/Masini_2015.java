package proiectshowroom.model;

public class Masini_2015 {

    private Integer id_masina;
    private String Model_masina;
    private Integer An_fabricatie;
    private Integer id_dealer;
    private String Nume;
    private String Prenume;
    private Integer id_showroom;
    private String Denumire;
    private String Ora_deschidere;
    private String Ora_inchidere;
    private String Oras;

    public Masini_2015(){

    }

    public Masini_2015(Integer id_masina, String Model_masina, Integer An_fabricatie, Integer id_dealer, String Nume, String Prenume, Integer id_showroom, String Denumire, String Ora_deschidere, String Ora_inchidere, String Oras) {
        this.id_masina = id_masina;
        this.Model_masina = Model_masina;
        this.An_fabricatie = An_fabricatie;
        this.id_dealer = id_dealer;
        this.Nume = Nume;
        this.Prenume = Prenume;
        this.id_showroom = id_showroom;
        this.Denumire = Denumire;
        this.Ora_deschidere = Ora_deschidere;
        this.Ora_inchidere = Ora_inchidere;
        this.Oras = Oras;
    }

    public Integer getId_masina() {
        return id_masina;
    }

    public void setId_masina(Integer id_masina) {
        this.id_masina = id_masina;
    }

    public String getModel_masina() {
        return Model_masina;
    }

    public void setModel_masina(String model_masina) {
        Model_masina = model_masina;
    }

    public Integer getAn_fabricatie() {
        return An_fabricatie;
    }

    public void setAn_fabricatie(Integer an_fabricatie) {
        An_fabricatie = an_fabricatie;
    }

    public Integer getId_dealer() {
        return id_dealer;
    }

    public void setId_dealer(Integer id_dealer) {
        this.id_dealer = id_dealer;
    }

    public String getNume() {
        return Nume;
    }

    public void setNume(String nume) {
        Nume = nume;
    }

    public String getPrenume() {
        return Prenume;
    }

    public void setPrenume(String prenume) {
        Prenume = prenume;
    }

    public Integer getId_showroom() {
        return id_showroom;
    }

    public void setId_showroom(Integer id_showroom) {
        this.id_showroom = id_showroom;
    }

    public String getDenumire() {
        return Denumire;
    }

    public void setDenumire(String denumire) {
        Denumire = denumire;
    }

    public String getOra_deschidere() {
        return Ora_deschidere;
    }

    public void setOra_deschidere(String ora_deschidere) {
        Ora_deschidere = ora_deschidere;
    }

    public String getOra_inchidere() {
        return Ora_inchidere;
    }

    public void setOra_inchidere(String ora_inchidere) {
        Ora_inchidere = ora_inchidere;
    }

    public String getOras() {
        return Oras;
    }

    public void setOras(String oras) {
        Oras = oras;
    }
}
