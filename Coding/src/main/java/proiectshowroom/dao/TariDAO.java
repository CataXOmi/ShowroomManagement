package proiectshowroom.dao;

import proiectshowroom.model.Tari;
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
public class TariDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Tari> list() {

        String sql = "SELECT * FROM TARI";

        List<Tari> listTari = jdbcTemplate.query(sql,
                BeanPropertyRowMapper.newInstance(Tari.class));

        return listTari;
    }

    public void save(Tari tara) {
        SimpleJdbcInsert insertTara = new SimpleJdbcInsert(jdbcTemplate);
        insertTara.withTableName("Tari").usingColumns("id_tara","Nume_tara");
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(tara);
        insertTara.execute(param);
    }

    public Tari get(Integer id_tara) {
        String sql = "SELECT * FROM TARI WHERE id_tara = ?";
        Object[] args = {id_tara};
        Tari tara = jdbcTemplate.queryForObject(sql, args,
                BeanPropertyRowMapper.newInstance(Tari.class));
        return tara;
    }

    public void update(Tari tara) {
        String sql = "UPDATE TARI SET id_tara=:id_tara,Nume_tara=:Nume_tara WHERE id_tara=:id_tara";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(tara);

        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
        template.update(sql,param);
    }

    public void delete(Integer id_tara) {
        String sql = "DELETE FROM TARI WHERE id_tara = ?";
        jdbcTemplate.update(sql,id_tara);
    }

}
