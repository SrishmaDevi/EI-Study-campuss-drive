// Main.java
public class Main {
    public static void main(String[] args) {
        Coffee simpleCoffee = new SimpleCoffee();
        System.out.println(simpleCoffee.getDescription() + " $" + simpleCoffee.getCost());

        Coffee milkCoffee = new MilkDecorator(simpleCoffee);
        System.out.println(milkCoffee.getDescription() + " $" + milkCoffee.getCost());

        Coffee sugarMilkCoffee = new SugarDecorator(milkCoffee);
        System.out.println(sugarMilkCoffee.getDescription() + " $" + sugarMilkCoffee.getCost());

        Coffee whipCreamSugarMilkCoffee = new WhipCreamDecorator(sugarMilkCoffee);
        System.out.println(whipCreamSugarMilkCoffee.getDescription() + " $" + whipCreamSugarMilkCoffee.getCost());
    }
}
