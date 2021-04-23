package com.scx.scoma;


import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import org.apache.catalina.core.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.jdbc.datasource.DataSourceUtils;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class GestionprojetpedagogiqueApplication {
    private Environment env;


    public GestionprojetpedagogiqueApplication(Environment env) {
        this.env = env;
    }

    public static void main(String[] args) throws JRException, SQLException {
        SpringApplication.run(GestionprojetpedagogiqueApplication.class, args);
        DataSource ds = dataSource();
        Long su = 23L;
        JasperDesign jasperDesign = JRXmlLoader.load("C:\\Users\\Norman\\Desktop\\etats\\report1.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
        Map parameters = new HashMap();
        parameters.put("id_suivi", su );

        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,parameters, ds.getConnection());
        JasperExportManager.exportReportToPdfFile(jasperPrint,"C:\\Users\\Norman\\Desktop\\etats\\clas.pdf");




    }
    
    @Bean
    public static DataSource dataSource(){
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName("com.mysql.cj.jdbc.Driver");
        dataSourceBuilder.url("jdbc:mysql://localhost:3306/projetped?useSSL=false&serverTimezone=UTC");
        dataSourceBuilder.username("root");
        dataSourceBuilder.password("");
        return dataSourceBuilder.build();
    }

}
