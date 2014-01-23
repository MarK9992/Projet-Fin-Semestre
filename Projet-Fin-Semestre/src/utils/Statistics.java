package utils;

import users.Borrower;
import managementsystem.ManagementSystem;

public class Statistics {
    
    private ManagementSystem ms;
    
    public Statistics(ManagementSystem ms){
        this.ms = ms;
    }
    
    public int getNumberOfEquipments(){
        int sum = 0;
        for(String s : ms.getInventory().keySet()){
            sum+=ms.getInventory().get(s).size();
        }
        return sum;
    }
    
    public int getNumberOfLoans(){
        return ms.getLoans().size();
    }
    
    public String getMostBorrowedModel(){
        int sum;
        int nbLoans = 0;
        String mostBorrowed = null;
        for(String s : ms.getInventory().keySet()){
            sum=0;
            for(int i=0; i<ms.getLoans().size(); i++){
                if(ms.getLoans().get(i).getStuff().containsKey(s)){
                    sum+=ms.getLoans().get(i).getStuff().get(s).size();
                }
            }
            if(sum > nbLoans){
                nbLoans = sum;
                mostBorrowed = s;
            }
        }
        return mostBorrowed;
    }
    
    public Borrower getBiggestBorrower(){
        int sum;
        int nbLoans = 0;
        Borrower biggestBorrower = null;
        for(int i = 0; i<ms.getUsers().size(); i++){
            if(!(ms.getUsers().get(i) instanceof Borrower)){
                continue;
            }
            sum=0;
            for(int j=0; j<ms.getLoans().size(); j++){
                if(ms.getLoans().get(j).getBorrower().equals(ms.getUsers().get(i))){
                    sum++;
                }
            }
            if(sum > nbLoans){
                nbLoans = sum;
                biggestBorrower = (Borrower) ms.getUsers().get(i);
            }
        }
        return biggestBorrower;
    }
}
