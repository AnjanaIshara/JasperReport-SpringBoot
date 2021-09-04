package SimpleRest.Sample.model;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class Customer {
    private String billReferenceId;
    private String voucherNo;
    private String batchNo;
    private String lastFourDigitsFromCard;
    private String customerPhoneNumber;
    private String acquirerName;
    private String issuerName;
    private String merchant;
    private String cardType;
    private Double transactionAmount;
    private String creditCard;
    private LocalDateTime transactionDate;
    private String transactionTime;
    private String transactionType;
    private String terminal;
    private String merchantName;
    private String signature;
}
