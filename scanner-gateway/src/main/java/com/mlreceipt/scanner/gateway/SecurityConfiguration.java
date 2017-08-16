package com.mlreceipt.scanner.gateway;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@Configuration
class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        // TODO Auto-generated method stub
        httpSecurity.authorizeRequests().antMatchers("/**").permitAll();
    }
}
/*
@Configuration
class MyConfiguration {

    @Bean
    public FilterRegistrationBean corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.addAllowedOrigin("*");
        config.addAllowedHeader("*");
        config.addAllowedMethod("*");
        source.registerCorsConfiguration("/**", config);
        FilterRegistrationBean bean = new FilterRegistrationBean(new CorsFilter(source));
        bean.setOrder(0);
        return bean;
    }
}

*/

/*
 * @Configuration class TestingLabRepositoryApplicationConfiguration extends
 * RepositoryRestMvcConfiguration {
 *
 * @Override protected void
 * configureRepositoryRestConfiguration(RepositoryRestConfiguration config) { //
 * TODO Auto-generated method stub
 * super.configureRepositoryRestConfiguration(config);
 * config.exposeIdsFor(Project.class, Lab.class, Worker.class); } }
 *
 */
