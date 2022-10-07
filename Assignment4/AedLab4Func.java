public class AedLab4Func {
    private int totalPoints = 0;
    private int earnedPoints = 0;
    private int assignment = 0;

    private int num = 0;
    private int[] totalPointArr = null;
    private int[] earnedPointArr = null;
    private int[] assignmentArr = null;

    // Setters
    public void setNum(int num) {
        this.num = num;
    }

    public void setTotalPointArr(int[] totalPointArr) {
        this.totalPointArr = totalPointArr;
    }

    public void setEarnedPointArr(int[] earnedPointArr) {
        this.earnedPointArr = earnedPointArr;
    }

    public void setAssignmentArr(int[] assignmentArr) {
        this.assignmentArr = assignmentArr;
    }

    // Constructors
    public AedLab4Func() {
    }

    public AedLab4Func(int t, int e, int a) {
        this.totalPoints = t;
        this.earnedPoints = e;
        this.assignment = a;
    }

    // Overload initialzation function
    public AedLab4Func(int n, int[] t, int[] e, int[] a) {
        this.num = n;
        this.totalPointArr = t;
        this.earnedPointArr = e;
        this.assignmentArr = a;
    }

    private boolean checkInput() {
        // check possible invalid inputs
        if (this.totalPoints < 0 || this.earnedPoints < 0 || this.assignment < 0 || this.assignment > 100) 
            return true;
        return false;
    }

    // calcute each grade
    private double getGrade(int e, int t, int a) {
        return 1.0 * e / t * a;
    }

    // Assignment1's func
    public void resultSingle() {
        if (this.checkInput()) {
            System.out.println("Invalid Input!");
            return;
        }

        double res = this.getGrade(earnedPoints, totalPoints, assignment); // calculate weighted grades
        System.out.println("Total Weighted grade = " + earnedPoints + " / " + totalPoints +
                " * ." + assignment + " *100 = " + res + " for the weighted grade."); // print out result in format
        return;
    }

    // calculate the final grade
    private double getFinGrade() {
        double res = 0;
        for (int i = 0; i < this.num; i++) {
            res += getGrade(earnedPointArr[i], totalPointArr[i], assignmentArr[i]);
        }
        return res;
    }

    // get the level
    public String resultArray() {
        double finGrade = this.getFinGrade();
        System.out.println("TOTAL weighted grade is:    " + finGrade);
        if (finGrade >= 90) {
            return "A";
        } else if (finGrade >= 80) {
            return "B";
        } else if (finGrade >= 70) {
            return "C";
        } else if (finGrade >= 60) {
            return "D";
        }
        return "F";
    }
}
