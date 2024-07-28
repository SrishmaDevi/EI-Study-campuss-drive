public abstract class Pen {
    protected Ink ink;

    public Pen(Ink ink) {
        this.ink = ink;
    }

    public abstract void draw(String content);
}
