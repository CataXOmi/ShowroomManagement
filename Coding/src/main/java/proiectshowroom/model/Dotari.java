package proiectshowroom.model;

public class Dotari {
    private Integer id_dotare;
    private String Nume_dotare;
    private String Optional;

    public Dotari() {

    }

    public Dotari(Integer id_dotare, String Nume_dotare, String Optional){
        this.id_dotare = id_dotare;
        this.Nume_dotare = Nume_dotare;
        this.Optional = Optional;
    }

    public Integer getId_dotare() {
        return id_dotare;
    }

    public void setId_dotare(Integer id_dotare) {
        this.id_dotare = id_dotare;
    }

    public String getNume_dotare() {
        return Nume_dotare;
    }

    public void setNume_dotare(String nume_dotare) {
        Nume_dotare = nume_dotare;
    }

    public String getOptional() {
        return Optional;
    }

    public void setOptional(String optional) {
        Optional = optional;
    }
}
