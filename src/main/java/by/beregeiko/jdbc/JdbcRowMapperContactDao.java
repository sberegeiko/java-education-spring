package by.beregeiko.jdbc;

import org.springframework.beans.factory.BeanCreationException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Think on 06.02.2017.
 */
public class JdbcRowMapperContactDao /*implements ContactDao, InitializingBean*/ {
    private DataSource dataSource;
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;

        NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    public String findLastNameById(Long id) {
        String sql = "select last_name from contact where id = :contactId";
        Map<String, Object> namedParametrs = new HashMap<String, Object>();
        namedParametrs.put("contactId", id);
        return namedParameterJdbcTemplate.queryForObject(sql, namedParametrs, String.class);
    }

    public List<Contact> findAll() {
        String sql = "select id, first_name, last_name, birth_date from contact";
        return namedParameterJdbcTemplate.query(sql, new ContactMapper());
    }

    public void afterPropertiesSet() throws Exception {
        if (dataSource == null) {
            throw new BeanCreationException("Must set dataSource on ContactDao");
        }

        if (namedParameterJdbcTemplate == null) {
            throw new BeanCreationException("Null NamedParameterJdbcTemplate on ContactDao");
        }
    }

    private class ContactMapper implements RowMapper<Contact> {
        public Contact mapRow(ResultSet resultSet, int rowNum) throws SQLException {
            Contact contact = new Contact();
            contact.setId(resultSet.getLong("id"));
            contact.setFirstName(resultSet.getString("first_name"));
            contact.setLastName(resultSet.getString("last_name"));
            contact.setBirthDate(resultSet.getDate("birth_date"));
            return contact;
        }
    }
}
