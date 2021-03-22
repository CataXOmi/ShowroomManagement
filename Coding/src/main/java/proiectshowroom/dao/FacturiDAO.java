package proiectshowroom.dao;

import proiectshowroom.model.Facturi;
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
public class FacturiDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Facturi> list() {

        String sql = "SELECT * FROM FACTURI";

        List<Facturi> listFacturi = jdbcTemplate.query(sql,
                BeanPropertyRowMapper.newInstance(Facturi.class));

        return listFacturi;
    }

    public void save(Facturi factura) {
        SimpleJdbcInsert insertFactura = new SimpleJdbcInsert(jdbcTemplate);
        insertFactura.withTableName("Facturi").usingColumns("id_taxa","id_masina","Numar_factura","Suma");
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(factura);
        insertFactura.execute(param);
    }

    public Facturi get(Integer id_taxa, Integer id_masina) {
        String sql = "SELECT * FROM FACTURI WHERE id_taxa = ? and id_masina = ?";
        Object[] args = {id_taxa, id_masina};
        Facturi factura = jdbcTemplate.queryForObject(sql, args,
                BeanPropertyRowMapper.newInstance(Facturi.class));
        return factura;
    }

    public void update(Facturi factura, Integer id_taxa_anterioara, Integer id_masina_anterioara) {
        String sql = "UPDATE FACTURI SET id_taxa=:id_taxa,id_masina=:id_masina,Numar_factura=:Numar_factura,Suma=:Suma WHERE id_taxa=" + id_taxa_anterioara + " and id_masina=" + id_masina_anterioara;
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(factura);

        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
        template.update(sql,param);
    }

    public void delete(Integer id_taxa, Integer id_masina) {
        String sql = "DELETE FROM FACTURI WHERE id_taxa = ? and id_masina = ?";
        jdbcTemplate.update(sql,id_taxa,id_masina);
    }

}
