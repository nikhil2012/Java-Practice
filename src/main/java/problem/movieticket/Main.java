package problem.movieticket;

public class Main {

    private int[] persons = {2, 2, 3};

    public static void main(String[] args) {
        Main main = new Main();
        main.findNumberOfTurns(1);
    }

    public void findNumberOfTurns(int personIndex) {
        int turns = 0;
        if (0 == personIndex && 1 == persons[personIndex]) {
            turns = 1;
        } else {
            int selfTicket = persons[personIndex];
            int limitBack = selfTicket - 1;
            for (int i = 0; i < persons.length; i++) {
                if (i > personIndex) {
                    turns += limitBack < persons[i] ? limitBack : persons[i];
                } else {
                    turns += selfTicket < persons[i] ? selfTicket : persons[i];
                }
            }
        }
        System.out.println(String.format("Person[%d] Tickets[%d] : Turns=%d", personIndex + 1, persons[personIndex], turns));
    }
}
