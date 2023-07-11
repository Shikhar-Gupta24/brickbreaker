public class GUIDriver {
    public static void main(String[] args){//Starts the program panel
        DisplayWindow d = new DisplayWindow("Test");
        GUIPanel p = new GUIPanel(500, 700);
        d.add(p);
        d.showFrame();
        }
}

