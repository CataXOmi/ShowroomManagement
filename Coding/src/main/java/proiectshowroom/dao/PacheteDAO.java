package proiectshowroom.dao;

import proiectshowroom.model.Pachete;
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
public class PacheteDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Pachete> list() {

        String sql = "SELECT * FROM PACHETE";

        List<Pachete> listPachete = jdbcTemplate.query(sql,
                BeanPropertyRowMapper.newInstance(Pachete.class));

        return listPachete;
    }

    public void save(Pachete pachet) {
        SimpleJdbcInsert insertPachet = new SimpleJdbcInsert(jdbcTemplate);
        insertPachet.withTableName("Pachete").usingColumns("id_dotare","id_masina","Numar_pachet","Pachet_continut");
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(pachet);
        insertPachet.execute(param);
    }

    public Pachete get(Integer id_dotare, Integer id_masina) {
        String sql = "SELECT * FROM PACHETE WHERE id_dotare = ? and id_masina = ?";
        Object[] args = {id_dotare, id_masina};
        Pachete pachet = jdbcTemplate.queryForObject(sql, args,
                BeanPropertyRowMapper.newInstance(Pachete.class));
        return pachet;
    }

    public void update(Pachete pachet, Integer id_dotare_anterioara, Integer id_masina_anterioara) {
        String sql = "UPDATE PACHETE SET id_dotare=:id_dotare,id_masina=:id_masina,Numar_pachet=:Numar_pachet,Pachet_continut=:Pachet_continut WHERE id_taxa=" + id_dotare_anterioara + " and id_masina=" + id_masina_anterioara;
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(pachet);

        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
        template.update(sql,param);
    }

    public void delete(Integer id_dotare, Integer id_masina) {
        String sql = "DELETE FROM PACHETE WHERE id_dotare = ? and id_masina = ?";
        jdbcTemplate.update(sql,id_dotare,id_masina);
    }
}
