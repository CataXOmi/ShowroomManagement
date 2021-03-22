package proiectshowroom.model;

public class Showroomuri {
    private Integer id_showroom;
    private String Denumire;
    private String Ora_deschidere;
    private String Ora_inchidere;
    private String Contact;
    private String Email;
    private String IBAN;
    private String CIF;
    private String Nr_Reg_Com;
    private String Stampila;
    private Integer id_locatie;

    public Showroomuri() {

    }

    public Showroomuri(Integer id_showroom, String Denumire, String Ora_deschidere, String Ora_inchidere, String Contact, String Email, String IBAN, String CIF, String Nr_Reg_Com, String Stampila, Integer id_locatie) {
        this.id_showroom = id_showroom;
        this.Denumire = Denumire;
        this.Ora_deschidere = Ora_deschidere;
        this.Ora_inchidere = Ora_inchidere;
        this.Contact = Contact;
        this.Email = Email;
        this.IBAN = IBAN;
        this.CIF = CIF;
        this.Nr_Reg_Com = Nr_Reg_Com;
        this.Stampila = Stampila;
        this.id_locatie = id_locatie;
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

    public String getContact() {
        return Contact;
    }

    public void setContact(String contact) {
        Contact = contact;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getIBAN() {
        return IBAN;
    }

    public void setIBAN(String IBAN) {
        this.IBAN = IBAN;
    }

    public String getCIF() {
        return CIF;
    }

    public void setCIF(String CIF) {
        this.CIF = CIF;
    }

    public String getNr_Reg_Com() {
        return Nr_Reg_Com;
    }

    public void setNr_Reg_Com(String nr_Reg_Com) {
        Nr_Reg_Com = nr_Reg_Com;
    }

    public String getStampila() {
        return Stampila;
    }

    public void setStampila(String stampila) {
        Stampila = stampila;
    }

    public Integer getId_locatie() {
        return id_locatie;
    }

    public void setId_locatie(Integer id_locatie) {
        this.id_locatie = id_locatie;
    }
}
