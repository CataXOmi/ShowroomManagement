package proiectshowroom.dao;

import proiectshowroom.model.Furnizori;
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
public class FurnizoriDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Furnizori> list() {

        String sql = "SELECT * FROM FURNIZORI";

        List<Furnizori> listFurnizori = jdbcTemplate.query(sql,
                BeanPropertyRowMapper.newInstance(Furnizori.class));

        return listFurnizori;
    }

    public void save(Furnizori furnizor) {
        SimpleJdbcInsert insertFurnizor = new SimpleJdbcInsert(jdbcTemplate);
        insertFurnizor.withTableName("Furnizori").usingColumns("id_furnizor","Denumire","Adresa","Oras","Cod_postal","Stampila");
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(furnizor);
        insertFurnizor.execute(param);
    }

    public Furnizori get(Integer id_furnizor) {
        String sql = "SELECT * FROM FURNIZORI WHERE id_furnizor = ?";
        Object[] args = {id_furnizor};
        Furnizori furnizor = jdbcTemplate.queryForObject(sql, args,
                BeanPropertyRowMapper.newInstance(Furnizori.class));
        return furnizor;
    }

    public void update(Furnizori furnizor) {
        String sql = "UPDATE FURNIZORI SET id_furnizor=:id_furnizor,Denumire=:Denumire,Adresa=:Adresa,Oras=:Oras,Cod_postal=:Cod_postal,Stampila=:Stampila WHERE id_furnizor=:id_furnizor";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(furnizor);

        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
        template.update(sql,param);
    }

    public void delete(Integer id_furnizor) {
        String sql = "DELETE FROM FURNIZORI WHERE id_furnizor = ?";
        jdbcTemplate.update(sql,id_furnizor);
    }

}
