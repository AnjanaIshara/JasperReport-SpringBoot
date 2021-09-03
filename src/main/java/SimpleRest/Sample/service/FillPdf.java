package SimpleRest.Sample.service;
import SimpleRest.Sample.model.Customer;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;


import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class FillPdf {
    public String createPDF(List<Customer> customers) throws FileNotFoundException, JRException{
        File file=ResourceUtils.getFile("classpath:TransactionHistoryByCustomer.jrxml");
        JasperReport jasperReport=JasperCompileManager.compileReport(file.getAbsolutePath());
        ArrayList<Customer> dataBeanList = new ArrayList<Customer>();
        
        for(Customer c:customers){
            dataBeanList.add(c);
        }
        JRBeanCollectionDataSource dataSource=new JRBeanCollectionDataSource(dataBeanList);
        Map<String,Object> parameters=new HashMap<>();
        parameters.put("created By", "ANJANA ISHARA");
        JasperPrint jasperPrint=JasperFillManager.fillReport(jasperReport, parameters,dataSource);
        JasperExportManager.exportReportToPdfFile(jasperPrint,"C:\\Users\\anjan\\Desktop\\final.pdf");
        return "File generated";


    }
}
