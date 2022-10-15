import java.util.*;

public class AedLab4Main {
    // check input size
    public static boolean checkInputSize(String[] t, int N) {
        boolean isValid = t.length == N;
        if (!isValid) {
            System.err.println("Invalid Input Error:: number of input is different.");
            System.err.println("Please Input Again!");
        }
        return isValid;
    }

    // get input stream
    public static boolean getInput(Scanner sc, List<Integer> recv, int N) {
        if (sc.hasNext()) {
            String[] t = sc.nextLine().split(",");     // split the input by comma ,    
            // Wrong input size
            if (!checkInputSize(t, N)) {
                return false;
            }
            for (int i = 0; i < N; i++)
                recv.add(Integer.valueOf(t[i].trim()));  // remove the space then convert to int
        }
        return true;
    }

    // check weights valid
    public static boolean checkSum(List<Integer> as){
        int total = 0;
        for (int a : as) {
            total += a;
        }
        return total == 100;
    }

    // run main function
    public static void run() {
        Scanner sc = new Scanner(System.in);
        // custom input
        System.out.print("Please input the number of the assignments:");
        int N = Integer.parseInt(sc.nextLine());
        List<Integer> totalPoints = new LinkedList<>(), earnedPoints = new LinkedList<>(), assignment = new LinkedList<>();
        // get total pts from user input
        System.out.println("A user inputs total point total of assignments of (in one line, separete using comma)");     
        if (!getInput(sc, totalPoints, N)) {
            sc.close();
            return;
        }

        // get earned pts from user input
        System.out.println("A user inputs earned point total of assignments of (in one line, separete using comma)");  
        if (!getInput(sc, earnedPoints, N)) {
            sc.close();
            return;
        }
        
        // get assignment percentange from user input
        System.out.println("A user inputs percentages as (in one line, separete using comma)");     
        if (!getInput(sc, assignment, N)) {
            sc.close();
            return;
        }
        sc.close();

        // check weights add up to 100
        if (!checkSum(assignment)){
            System.err.println("Invalid Input Error:: weights sum is not 100");
            System.err.println("Please Input Again!");
            return;
        }
        
        // Initial Business Func and set value
        AedLab4Func func = new AedLab4Func();
        func.setNum(N);
        func.setTotalPointArr(totalPoints.stream().mapToInt(Integer::intValue).toArray());
        func.setEarnedPointArr(earnedPoints.stream().mapToInt(Integer::intValue).toArray());
        func.setAssignmentArr(assignment.stream().mapToInt(Integer::intValue).toArray());

        System.out.println("Level is:   " + func.resultArray());
        return;
    }

    public static void main(String[] args) {
        try {
            run();
        } catch (Exception e) {
            System.err.print("Invalid Input Error:: ");
            System.err.println(e);
            System.err.println("Please Input Again!");
        }
    }
}