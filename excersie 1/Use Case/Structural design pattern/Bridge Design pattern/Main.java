public class Main {
    public static void main(String[] args) {
        Ink blueInk = new BlueInk();
        Ink blackInk = new BlackInk();

        Pen ballpointPen = new BallpointPen(blueInk);
        Pen fountainPen = new FountainPen(blackInk);

        ballpointPen.draw("Hello, World!");  // Output: Drawing 'Hello, World!' with a ballpoint pen using blue ink.
        fountainPen.draw("Hello, World!");   // Output: Drawing 'Hello, World!' with a fountain pen using black ink.
    }
}
