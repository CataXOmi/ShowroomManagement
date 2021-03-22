package proiectshowroom.model;

public class Tari {
    private Integer id_tara;
    private String Nume_tara;

    public Tari() {

    }

    public Tari(Integer id_tara, String Nume_tara) {
        this.id_tara = id_tara;
        this.Nume_tara = Nume_tara;
    }

    public Integer getId_tara() {
        return id_tara;
    }

    public void setId_tara(Integer id_tara) {
        this.id_tara = id_tara;
    }

    public String getNume_tara() {
        return Nume_tara;
    }

    public void setNume_tara(String nume_tara) {
        Nume_tara = nume_tara;
    }
}
