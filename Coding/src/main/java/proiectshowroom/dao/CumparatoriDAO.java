package proiectshowroom.dao;

import proiectshowroom.model.Cumparatori;
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
public class CumparatoriDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Cumparatori> list() {

        String sql = "SELECT * FROM CUMPARATORI";
        List<Cumparatori> listCumparatori = jdbcTemplate.query(sql,
                BeanPropertyRowMapper.newInstance(Cumparatori.class));

        return listCumparatori;
    }

    public void save(Cumparatori cumparator) {
        SimpleJdbcInsert insertCumparator = new SimpleJdbcInsert(jdbcTemplate);
        insertCumparator.withTableName("Cumparatori").usingColumns("id_cumparator","Persoana_Fizica","Persoana_Juridica","Denumire","Semnatura","CNP","CI","Nr_Reg_Com","CUI","Adresa","Contact","Cod_postal","Email","Stampila");
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(cumparator);
        insertCumparator.execute(param);
    }

    public Cumparatori get(Integer id_cumparator) {
        String sql = "SELECT * FROM CUMPARATORI WHERE id_cumparator = ?";
        Object[] args = {id_cumparator};
        Cumparatori cumparator = jdbcTemplate.queryForObject(sql, args,
                BeanPropertyRowMapper.newInstance(Cumparatori.class));

        return cumparator;
    }

    public void update(Cumparatori cumparator) {
        String sql = "UPDATE CUMPARATORI SET id_cumparator=:id_cumparator,Persoana_Fizica=:Persoana_Fizica,Persoana_Juridica=:Persoana_Juridica,Denumire=:Denumire,Semnatura=:Semnatura,CNP=:CNP,CI=:CI,Nr_Reg_Com=:Nr_Reg_Com,CUI=:CUI,Adresa=:Adresa,Contact=:Contact,Cod_postal=:Cod_postal,Email=:Email,Stampila=:Stampila WHERE id_cumparator=:id_cumparator";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(cumparator);

        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
        template.update(sql,param);
    }

    public void delete(Integer id_cumparator) {
        String sql = "DELETE FROM CUMPARATORI WHERE id_cumparator = ?";
        jdbcTemplate.update(sql,id_cumparator);
    }

}
