package proiectshowroom.model;

public class Dealeri {
    private Integer id_dealer;
    private String Nume;
    private String Prenume;
    private String Telefon;
    private String Semnatura;
    private String Email;
    private String Domiciliu;
    private Integer id_showroom;

    public Dealeri() {

    }

    public Dealeri(Integer id_dealer, String Nume, String Prenume, String Telefon, String Semnatura, String Email, String Domiciliu, Integer id_showroom) {
        this.id_dealer = id_dealer;
        this.Nume = Nume;
        this.Prenume = Prenume;
        this.Telefon = Telefon;
        this.Semnatura = Semnatura;
        this.Email = Email;
        this.Domiciliu = Domiciliu;
        this.id_showroom = id_showroom;
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

    public String getTelefon() {
        return Telefon;
    }

    public void setTelefon(String telefon) {
        Telefon = telefon;
    }

    public String getSemnatura() {
        return Semnatura;
    }

    public void setSemnatura(String semnatura) {
        Semnatura = semnatura;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getDomiciliu() {
        return Domiciliu;
    }

    public void setDomiciliu(String domiciliu) {
        Domiciliu = domiciliu;
    }

    public Integer getId_showroom() {
        return id_showroom;
    }

    public void setId_showroom(Integer id_showroom) {
        this.id_showroom = id_showroom;
    }
}
