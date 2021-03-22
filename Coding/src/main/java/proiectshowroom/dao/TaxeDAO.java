package proiectshowroom.dao;

import proiectshowroom.model.Taxe;
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
public class TaxeDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Taxe> list() {

        String sql = "SELECT * FROM TAXE";

        List<Taxe> listTaxe = jdbcTemplate.query(sql,
                BeanPropertyRowMapper.newInstance(Taxe.class));

        return listTaxe;
    }

    public void save(Taxe taxa) {
        SimpleJdbcInsert insertTaxa = new SimpleJdbcInsert(jdbcTemplate);
        insertTaxa.withTableName("Taxe").usingColumns("id_taxa","Nume_taxa","Pret","Clasa");
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(taxa);
        insertTaxa.execute(param);
    }

    public Taxe get(Integer id_taxa) {
        String sql = "SELECT * FROM TAXE WHERE id_taxa = ?";
        Object[] args = {id_taxa};
        Taxe taxa = jdbcTemplate.queryForObject(sql, args,
                BeanPropertyRowMapper.newInstance(Taxe.class));
        return taxa;
    }

    public void update(Taxe taxa) {
        String sql = "UPDATE TAXE SET id_taxa=:id_taxa,Nume_taxa=:Nume_taxa,Pret=:Pret,Clasa=:Clasa WHERE id_taxa=:id_taxa";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(taxa);

        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
        template.update(sql,param);
    }

    public void delete(Integer id_taxa) {
        String sql = "DELETE FROM TAXE WHERE id_taxa = ?";
        jdbcTemplate.update(sql,id_taxa);
    }

}
