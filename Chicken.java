public class Chicken extends Bird {

    private static int count;

    public Chicken(String name, int age) {
        super(name, age);
        setLegNumber(2);
        setNumberOfOffsprings(1);
        setPregnancyPerYear(200);
        count++;
    }

    public void sayGreetings() {
        System.out.println("I have nothing to say other than I am against Pigs!");
    }

    public static int getCount() {
        return count;
    }

    public static void decrementCount() {
        count--;
    }

}
