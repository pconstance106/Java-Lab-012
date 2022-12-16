import java.util.ArrayList;
import java.util.Scanner;

public class SolarSystem {
    // gravitational constant
    private static final double G = 6.67430E-11;

    public static void main(String[] args) {
        // create celestial objects
        ArrayList<Planet> objects = new ArrayList<>();
        objects.add(new Planet("Sun", 1.989E30, 0, 0, 0));
        objects.add(new Planet("Mercury", 3.285E23, 5.79E10, 0.0, 47.87E3));
        objects.add(new Planet("Venus", 4.867E24, 1.082E11, 0.0, 35.02E3));
        objects.add(new Planet("Earth", 5.972E24, 1.496E11, 0.0, 29.78E3));
        objects.add(new Planet("Mars", 6.39E23, 2.279E11, 0.0, 24.077E3));
        objects.add(new Planet("Jupiter", 1.898E27, 7.786E11, 0.0, 13.069E3));
        objects.add(new Planet("Saturn", 5.683E26, 1.429E12, 0.0, 9.69E3));
        objects.add(new Planet("Uranus", 8.681E25, 2.877E12, 0.0, 6.80E3));
        objects.add(new Planet("Neptune", 1.024E26, 4.495E12, 0.0, 5.43E3));

        // simulate the motion of the celestial objects
        for (int i = 0; i < 100000; i++) {
            for (Planet obj1 : objects) {
                for (Planet obj2 : objects) {
                    if (obj1 != obj2) {
                        double r = distance(obj1, obj2);
                        double F = G * obj1.getMass() * obj2.getMass() / (r * r);
                        double Fx = F * (obj2.getX() - obj1.getX()) / r;
                        obj1.setVx(obj1.getVx() + Fx / obj1.getMass() * 0.01);
                    }
                }
            }

            for (Planet obj : objects) {
                obj.setX(obj.getX() + obj.getVx() * 0.01);
            }
        }

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Enter the name of a planet (or type 'exit' to quit): ");
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("exit")) {
            }

            for (Planet obj : objects) {
                if (obj.getName().equalsIgnoreCase(input)) {
                    System.out.println("Distance from Sun " + obj.getName() + ": (" + obj.getX() + ")");
                    System.out.println("Velocity of " + obj.getName() + ": (" + obj.getVx() + ")");
                    System.out.println("Mass of " + obj.getName() + ": (" + obj.getMass() + ")");
                }
            }
        }
    }

    private static double distance(Planet obj1, Planet obj2) {
        double dx = obj2.getX() - obj1.getX();
        return Math.abs(dx);
    }
}