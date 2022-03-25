public class start  {
    private static MainFrame mf;
    private static ResourceLoader rl;
    public static void main(String[] args) {
        rl = new ResourceLoader();
       mf = new MainFrame();

    }

    public static MainFrame getMf() {
        return mf;
    }

    public static ResourceLoader getRl() {
        return rl;
    }
}
