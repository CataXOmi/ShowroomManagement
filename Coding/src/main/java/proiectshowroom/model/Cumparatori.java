package proiectshowroom.model;

public class Cumparatori {
    private Integer id_cumparator;
    private Integer Persoana_Fizica;
    private Integer Persoana_Juridica;
    private String Denumire;
    private String Semnatura;
    private String CNP;
    private String CI;
    private String Nr_Reg_Com;
    private String CUI;
    private String Adresa;
    private String Contact;
    private String Cod_postal;
    private String Email;
    private String Stampila;

    public Cumparatori() {

    }

    public Cumparatori(Integer id_cumparator, Integer Persoana_Fizica, Integer Persoana_Juridica, String Denumire, String Semnatura, String CNP, String CI, String Nr_Reg_Com, String CUI, String Adresa, String Contact, String Cod_postal, String Email, String Stampila) {
        this.id_cumparator = id_cumparator;
        this.Persoana_Fizica = Persoana_Fizica;
        this.Persoana_Juridica = Persoana_Juridica;
        this.Denumire = Denumire;
        this.Semnatura = Semnatura;
        this.CNP = CNP;
        this.CI = CI;
        this.Nr_Reg_Com = Nr_Reg_Com;
        this.CUI = CUI;
        this.Adresa = Adresa;
        this.Contact = Contact;
        this.Cod_postal = Cod_postal;
        this.Email = Email;
        this.Stampila = Stampila;
    }

    public Integer getId_cumparator() {
        return id_cumparator;
    }

    public Integer getPersoana_Fizica() {
        return Persoana_Fizica;
    }

    public Integer getPersoana_Juridica() {
        return Persoana_Juridica;
    }

    public String getDenumire() {
        return Denumire;
    }

    public String getSemnatura() {
        return Semnatura;
    }

    public String getCNP() {
        return CNP;
    }

    public String getCI() {
        return CI;
    }

    public String getNr_Reg_Com() {
        return Nr_Reg_Com;
    }

    public String getCUI() {
        return CUI;
    }

    public String getAdresa() {
        return Adresa;
    }

    public String getContact() {
        return Contact;
    }

    public String getCod_postal() {
        return Cod_postal;
    }

    public String getEmail() {
        return Email;
    }

    public String getStampila() {
        return Stampila;
    }

    public void setId_cumparator(Integer id_cumparator) {
        this.id_cumparator = id_cumparator;
    }

    public void setPersoana_Fizica(Integer persoana_Fizica) {
        Persoana_Fizica = persoana_Fizica;
    }

    public void setPersoana_Juridica(Integer persoana_Juridica) {
        Persoana_Juridica = persoana_Juridica;
    }

    public void setDenumire(String denumire) {
        Denumire = denumire;
    }

    public void setSemnatura(String semnatura) {
        Semnatura = semnatura;
    }

    public void setCNP(String CNP) {
        this.CNP = CNP;
    }

    public void setCI(String CI) {
        this.CI = CI;
    }

    public void setNr_Reg_Com(String nr_Reg_Com) {
        Nr_Reg_Com = nr_Reg_Com;
    }

    public void setCUI(String CUI) {
        this.CUI = CUI;
    }

    public void setAdresa(String adresa) {
        Adresa = adresa;
    }

    public void setContact(String contact) {
        Contact = contact;
    }

    public void setCod_postal(String cod_postal) {
        Cod_postal = cod_postal;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public void setStampila(String stampila) {
        Stampila = stampila;
    }
}
