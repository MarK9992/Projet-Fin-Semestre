package utils;

import config.Model;
import users.Borrower;
import managementsystem.ManagementSystem;

public class Statistics {
    
    private ManagementSystem ms;
    
    public Statistics(ManagementSystem ms){
        this.ms = ms;
    }
    
    public int getNumberOfEquipments(){
        return ms.getNumberElements();
    }
    
    public int getNumberOfLoans(){
        return ms.getLoans().size();
    }
    
    public Model getMostBorrowedModel(){
        int sum;
        int nbLoans = 0;
        Model mostBorrowed = null;
        for(Model m : ms.getModels()){
            sum=0;
            for(int i=0; i<ms.getLoans().size(); i++){
                if(ms.getLoans().get(i).getStuff().containsKey(m)){
                    sum+=ms.getLoans().get(i).getStuff().get(m).size();
                }
            }
            if(sum > nbLoans){
                nbLoans = sum;
                mostBorrowed = m;
            }
        }
        return mostBorrowed;
    }
    
    public Borrower getBiggestBorrower(){
        int nbLoans = 0;
        Borrower biggestBorrower = null;
        for(int i = 0; i<ms.getUsers().size(); i++){
            if(!(ms.getUsers().get(i) instanceof Borrower)){
                continue;
            }
            int nb = ms.getLoansByBorrower((Borrower)ms.getUsers().get(i)).size();
            if(nb > nbLoans){
                nbLoans = nb;
                biggestBorrower = (Borrower) ms.getUsers().get(i);
            }
        }
        return biggestBorrower;
    }
}
