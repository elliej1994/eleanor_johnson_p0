package dev.johnson.entities;


public class TransactionDetails {
    private int accountNo;
    private int transNo;
    private String dateOfTrans;
    private String typeOfTrans;
    private double transAmt;


    public TransactionDetails(){}



    public TransactionDetails(int accountNo, String dateOfTrans, String typeOfTrans, double transAmt) {
        this.accountNo = accountNo;
        this.dateOfTrans = dateOfTrans;
        this.typeOfTrans = typeOfTrans;
        this.transAmt = transAmt;

    }



    public int getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(int accountNo) {
        this.accountNo = accountNo;
    }


    public int getTransNo() {
        return transNo;
    }

    public void setTransNo(int transNo) {
        this.transNo = transNo;
    }

    public String getDateOfTrans() {
        return dateOfTrans;
    }

    public void setDateOfTrans(String dateOfTrans) {
        this.dateOfTrans = dateOfTrans;
    }

    public String getTypeOfTrans() {
        return typeOfTrans;
    }

    public void setTypeOfTrans(String typeOfTrans) {
        this.typeOfTrans = typeOfTrans;
    }

    public double getTransAmt() {
        return transAmt;
    }

    public void setTransAmt(double transAmt) {
        this.transAmt = transAmt;
    }




    @Override
    public String toString() {
        return "TransactionDetails{" +
                "accountNo=" + accountNo +
                ", dateOfTrans='" + dateOfTrans + '\'' +
                ", typeOfTrans='" + typeOfTrans + '\'' +
                ", transAmt=" + transAmt +
                '}';
    }
}





