package dev.johnson.entities;


public class TransactionDetails {

    private int transNo;
    private String dateOfTrans;
    private String typeOfTrans;
    private double transAmt;
    private int recipientAcc;


    public TransactionDetails(){}

    public TransactionDetails(int transNo, String dateOfTrans, String typeOfTrans, double transAmt, int recipientAcc) {
        this.transNo = transNo;
        this.dateOfTrans = dateOfTrans;
        this.typeOfTrans = typeOfTrans;
        this.transAmt = transAmt;
        this.recipientAcc = recipientAcc;
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

    public int getRecipientAcc() {
        return recipientAcc;
    }

    public void setRecipientAcc(int recipientAcc) {
        this.recipientAcc = recipientAcc;
    }

    @Override
    public String toString() {
        return "TransactionDetails{" +
                "transNo=" + transNo +
                ", dateOfTrans='" + dateOfTrans + '\'' +
                ", typeOfTrans='" + typeOfTrans + '\'' +
                ", transAmt=" + transAmt +
                ", recipientAcc=" + recipientAcc +
                '}';
    }
}





