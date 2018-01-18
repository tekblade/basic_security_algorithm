
/*
My assumptions is that you have on your computer created directories to check my task works with your data
In my understanding I have to do iterface that is used by another person which simplifies his task in doing algorithm or inversely
*/

package task1;
import java.io.*;
import java.util.Scanner;
import java.lang.*;
import java.lang.Math;
import java.io.FileWriter;
public class Task1 {
   //I did that to simplify 9 numbers because max value of lines is 214748363
    //I supposed the text files are prepared properly if goes about scheme <NUMBER> <text> after sign " " 
    //to simlify there are not definied arrays in unnecessary and unused pools
    //changing array to result: I use natural numbers rules ex 1000 + 100+ 10+1
    //unused arrays cells I am setting to -1
    //I tested program and I give you how I did it because There were indexes out of range
    static int allLines=0;
    
    
    public static int checkLineNumber(String line){
        int[] numbers = new int[9];
        char check=0;
        int i=0;
        for(i=0;i<9;i++)
            numbers[i]=(-1);
        for(i=0; i<9 ;i++){
            check=line.charAt(i);
            if(check>='0' && check<='9'){
                    numbers[i]=Character.getNumericValue(check);
            }
            else
                break;
        }
        /**for(i=0;i<numbers.length;i++){
            System.out.print(numbers[i]);
        }
        System.out.print("\n");**/
        
        int[] numbers2;
        int howManySigns=0;
        i=0;
        while(numbers[i]!=-1){
            howManySigns++;
            i++;
        }
        //System.out.println("how many signs: " + howManySigns);
        i=0;
        numbers2=new int[howManySigns];
        //System.out.println("length of number: " + numbers2.length);
        
        
        while(i<howManySigns){
            numbers2[i]=numbers[i];
            i++;
        }
                
        /**for(i=0;i<numbers2.length;i++){
            System.out.print(numbers2[i]);
        }*
        System.out.print("\n");**/
        
        int sum=0;
        int help=0;
        for(i=numbers2.length-1;i>=0;i--){                
            sum+=numbers2[i]*Math.pow(10, help++);
        }
        
        //return result;
        //System.out.println("Result=" + sum );
        return sum;
    }
    
    public static void searchSpecifiedLine(PrintWriter writer,int whichLine, File[] inputFiles, int countFiles) throws FileNotFoundException, IOException{
        int i=0;
        int help;
        String line=null;
        BufferedReader reader = null; 
        for(i=0;i<countFiles;i++){
            if(inputFiles[i].exists()){
                reader=new BufferedReader(new FileReader(inputFiles[i]));
                while((line=reader.readLine())!=null){
                    help=checkLineNumber(line);
                    if(help==whichLine){
                        writer.println(line);
                        writer.flush();
                    }
                }
            }
        }
    }
    
    public static int maxLineNumber(File[] inputFiles,int countFiles) throws IOException{
        BufferedReader reader = null;
        int i=0;
        String line;
        int max=0;
        for(i=0;i<countFiles;i++){
             if(inputFiles[i].exists()){
                 reader=new BufferedReader(new FileReader(inputFiles[i]));
                 while((line=reader.readLine())!=null){
                     max++;
                 }
             }
        }
        System.out.println("Max line number: "+max);
        return max;
    }
    
    
    public static void main(String[] args) throws FileNotFoundException, IOException {
        Scanner scan= new Scanner(System.in);
        System.out.println("Give your directory path");
        String dir=scan.nextLine();
        File[] inputFiles=null;
        File specifiedDir = new File(dir);
        boolean doesExist = specifiedDir.exists();
        int countFiles=0;
        if(doesExist){
            inputFiles = specifiedDir.listFiles();
            for(File file : inputFiles){
                if(file.isFile())
                    countFiles++;     //A file is normal if it is not a directory. I assume the type of files resided in directory are supported by isFile()
            }
        } else {
            System.out.println("Specified directory doesn't exist");
            System.out.println("Check if your directory does exist or you've made mistake");
            System.out.println("Run this program one more time");
            return;
        }
        if(countFiles > 100){ // checks if there's more files in your directory than 100
            System.out.println("To much plain text files in your specified directory");
            System.out.println("Please prepare directory for this program requirements");
            System.out.println("End of program....");
            System.out.println("Please try again");
            return;
        }
        System.out.println("Let's check correctness another rules in instruction");
        System.out.println("----------------------------------------------------------");
        System.out.println("----------------------------------------------------------");
        System.out.println("I am checking all lines in all files");
        BufferedReader reader = null;
        for(int i=0; i<countFiles; i++ ){
            if(inputFiles[i].exists()){
                reader=new BufferedReader(new FileReader(inputFiles[i]));
                int lines=0;
                String line=null;
                while((line = reader.readLine()) != null){
                    int length=line.length();
                    if(length > 1000){
                        System.out.println("The line currently checked is longer than 1000 signs ");
                        System.out.println("Please check the files because there is line with to many signs");
                        System.out.println("End");
                        return;
                    }
                    allLines++;
                }
             reader.close();
            }        
        }
        if(allLines > 214748363){
            System.out.println("There is to many lines in all files");
            System.out.println("Please prepare directory in specified way in doccumentation");
            return;
        }
        System.out.println("count files = " + countFiles + " count lines = " + allLines);
        System.out.println("At this moment data specified in directory passed all requirements specified in instruction");
        System.out.println("-----------------------------------------------------------------");
        System.out.println("-----------------------------------------------------------------");
        System.out.println("Let's begin process od merging the encrypted file");
        
        File f=new File(dir+"//LukaszGrabiasOutput.txt"); //I had problem with access to the directory //////////////////////////////////////////
        f.createNewFile();
        FileWriter fw=new FileWriter(f);
        PrintWriter writer=new PrintWriter(fw);
        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        int max=maxLineNumber(inputFiles, countFiles);
        int whichLine=1;// line 1 from files from inputFiles
        while(whichLine!=(max+1)){
            searchSpecifiedLine(writer,whichLine,inputFiles,countFiles);
            whichLine++;
            
        }
    }
}
//Every next program's run there's need to be my created file "LukaszGrabiasOutput.txt" to be deleted
//regards Lukas Grabias