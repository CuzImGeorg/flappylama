public class start  {
    private static MainFrame mf;
    private static ResourceLoader rl;
    public static void main(String[] args) {
        rl = new ResourceLoader();
       mf = new MainFrame();

    }

    private static int mode = 0;

    public static int getMode() {
        return mode;
    }

    public static void setMode(int mode) {
        start.mode = mode;
    }

    private static int winpoints = 9999999;

    public static int getWinpoints() {
        return winpoints;
    }

    public static void setWinpoints(int winpoints) {
        start.winpoints = winpoints;
    }

    public static MainFrame getMf() {
        return mf;
    }

    public static ResourceLoader getRl() {
        return rl;
    }
}
