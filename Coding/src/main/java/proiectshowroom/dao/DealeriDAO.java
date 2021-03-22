package proiectshowroom.dao;

import proiectshowroom.model.Dealeri;
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
public class DealeriDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Dealeri> list() {

        String sql = "SELECT * FROM DEALERI";

        List<Dealeri> listDealeri = jdbcTemplate.query(sql,
                BeanPropertyRowMapper.newInstance(Dealeri.class));

        return listDealeri;
    }

    public void save(Dealeri dealer) {
        SimpleJdbcInsert insertDealer = new SimpleJdbcInsert(jdbcTemplate);
        insertDealer.withTableName("Dealeri").usingColumns("id_dealer","Nume","Prenume","Telefon","Semnatura","Email","Domiciliu","id_showroom");
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(dealer);
        insertDealer.execute(param);
    }

    public Dealeri get(Integer id_dealer) {
        String sql = "SELECT * FROM DEALERI WHERE id_dealer = ?";
        Object[] args = {id_dealer};
        Dealeri dealer = jdbcTemplate.queryForObject(sql, args,
                BeanPropertyRowMapper.newInstance(Dealeri.class));
        return dealer;
    }

    public void update(Dealeri dealer) {
        String sql = "UPDATE DEALERI SET id_dealer=:id_dealer,Nume=:Nume,Prenume=:Prenume,Telefon=:Telefon,Semnatura=:Semnatura,Email=:Email,Domiciliu=:Domiciliu,id_showroom=:id_showroom WHERE id_dealer=:id_dealer";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(dealer);

        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
        template.update(sql,param);
    }

    public void delete(Integer id_dealer) {
        String sql = "DELETE FROM DEALERI WHERE id_dealer = ?";
        jdbcTemplate.update(sql,id_dealer);
    }

}
