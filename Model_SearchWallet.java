/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author suthi
 */
public class Model_SearchWallet {
    private String id_transaction, souce_wallet, destination_wallet, state;
    private double quantity,rate;
  


    
    public Model_SearchWallet(String id_transaction, String souce_wallet, String destination_wallet, Double quantity, Double rate) {
        this.id_transaction = id_transaction;
        this.souce_wallet = souce_wallet;
        this.destination_wallet = destination_wallet;
        this.quantity = quantity;
        this.rate = rate;
        this.state = state;
    }

    public void setId_transaction(String id_transaction) {
        this.id_transaction = id_transaction;
    }

    public void setSouce_wallet(String souce_wallet) {
        this.souce_wallet = souce_wallet;
    }

    public void setDestination_wallet(String destination_wallet) {
        this.destination_wallet = destination_wallet;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }
    
    public void setState(String state) {
        this.state = state;
    }

    public String getId_transaction() {
        return id_transaction;
    }

    public String getSouce_wallet() {
        return souce_wallet;
    }

    public String getDestination_wallet() {
        return destination_wallet;
    }

    public Double getQuantity() {
        return quantity;
    }

    public Double getRate() {
        return rate;
    }
    
     public String isState() {
        return state;
    }

}
