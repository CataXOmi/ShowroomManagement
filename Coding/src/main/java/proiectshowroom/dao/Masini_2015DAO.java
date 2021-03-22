package proiectshowroom.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import proiectshowroom.model.Masini_2015;

import java.util.List;

@Repository
@Transactional
public class Masini_2015DAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Masini_2015> show() {
        String sql = "SELECT * FROM Masini_2015";

        List<Masini_2015> listMasini2015 = jdbcTemplate.query(sql,
                BeanPropertyRowMapper.newInstance(Masini_2015.class));

        return listMasini2015;
    }
}
