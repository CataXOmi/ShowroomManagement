package proiectshowroom.dao;

import proiectshowroom.model.Masini;
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
public class MasiniDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Masini> list() {

        String sql = "SELECT * FROM MASINI";

        List<Masini> listMasini = jdbcTemplate.query(sql,
                BeanPropertyRowMapper.newInstance(Masini.class));

        return listMasini;
    }

    public void save(Masini masina) {
        SimpleJdbcInsert insertMasina = new SimpleJdbcInsert(jdbcTemplate);
        insertMasina.withTableName("Masini").usingColumns("id_masina","Model_Masina","Cai_putere","An_fabricatie","Combustibil","Kilometraj","Norma_poluare","Culoare","Tip_volan","Cutie_viteze","Transmisie","Numar_portiere","Pret","id_cumparator","id_furnizor","id_dealer");
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(masina);
        insertMasina.execute(param);
    }

    public Masini get(Integer id_masina) {
        String sql = "SELECT * FROM MASINI WHERE id_masina = ?";
        Object[] args = {id_masina};
        Masini masina = jdbcTemplate.queryForObject(sql, args,
                BeanPropertyRowMapper.newInstance(Masini.class));
        return masina;
    }

    public void update(Masini masina) {
        String sql = "UPDATE MASINI SET id_masina=:id_masina,Model_Masina=:Model_Masina,Cai_putere=:Cai_putere,An_fabricatie=:An_fabricatie,Combustibil=:Combustibil,Kilometraj=:Kilometraj,Norma_poluare=:Norma_poluare,Culoare=:Culoare,Tip_volan=:Tip_volan,Cutie_viteze=:Cutie_viteze,Transmisie=:Transmisie,Numar_portiere=:Numar_portiere,Pret=:Pret,id_cumparator=:id_cumparator,id_furnizor=:id_furnizor,id_dealer=:id_dealer WHERE id_masina=:id_masina";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(masina);

        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
        template.update(sql,param);
    }

    public void delete(Integer id_masina) {
        String sql = "DELETE FROM MASINI WHERE id_masina = ?";
        jdbcTemplate.update(sql,id_masina);
    }

}
