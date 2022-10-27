public class AedLab6Main {
    public static void main(String[] args) {
        try {
            AedLab6GUI gui = new AedLab6GUI();
            gui.run();
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}
