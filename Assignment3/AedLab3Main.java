import java.util.*;

public class AedLab3Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // System.out.print("Please input the number of the assignments:");
        // int N = Integer.parseInt(sc.nextLine());
        // fixed input number
        int N = 8;
        List<Integer> totalPoints = new ArrayList<>(), earnedPoints = new ArrayList<>(), assignment = new ArrayList<>();
        
        // get total pts from user input
        System.out.println("A user inputs total point total of assignments of (in one line, separete using comma)");     
        if (sc.hasNext()) {
            String[] t = sc.nextLine().split(",");     // split the input by comma ,               
            for (int i = 0; i < N; i++)
                totalPoints.add(Integer.valueOf(t[i].trim()));  // remove the space then convert to int
        }

        // get earned pts from user input
        System.out.println("A user inputs earned point total of assignments of (in one line, separete using comma)");   
        if (sc.hasNext()) {
            String[] t = sc.nextLine().split(",");                    
            for (int i = 0; i < N; i++)
                earnedPoints.add(Integer.valueOf(t[i].trim()));
        }
        
        // get assignment percentange from user input
        System.out.println("A user inputs percentages as (in one line, separete using comma)");     
        if (sc.hasNext()) {
            String[] t = sc.nextLine().split(",");                    
            for (int i = 0; i < N; i++)
                assignment.add(Integer.valueOf(t[i].trim()));
        }
        sc.close();
        
        // Initial Business Func and set value
        AedLab3Func func = new AedLab3Func();
        func.setNum(N);
        func.setTotalPointArr(totalPoints.stream().mapToInt(Integer::intValue).toArray());
        func.setEarnedPointArr(earnedPoints.stream().mapToInt(Integer::intValue).toArray());
        func.setAssignmentArr(assignment.stream().mapToInt(Integer::intValue).toArray());

        System.out.println("Level is:   " + func.resultArray());
        return;
    }
}