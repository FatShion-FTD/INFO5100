public class Main {
    public static void main(String[] args) {
        try {
            GUI gui = new GUI();
            gui.run();
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}
