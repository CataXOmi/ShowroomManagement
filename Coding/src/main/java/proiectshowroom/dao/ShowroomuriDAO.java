package proiectshowroom.dao;

import proiectshowroom.model.Showroomuri;
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
public class ShowroomuriDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Showroomuri> list() {

        String sql = "SELECT * FROM SHOWROOMURI";

        List<Showroomuri> listShowroomuri = jdbcTemplate.query(sql,
                BeanPropertyRowMapper.newInstance(Showroomuri.class));

        return listShowroomuri;
    }

    public void save(Showroomuri showroom) {
        SimpleJdbcInsert insertShowroom = new SimpleJdbcInsert(jdbcTemplate);
        insertShowroom.withTableName("Showroomuri").usingColumns("id_showroom","Denumire","Ora_deschidere","Ora_inchidere","Contact","Email","IBAN","CIF","Nr_Reg_Com","Stampila","id_locatie");
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(showroom);
        insertShowroom.execute(param);
    }

    public Showroomuri get(Integer id_showroom) {
        String sql = "SELECT * FROM SHOWROOMURI WHERE id_showroom = ?";
        Object[] args = {id_showroom};
        Showroomuri showroom = jdbcTemplate.queryForObject(sql, args,
                BeanPropertyRowMapper.newInstance(Showroomuri.class));
        return showroom;
    }

    public void update(Showroomuri showroom) {
        String sql = "UPDATE SHOWROOMURI SET id_showroom=:id_showroom,Denumire=:Denumire,Ora_deschidere=:Ora_deschidere,Ora_inchidere=:Ora_inchidere,Contact=:Contact,Email=:Email,IBAN=:IBAN,CIF=:CIF,Nr_Reg_Com=:Nr_Reg_Com,Stampila=:Stampila,id_locatie=:id_locatie WHERE id_showroom=:id_showroom";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(showroom);

        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
        template.update(sql,param);
    }

    public void delete(Integer id_showroom) {
        String sql = "DELETE FROM SHOWROOMURI WHERE id_showroom = ?";
        jdbcTemplate.update(sql,id_showroom);
    }

}
