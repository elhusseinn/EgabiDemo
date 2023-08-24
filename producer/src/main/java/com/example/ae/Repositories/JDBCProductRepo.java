package com.example.ae.Repositories;

import com.example.ae.Models.Product;
import com.example.ae.Repositories.Base.BaseRepoInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository("productJdbc")
public class JDBCProductRepo implements BaseRepoInterface<Product> {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public Product save(Product object) {
        jdbcTemplate.update(
                "insert into products (name, price) values (?,?)",
                object.getName(), object.getPrice());
        return new Product(1, object.getName(), object.getPrice());
    }

    @Override
    public List<Product> findAll() {
        return jdbcTemplate.query(
                "select * from products",
                (rs, rowNum)->
                        new Product(
                                rs.getLong("id"),
                                rs.getString("name"),
                                rs.getDouble("price")
                        )
        );
    }

    @Override
    public Optional<Product> findById(Long id) {
        return jdbcTemplate.queryForObject(
                "select * from products where id =?",
                new Object[]{id},
                (rs, rowNum)->
                        Optional.of(new Product(
                                rs.getLong("id"),
                                rs.getString("name"),
                                rs.getDouble("price")
                                )
                        )
        );
    }

    @Override
    public void deleteById(Long id) {
        jdbcTemplate.update("delete products where id =?", id);
    }

    @Override
    public Product updateById(Long id, Product objectDetails) {
        jdbcTemplate.update(
                "UPDATE products SET name = ?, price = ?",
                objectDetails.getName(), objectDetails.getPrice()
        );
        return new Product(1, objectDetails.getName(), objectDetails.getPrice());
    }
}
