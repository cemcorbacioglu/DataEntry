/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.ı;

/**
 *
 * @author xstsn
 */
public class DataEntryOperator {
    
    int ID;
    String adSoyad;
    String departman;
    String[][] performance;

    public String[][] getPerformance() {
        return performance;
    }

    public void setPerformance(String[][] performance) {
        this.performance = performance;
    }
    
    
    
    public DataEntryOperator(){}
    
    public DataEntryOperator(int inputID, String inputadSoyad, String inputdepartman){
        ID= inputID;
        adSoyad= inputadSoyad;
        departman= inputdepartman;
    }

    @Override
    public String toString() {
        return "DataEntryOperator{" + "ID=" + ID + ", adSoyad=" + adSoyad + ", departman=" + departman + '}';
    }
    
    public int getID() {
        return ID;
    }

    public String getAdSoyad() {
        return adSoyad;
    }

    public String getDepartman() {
        return departman;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setAdSoyad(String adSoyad) {
        this.adSoyad = adSoyad;
    }

    public void setDepartman(String departman) {
        this.departman = departman;
    }
    
    
    
}
