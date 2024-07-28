public class BallpointPen extends Pen {
    public BallpointPen(Ink ink) {
        super(ink);
    }

    @Override
    public void draw(String content) {
        System.out.println("Drawing '" + content + "' with a ballpoint pen using " + ink.getColor() + " ink.");
    }
}
