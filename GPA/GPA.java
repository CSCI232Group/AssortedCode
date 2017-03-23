package gradesymboltable;
/**
 * @author Ian Hecker
 * 
 */
import edu.princeton.cs.algs4.StdIn;
public class GPA{
    
    public static void main(String[] args){
        
        ST<String, Double> gradeList = new ST<String, Double>();
        
        String[] letterGrade = {"A+", "A", "A-", "B+", "B", "B-", 
            "C+", "C", "C-", "D", "F"};
        double[] numberGrade = {4.33, 4.00, 3.67, 3.33, 3.00, 2.67, 
            2.33, 2.00, 1.67, 1.00, 0.00};
        
        for(int iter=0; iter < letterGrade.length; iter++)
        {
            gradeList.put(letterGrade[iter], numberGrade[iter]);
        }
            
        int N = 0;
        double gradeTotal = 0.0;
        
        for(N = 0; !StdIn.isEmpty(); N++)
        {
            String gradeLetter = StdIn.readString();
            double gradePoints = gradeList.get(gradeLetter);
            gradeTotal += gradePoints;
        }
        double GPA = gradeTotal / N;
        System.out.printf("GPA = %.2f\n\n", GPA);
    }
}
