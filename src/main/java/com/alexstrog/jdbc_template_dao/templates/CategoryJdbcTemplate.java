package com.alexstrog.jdbc_template_dao.templates;

import com.alexstrog.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.util.List;
import java.util.Optional;

import static java.sql.Types.BIGINT;


//@Component
public class CategoryJdbcTemplate {

//    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Optional<List<Category>> getAll() {
        String query = "SELECT id, name, description FROM categories;";
        List<Category> categories = jdbcTemplate.query(query, (ResultSet rs, int n) ->
           new Category(rs.getLong(1),
                   rs.getString(2),
                   rs.getString(3))
        );
        return Optional.ofNullable(categories);
    }

    public Optional<Category> create(Category category) {
        String query = "INSERT INTO categories VALUES (?, ?, ?);";
        Category cat = jdbcTemplate.execute(query, (PreparedStatementCallback<Category>) preparedStatement -> {
            preparedStatement.setNull(1, BIGINT);
            preparedStatement.setString(2, category.getName());
            preparedStatement.setString(3, category.getDescription());
            preparedStatement.executeUpdate();
            ResultSet keys = preparedStatement.getGeneratedKeys();
            if (keys.next()) {
                category.setId(keys.getLong(1));
                return category;
            } else {
                return null;
            }
        });

        return Optional.ofNullable(cat);
    }

    public Optional<Category> getById(Long id) {
        String query = "SELECT id, name, description FROM categories WHERE id = ?";
        Category category = jdbcTemplate.execute(query, (PreparedStatementCallback<Category>) preparedStatement -> {
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return new Category(id,
                        resultSet.getString(2),
                        resultSet.getString(3));
            } else {
                return null;
            }
        });

        return Optional.ofNullable(category);
    }

    public Optional<Category> update(Category category) {
        String query = "UPDATE categories SET name = ?, description = ? WHERE id = ?";
        jdbcTemplate.update(query, preparedStatement -> {
            preparedStatement.setString(1, category.getName());
            preparedStatement.setString(2, category.getDescription());
            preparedStatement.setLong(3, category.getId());
            preparedStatement.executeUpdate();
        });

        return Optional.of(category);
    }

    public void delete(Long id) {
        String query = "DELETE FROM categories WHERE id = ?;";

        jdbcTemplate.update(query, preparedStatement -> {
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        });
    }
}
