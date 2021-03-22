package proiectshowroom.dao;

import proiectshowroom.model.Dotari;
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
public class DotariDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Dotari> list() {

        String sql = "SELECT * FROM DOTARI";
        List<Dotari> listDotari = jdbcTemplate.query(sql,
                BeanPropertyRowMapper.newInstance(Dotari.class));

        return listDotari;
    }

    public void save(Dotari dotare) {
        SimpleJdbcInsert insertDotare = new SimpleJdbcInsert(jdbcTemplate);
        insertDotare.withTableName("Dotari").usingColumns("id_dotare","Nume_dotare","Optional");
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(dotare);
        insertDotare.execute(param);
    }

    public Dotari get(Integer id_dotare) {
        String sql = "SELECT * FROM DOTARI WHERE id_dotare = ?";
        Object[] args = {id_dotare};
        Dotari dotare = jdbcTemplate.queryForObject(sql, args,
                BeanPropertyRowMapper.newInstance(Dotari.class));

        return dotare;
    }

    public void update(Dotari dotare) {
        String sql = "UPDATE DOTARI SET id_dotare=:id_dotare,Nume_dotare=:Nume_dotare,Optional=:Optional WHERE id_dotare=:id_dotare";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(dotare);

        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
        template.update(sql,param);
    }

    public void delete(Integer id_dotare) {
        String sql = "DELETE FROM DOTARI WHERE id_dotare = ?";
        jdbcTemplate.update(sql,id_dotare);
    }

}
