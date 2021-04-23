package com.scx.scoma.services.service_projet_ped;

import com.scx.scoma.entities.entities_projet_ped.ProjetPedagogique;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class InvoiceService {
    JasperDesign jasperDesign = JRXmlLoader.load("C:\\Users\\Norman\\Desktop\\etats\\report1.jrxml");
    JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
    Map parameters = new HashMap();

    public InvoiceService() throws JRException {
        parameters.put("id_suivi", 23);

    }
}
