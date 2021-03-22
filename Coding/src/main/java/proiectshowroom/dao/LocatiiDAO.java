package proiectshowroom.dao;

import proiectshowroom.model.Locatii;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class LocatiiDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Locatii> list() {

        String sql = "SELECT * FROM LOCATII";

        List<Locatii> listLocatii = jdbcTemplate.query(sql,
                BeanPropertyRowMapper.newInstance(Locatii.class));

        return listLocatii;
    }

    public void save(Locatii locatie) {
        SimpleJdbcInsert insertLocatie = new SimpleJdbcInsert(jdbcTemplate);
        insertLocatie.withTableName("Locatii").usingColumns("id_locatie","Adresa","Cod_postal","Oras","id_tara");
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(locatie);
        insertLocatie.execute(param);
    }

    public Locatii get(Integer id_locatie) {
        String sql = "SELECT * FROM LOCATII WHERE id_locatie = ?";
        Object[] args = {id_locatie};
        Locatii locatie = jdbcTemplate.queryForObject(sql, args,
                BeanPropertyRowMapper.newInstance(Locatii.class));
        return locatie;
    }

    public void update(Locatii locatie) {
        String sql = "UPDATE LOCATII SET id_locatie=:id_locatie,Adresa=:Adresa,Cod_postal=:Cod_postal,Oras=:Oras,id_tara=:id_tara WHERE id_locatie=:id_locatie";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(locatie);

        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
        template.update(sql,param);
    }

    public void delete(Integer id_locatie) {
        String sql = "DELETE FROM LOCATII WHERE id_locatie = ?";
        jdbcTemplate.update(sql,id_locatie);
    }

}
