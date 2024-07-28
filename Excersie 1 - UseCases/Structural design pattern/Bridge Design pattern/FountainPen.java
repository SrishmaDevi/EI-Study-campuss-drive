public class FountainPen extends Pen {
    public FountainPen(Ink ink) {
        super(ink);
    }

    @Override
    public void draw(String content) {
        System.out.println("Drawing '" + content + "' with a fountain pen using " + ink.getColor() + " ink.");
    }
}
