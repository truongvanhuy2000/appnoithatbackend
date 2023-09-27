package com.huy.backendnoithat.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;

import javax.sql.DataSource;

@Configuration
public class UserDetailsConfig {
    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource) {
        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);
        jdbcUserDetailsManager.setUsersByUsernameQuery(
                "SELECT username, password, active FROM account WHERE username=?"
        );
        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery(
                "SELECT account.username, roles.role\n" +
                        "FROM account\n" +
                        "INNER JOIN roles\n" +
                        "ON account.id=roles.id\n" +
                        "WHERE account.active=true\n" +
                        "AND account.username=?"
        );
        return jdbcUserDetailsManager;
    }
}
