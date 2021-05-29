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
public class rateCSkmitlCoin implements Itfratecoin{
    
    public rateCSkmitlCoin(){}
    @Override
    public double getrateCS_kmitl_Coin(){
         double rateCScoin = rate_coin.rateCS_kmitl_Coin();
        
        double Conditionrate = Double.parseDouble(String.format("%.6f",rateCScoin));
        
        if(Conditionrate < 100){
            Conditionrate = 100; 
        }else{
            Conditionrate = 150;
        }
        return Conditionrate;
    } 
}


