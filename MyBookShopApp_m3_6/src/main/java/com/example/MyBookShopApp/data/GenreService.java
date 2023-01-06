package com.example.MyBookShopApp.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Service
public class GenreService {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public GenreService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Genre> getGenreData() {

        List<Genre> genres = jdbcTemplate.query("SELECT * FROM genres", (ResultSet rs, int rownum) -> {
            Genre genre = new Genre();
            genre.setId(rs.getInt("id"));
            genre.setGenre(rs.getString("genre"));
            return genre;
        });
        return new ArrayList<>(genres);
    }
}
