class Patient {
    private String name;
    private int age;
    private String gender;
    private double weight, height, bmi;

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    
    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }
    
    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }
    
    public double getWeight() { return weight; }
    public void setWeight(double weight) { this.weight = weight; }
    
    public double getHeight() { return height; }
    public void setHeight(double height) { this.height = height; }
    
    public double getBmi() { return bmi; }
    public void setBmi(double bmi) { this.bmi = bmi; }
}

class HealthMetric {
    public static void calculate(double bmi, int age, String gender) {
        System.out.println("Fat Rate:");
        // Using equalsIgnoreCase is safer in case of capitalization
        if (gender.equalsIgnoreCase("male")) {
            System.out.println((1.20 * bmi) + (0.23 * age) - 16.2);
        } else {
            System.out.println((1.20 * bmi) + (0.23 * age) - 5.4);
        }
    }
}

public class Main {
    
    // Adjusted age calculator
    public static void calculate(int age, double bmi) {
        if (bmi < 18.5) {
            System.out.println("Adjusted Age: " + (age + 2));
        } else if (bmi > 25) {
            System.out.println("Adjusted Age: " + (age + 5));
        } else {
            System.out.println("Adjusted Age: " + age);
        }
    }

    // Main calculator handling the Patient object
    public static void calculate(Patient object) {
        System.out.println("--- " + object.getName() + " ---");
        
        // Convert height from cm to meters
        double heightInMeters = object.getHeight() / 100.0;
        object.setHeight(heightInMeters); 
        
        // Calculate and set BMI
        double bmi = object.getWeight() / (heightInMeters * heightInMeters);
        object.setBmi(bmi);
        System.out.println("BMI: " + object.getBmi());
        
        // Call the other static methods
        calculate(object.getAge(), object.getBmi());
        HealthMetric.calculate(object.getBmi(), object.getAge(), object.getGender());
    }

    public static void main(String[] args) {
        Patient patient1 = new Patient();
        // Use setters because fields are private
        patient1.setName("Razak Mohammad");
        patient1.setAge(34);
        patient1.setGender("male"); 
        patient1.setWeight(68.20);
        patient1.setHeight(158);

        Patient patient2 = new Patient();
        patient2.setName("Sabarinathan");
        patient2.setAge(34);
        patient2.setGender("male");
        patient2.setWeight(89.6);
        patient2.setHeight(165);

        calculate(patient1);
        System.out.println(); // Blank line to separate outputs
        calculate(patient2);
    }
}