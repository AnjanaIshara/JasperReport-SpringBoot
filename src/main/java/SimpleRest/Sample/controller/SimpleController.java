package SimpleRest.Sample.controller;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import SimpleRest.Sample.model.Customer;
import SimpleRest.Sample.service.FillPdf;
import java.io.FileNotFoundException;
import net.sf.jasperreports.engine.*;
import java.util.List;
import java.time.LocalDateTime;
import java.util.ArrayList;
@RestController
public class SimpleController  {
    @Autowired
    private FillPdf fillPdf;
    @GetMapping("/endpoint")
    public String SampleResponse(){
        return "Anjana";
    }
    
    @PostMapping("/endpoint-post")
    public ResponseEntity<String> SampleEcho(@RequestBody String s) throws JSONException, FileNotFoundException, JRException{
        String returnMsg="File NOT generated";
        //List<Customer>arr=customers.getPersons();
        
        List<Customer> elementSet=new ArrayList<Customer>();
        JSONArray customerArrayObject=new JSONArray(s);
        for(int i=0;i<customerArrayObject.length();i++){
            JSONObject element=customerArrayObject.getJSONObject(i);
            Customer c=new Customer();
            c.setAcquirerName(element.getString("acquirerName"));
            c.setBatchNo(element.getString("batchNo"));
            c.setBillReferenceId(element.getString("billReferenceId"));
            c.setCardType(element.getString("cardType"));
            c.setCreditCard(element.getString("creditCard"));
            c.setCustomerPhoneNumber(element.getString("customerPhoneNumber"));
            c.setIssuerName(element.getString("issuerName"));
            c.setLastFourDigitsFromCard(element.getString("lastFourDigitsFromCard"));
            c.setMerchant(element.getString("merchant"));
            c.setMerchantName(element.getString("merchantName"));
            c.setSignature(element.getString("signature"));
            c.setTerminal(element.getString("terminal"));
            c.setTransactionAmount(Double.parseDouble(element.getString("transactionAmount")));
            c.setTransactionDate(LocalDateTime.parse(element.getString("transactionDate")));
            c.setTransactionTime(element.getString("transactionTime"));
            c.setTransactionType(element.getString("transactionType"));
            c.setVoucherNo(element.getString("voucherNo"));
            
            
            elementSet.add(c);
            
        }
        returnMsg=fillPdf.createPDF(elementSet);
        return new ResponseEntity<String>(returnMsg,HttpStatus.OK);


    }


    
    
}
