/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.ı;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;


/**
 *
 * @author xstsn
 */
public class Text {
    
    DataEntryOperator yazar;
    String content;
    String[][] textAndPerformance=new String[2][];

    
    public Text(){}
    
    public Text(DataEntryOperator inputyazar, String inputcontent){
        
        yazar= inputyazar;
        content= inputcontent;
        
    }
    
    
    public String[] ReadWords() throws FileNotFoundException, IOException{
       // File filetry = new File("C://Users//xstsn//Documents//NetBeansProjects//Project-I//src//project//ı//words.txt");
        FileReader wordsFile= new FileReader("C://Users//xstsn//Documents//NetBeansProjects//Project-I//src//project//ı//words.txt");
        BufferedReader br= new BufferedReader(wordsFile);
       // System.out.println(filetry.length());
        String[] words= new String[87500];
        int i=0;
        String line=br.readLine();
        while(line!=null){
            words[i]=line;
            line=br.readLine();
            i++;
           
        }
        
        return words;
        
    }
    
    
    public DataEntryOperator ReadLibrary(String fileName) throws FileNotFoundException, IOException{
        
        FileReader operatorFile= new FileReader(fileName);
        
        BufferedReader br= new BufferedReader(operatorFile);
        
        String dataop[]= br.readLine().split(",");
        
        DataEntryOperator DataOp= new DataEntryOperator(Integer.parseInt(dataop[0]),dataop[1],dataop[2]);
        
        br.close();
        return DataOp;
    }
    
    
    public String[][] CorrectingErrors(String[] words, String fileName) throws FileNotFoundException, IOException{
        //Reads every line of given text, splits it to words with space
        //Writes corrected version to a new text file
        int wordCount=wordCount(fileName);
        textAndPerformance[0]=new String[wordCount];
        textAndPerformance[1]=new String[10];
        for(int p=0; p<textAndPerformance[1].length; p++){
            textAndPerformance[1][p]="0";
        }
        textAndPerformance[1][0]=Integer.toString(wordCount);
        FileReader fileToCorrect= new FileReader(fileName);
        BufferedReader br= new BufferedReader(fileToCorrect);
        String[] tempFileName= fileName.split("//");
        String tempFile= tempFileName[tempFileName.length-1].substring(0,tempFileName[tempFileName.length-1].length()-4);
        FileWriter correctedFile= new FileWriter("C://Users//xstsn//Documents//NetBeansProjects//Project-I//src//project//ı//"+tempFile+"corrected.txt");
        BufferedWriter bw= new BufferedWriter(correctedFile);
        String correctedWord;
        int counter=0; //words counter for given text file
        String[] wordsInFile= null;
        int i=0;
        String line=br.readLine();
        while(line!=null){
            
            if (i==0){
               bw.write(line);
               bw.newLine();
                i++;
            }
            else{
                line=br.readLine();
                
                if(line!=null){
                String[] lineToCorrect= line.split(" ");
                String[] correctedLine=new String[lineToCorrect.length];
                for(int j=0; j<lineToCorrect.length; j++){
                
                    String wordToCorrect= lineToCorrect[j];
                    textAndPerformance[0][counter]=wordToCorrect;
                    counter++;
                    if(wordToCorrect=="a"||wordToCorrect=="the"||wordToCorrect=="that"||wordToCorrect=="in"||wordToCorrect=="on"){
                        
                    }
                    else{
                    correctedLine[j]=correctFinal(wordToCorrect,words);
                    }
                
                }
                
                for(int q=0; q<correctedLine.length; q++){
                    bw.write(correctedLine[q]+" ");
                }
                bw.newLine(); 
                bw.flush(); //flushing the writer
                }
            }
            
        }
        
        return textAndPerformance;
        
    }
    
    public int wordCount(String fileName)throws FileNotFoundException, IOException{
        int count=0;
        
        
        FileReader fileToCorrect= new FileReader(fileName);
        BufferedReader br= new BufferedReader(fileToCorrect);
        String line=br.readLine();
        while(line!=null){
            line=br.readLine();
            if(line!=null){
            String[] temp=line.split(" ");
            
            for(int i=0; i<temp.length;i++){
                count++;
            }}
        }
        
        return count;
    }
    
    public String correctFinal(String word, String[] library) {
    
        //Checking if the word is in library
        for(int i=0; i<library.length;i++){
            if(word.equalsIgnoreCase(library[i])){
                int temp=Integer.parseInt(textAndPerformance[1][1]);
                temp++;
                String tempS= Integer.toString(temp);
                textAndPerformance[1][1]=tempS;
                return word;
            }
        }

    ArrayList<String> list = NorvigEdits(word);
    
    // Find all things edit distance 1 that are in the dictionary.  
  
    boolean corrected= false;
    for(String s : list){
        for(int i=0; i<library.length; i++){
            if (s.equalsIgnoreCase(library[i])){
                int temp=Integer.parseInt(textAndPerformance[1][2]);
                temp++;
                String tempS= Integer.toString(temp);
                textAndPerformance[1][2]=tempS;
                corrected=true;
                return library[i];
            }
        }
        
    }
    int temp=Integer.parseInt(textAndPerformance[1][3]);
                temp++;
                String tempS= Integer.toString(temp);
                textAndPerformance[1][3]=tempS;
    return word;
  }
    
    
    public String[][] getTextAndPerformance() {
        return textAndPerformance;
    }

    public void setTextAndPerformance(String[][] textAndPerformance) {
        this.textAndPerformance = textAndPerformance;
    }
    private ArrayList<String> NorvigEdits(String word) {
    ArrayList<String> result = new ArrayList<String>();
    
    // All deletes of a single letter
    for(int i=0; i < word.length(); ++i) 
      result.add(word.substring(0, i) + word.substring(i+1));
    
    // All swaps of adjacent letters
    for(int i=0; i < word.length()-1; ++i) 
      result.add(word.substring(0, i) + word.substring(i+1, i+2) + 
                 word.substring(i, i+1) + word.substring(i+2));
    
    // All replacements of a letter
    for(int i=0; i < word.length(); ++i) 
      for(char c='a'; c <= 'z'; ++c) 
        result.add(word.substring(0, i) + String.valueOf(c) + word.substring(i+1));
    
    // All insertions of a letter
    for(int i=0; i <= word.length(); ++i) 
      for(char c='a'; c <= 'z'; ++c) 
        result.add(word.substring(0, i) + String.valueOf(c) + word.substring(i));
    
    return result;
  }
    
    
}
