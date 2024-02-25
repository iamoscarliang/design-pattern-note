package builder;

public class Main {

    public static void main(String[] args) {
        Vacation vacation = new VacationBuilder()
                .setDate("May 1")
                .setHotel("Awesome Hotel")
                .addEvent("Learn Java")
                .addEvent("Learn Design Pattern")
                .build();

        System.out.println(vacation);
    }

}
