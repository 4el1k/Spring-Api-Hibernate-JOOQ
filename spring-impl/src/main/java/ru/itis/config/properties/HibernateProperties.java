package ru.itis.config.properties;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Getter
public class HibernateProperties {
    private final String ddlAuto;
    private final String dialect;
    private final String showSql;
    private final String enableLazyLoadNoTrans;
    private final String hbm2ddlAuto;

    public HibernateProperties(@Value("${hibernate.ddl.auto}") String ddlAuto,
                               @Value("${hibernate.dialect}") String dialect,
                               @Value("${hibernate.show_sql}") String showSql,
                               @Value("${hibernate.enable_lazy_load_no_trans}") String enableLazyLoadNoTrans,
                               @Value("${hibernate.hbm2ddl.auto}") String hbm2ddlAuto) {
        this.ddlAuto = ddlAuto;
        this.dialect = dialect;
        this.showSql = showSql;
        this.enableLazyLoadNoTrans = enableLazyLoadNoTrans;
        this.hbm2ddlAuto = hbm2ddlAuto;
    }
}

