// WhipCreamDecorator.java
public class WhipCreamDecorator extends CoffeeDecorator {
    public WhipCreamDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", Whip Cream";
    }

    @Override
    public double getCost() {
        return super.getCost() + 2.0;
    }
}
