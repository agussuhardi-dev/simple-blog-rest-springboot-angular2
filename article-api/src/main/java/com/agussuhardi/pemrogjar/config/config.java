package com.agussuhardi.pemrogjar.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;

import javax.sql.DataSource;

/**
 * Created by agussuhardi on 13/12/16.
 */

@Configuration
@ComponentScan
public class config {


    @Autowired
    private JdbcTemplate jdbcTemplate;

    //@Autowired DataSource dataSource;

    @Autowired
    public void createTrigger() {
        this.jdbcTemplate.execute(this.sqlQueryInsertArticle_delete);
        this.jdbcTemplate.execute(this.sqlQueryInsertArticle);

        this.jdbcTemplate.execute(this.sqlQueryUpdateArticle_delete);
        this.jdbcTemplate.execute(this.sqlQueryUpdateArticle);

        this.jdbcTemplate.execute(this.createUser);
    }


    private String createUser = "INSERT IGNORE INTO user (user_name, password, description, login) values('admin', 'admin', '@agussuhardi', 0)";


    private String sqlQueryInsertArticle_delete = "DROP TRIGGER IF EXISTS insert_article;";
    private String sqlQueryInsertArticle = "CREATE TRIGGER insert_article AFTER INSERT ON article\n" +
            "  FOR EACH ROW\n" +
            "  INSERT INTO history(id, old_title, new_title, old_article, new_article, browser_change, host_name_change, information_change, local_ip_change, public_ip_change, operating_system_change, user_name_change, update_date, article_id)\n" +
            "                VALUES(NULL , NULL , new.title, NULL , new.article, new.browser_change, new.host_name_change, new.information_change, new.local_ip_change, new.public_ip_change, new.operating_system_change, new.user_name_change,now(), new.id)";


    private String sqlQueryUpdateArticle_delete = "DROP TRIGGER IF EXISTS update_article;";
    private String sqlQueryUpdateArticle = "CREATE TRIGGER update_article AFTER UPDATE ON article\n" +
            "  FOR EACH ROW\n" +
            "  INSERT INTO history(id, old_title, new_title, old_article, new_article, browser_change, host_name_change, information_change, local_ip_change, public_ip_change, operating_system_change, user_name_change, update_date, article_id)\n" +
            "                VALUES(NULL , old.title , new.title, old.article , new.article, new.browser_change, new.host_name_change, new.information_change, new.local_ip_change, new.public_ip_change, new.operating_system_change, new.user_name_change,now(), new.id)";


}