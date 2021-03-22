package proiectshowroom.model;

public class Pachete {
    private Integer id_dotare;
    private Integer id_masina;
    private String Nume_pachet;
    private String Pachet_continut;

    public Pachete() {

    }

    public Pachete(Integer id_dotare, Integer id_masina, String Nume_pachet, String Pachet_continut) {
        this.id_dotare = id_dotare;
        this.id_masina = id_masina;
        this.Nume_pachet = Nume_pachet;
        this.Pachet_continut = Pachet_continut;
    }

    public Integer getId_dotare() {
        return id_dotare;
    }

    public void setId_dotare(Integer id_dotare) {
        this.id_dotare = id_dotare;
    }

    public Integer getId_masina() {
        return id_masina;
    }

    public void setId_masina(Integer id_masina) {
        this.id_masina = id_masina;
    }

    public String getNume_pachet() {
        return Nume_pachet;
    }

    public void setNume_pachet(String nume_pachet) {
        Nume_pachet = nume_pachet;
    }

    public String getPachet_continut() {
        return Pachet_continut;
    }

    public void setPachet_continut(String pachet_continut) {
        Pachet_continut = pachet_continut;
    }
}

