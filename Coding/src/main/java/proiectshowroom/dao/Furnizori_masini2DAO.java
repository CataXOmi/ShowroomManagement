package proiectshowroom.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import proiectshowroom.model.Furnizori_masini2;

import java.util.List;

@Repository
@Transactional
public class Furnizori_masini2DAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Furnizori_masini2> show() {
        String sql = "SELECT * FROM Furnizori_masini2";

        List<Furnizori_masini2> listFurnizorimasini2 = jdbcTemplate.query(sql,
                BeanPropertyRowMapper.newInstance(Furnizori_masini2.class));

        return listFurnizorimasini2;
    }
}
