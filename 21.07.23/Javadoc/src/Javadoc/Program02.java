package Javadoc;

import java.util.Scanner;

class Program02 {
    static class InvalidInput extends Exception {
        public InvalidInput(String prompt) {
            super(prompt);
        }
    }

    public static class Machine {
        public int total;

        public Machine(int total) {
            this.total = total;
        }

        public void take(int amount) throws InvalidInput {
            if (amount < 0) {
                throw new InvalidInput("Amt less than zero");
            }
            if (amount > total) {
                throw new InvalidInput("Amt greater than total");
            }
            total -= amount;
            System.out.println(total);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int accountBalance = sc.nextInt();
        Machine m = new Machine(accountBalance);
        int withdraw = sc.nextInt();
        try {
            m.take(withdraw);
        } catch (InvalidInput e) {
            System.out.println(e.getMessage());
        }
    }
}
