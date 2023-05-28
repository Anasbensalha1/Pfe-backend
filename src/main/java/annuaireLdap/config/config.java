package annuaireLdap.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.*;
import org.springframework.data.ldap.repository.config.EnableLdapRepositories;
import org.springframework.ldap.core.ContextSource;
import org.springframework.ldap.core.LdapTemplate;

@Configuration
@PropertySource("classpath:application.properties")
@ComponentScan(basePackages = {"annuaireLdap.*"})
@Profile("default")
@EnableLdapRepositories(basePackages = "annuaireLdap.*")
public class config {
    private static final Logger logger = LoggerFactory.getLogger(config.class);
    @Bean
    LdapTemplate ldapTemplate(ContextSource contextSource){
        return new LdapTemplate(contextSource);
    }
}
