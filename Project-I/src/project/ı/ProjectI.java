/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.ı;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author xstsn
 */
public class ProjectI {

    /**
     * @param args the command line arguments
     */
        public static void main(String[] args) throws IOException {
        // TODO code application logic here
        
        Text TextFile = new Text();
        DataEntryOperator dataOperator= new DataEntryOperator();
        DataEntryOperator dataOperator1= new DataEntryOperator();
        DataEntryOperator dataOperator2= new DataEntryOperator();
        DataEntryOperator dataOperator3= new DataEntryOperator();
        DataEntryOperator dataOperator4= new DataEntryOperator();
        DataEntryOperator dataOperator5= new DataEntryOperator();
        String[] words= TextFile.ReadWords(); //Words Library
        
        String[] fileNames=new String[5];
        fileNames[0]="C://Users//xstsn//Documents//NetBeansProjects//Project-I//src//project//ı//girdi01.txt";
        fileNames[1]="C://Users//xstsn//Documents//NetBeansProjects//Project-I//src//project//ı//girdi02.txt";
        fileNames[2]="C://Users//xstsn//Documents//NetBeansProjects//Project-I//src//project//ı//girdi03.txt";
        fileNames[3]="C://Users//xstsn//Documents//NetBeansProjects//Project-I//src//project//ı//girdi04.txt";
        fileNames[4]="C://Users//xstsn//Documents//NetBeansProjects//Project-I//src//project//ı//girdi05.txt";
        
        String[][] performance1;
        String[][] performance2;
        String[][] performance3;
        String[][] performance4;
        String[][] performance5;
        
        
        
        ArrayList <DataEntryOperator> operators = new ArrayList<DataEntryOperator>();
        
        
        double operatorSuccessRate;
        double successRate;
        
        int wholeWordCount=0;
        int correctWordCount=0;
        int correctedWordCount=0;
        
        double engRates=0;
        double medRates=0;
        double finalSuccessRate=0;
        
        int fileCounter=0;
        for (int i=0; i<5; i++){
            
            File testValid= new File(fileNames[i]);
            if(testValid.exists()){
                fileCounter++;
        
        
        switch(i){
            case 0:
            dataOperator1= TextFile.ReadLibrary(fileNames[i]);
            
            performance1=TextFile.CorrectingErrors(words, fileNames[i]);
            operatorSuccessRate= (Double.parseDouble(performance1[1][1])*100)/Double.parseDouble(performance1[1][0]);       
            performance1[1][4]=Double.toString(operatorSuccessRate).substring(0,2);
            successRate=(Double.parseDouble(performance1[1][1])/(Double.parseDouble(performance1[1][1])+Double.parseDouble(performance1[1][3])));
            performance1[1][5]=Double.toString(successRate).substring(0,3);
            dataOperator1.setPerformance(performance1);
            operators.add(dataOperator1);
            break;
            case 1:
            dataOperator2= TextFile.ReadLibrary(fileNames[i]);
            
            performance2=TextFile.CorrectingErrors(words, fileNames[i]);
            operatorSuccessRate= (Double.parseDouble(performance2[1][1])*100)/Double.parseDouble(performance2[1][0]);       
            performance2[1][4]=Double.toString(operatorSuccessRate).substring(0,2);
            successRate=(Double.parseDouble(performance2[1][1])/(Double.parseDouble(performance2[1][1])+Double.parseDouble(performance2[1][3])));
            performance2[1][5]=Double.toString(successRate).substring(0,3);
            dataOperator2.setPerformance(performance2);
            operators.add(dataOperator2);
            break;
            case 2:
            dataOperator3= TextFile.ReadLibrary(fileNames[i]);
            
            performance3=TextFile.CorrectingErrors(words, fileNames[i]);
            operatorSuccessRate= (Double.parseDouble(performance3[1][1])*100)/Double.parseDouble(performance3[1][0]);       
            performance3[1][4]=Double.toString(operatorSuccessRate).substring(0,2);
            successRate=(Double.parseDouble(performance3[1][1])/(Double.parseDouble(performance3[1][1])+Double.parseDouble(performance3[1][3])));
            performance3[1][5]=Double.toString(successRate).substring(0,3);
            dataOperator3.setPerformance(performance3);
            operators.add(dataOperator3);
            break;
            case 3:
            dataOperator4= TextFile.ReadLibrary(fileNames[i]);
            
            performance4=TextFile.CorrectingErrors(words, fileNames[i]);
            operatorSuccessRate= (Double.parseDouble(performance4[1][1])*100)/Double.parseDouble(performance4[1][0]);       
            performance4[1][4]=Double.toString(operatorSuccessRate).substring(0,2);
            successRate=(Double.parseDouble(performance4[1][1])/(Double.parseDouble(performance4[1][1])+Double.parseDouble(performance4[1][3])));
            performance4[1][5]=Double.toString(successRate).substring(0,3);
            dataOperator4.setPerformance(performance4);
            operators.add(dataOperator4);
            break;
            case 4:
            dataOperator5= TextFile.ReadLibrary(fileNames[i]);
            performance5=TextFile.CorrectingErrors(words, fileNames[i]);
            operatorSuccessRate= (Double.parseDouble(performance5[1][1])*100)/Double.parseDouble(performance5[1][0]);       
            performance5[1][4]=Double.toString(operatorSuccessRate).substring(0,2);
            successRate=(Double.parseDouble(performance5[1][1])/(Double.parseDouble(performance5[1][1])+Double.parseDouble(performance5[1][3])));
            performance5[1][5]=Double.toString(successRate).substring(0,3);
            dataOperator5.setPerformance(performance5);
            operators.add(dataOperator5);

            break;
        }
        
        }
            
        }
        
        int engCount=0;
        int medCount=0;
        //System.out.println("Operatör ad soyad: "+dataOperator.adSoyad+" Departman: "+dataOperator.departman);
        for(DataEntryOperator s: operators){
            
            String[][] temp=s.getPerformance();
            wholeWordCount= wholeWordCount+Integer.parseInt(temp[1][0]);
            correctWordCount= correctWordCount+Integer.parseInt(temp[1][1]);
            correctedWordCount= correctedWordCount+Integer.parseInt(temp[1][2]);
            finalSuccessRate= finalSuccessRate+Double.parseDouble(temp[1][5]);
            if(s.getDepartman().equalsIgnoreCase("MuhendislikFakultesi")){
                engRates=engRates+Double.parseDouble(temp[1][4]);
                engCount++;
            }
            else if(s.getDepartman().equalsIgnoreCase("TipFakultesi")){
                medRates=medRates+(100-Double.parseDouble(temp[1][4]));
                medCount++;
            }
            
        }
        
        finalSuccessRate=finalSuccessRate/fileCounter;
        
        System.out.println("Total Word Count: "+wholeWordCount);
        System.out.println("Engineering F. Success Rates: "+engRates);
        System.out.println("Med. F. Error Rates: "+medRates);
        System.out.println("Final Success Rate: "+finalSuccessRate);
        
    }
    
}
