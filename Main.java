package baigiamasisdarbas;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

    public class Main {
        private  List<Person> persons = new ArrayList<>();

        public static void main(String[] args) throws PersonExeption {
            Main main = new Main();
            Scanner scanner = new Scanner(System.in);
            FileDatabase fileDatabase = new FileDatabase();

            fileDatabase.getAllPersons();

            String action = "";
            while (!(action.equals("3"))) {
                main.menu();
                action = scanner.nextLine();
                switch (action) {
                    case "1" -> main.addPerson(scanner);
                    case "2" -> System.out.println(fileDatabase.getAllPersons());
                    case "3" -> {
                        System.out.println("Exit");
                        fileDatabase.addPersonToFile(main.persons);
                    }
                    default -> System.out.println("Bloga ivestis");
                }
            }

        }

        private void addPerson(Scanner scanner) throws PersonExeption {

            System.out.print("Iveskite varda: ");
            String name = scanner.nextLine();

            System.out.print("Iveskite pavarde: ");
            String surname = scanner.nextLine();

            System.out.print("Iveskite asmens koda: ");
            long personalNumer = scanner.nextLong();
            scanner.nextLine();

            persons.add(new Person(name, surname, personalNumer));
            checkPersons(new Person(name, surname, personalNumer));
        }

        private Person checkPersons(Person person) throws PersonExeption {
            for (Person personCheck : persons) {
                if (personCheck.getPersonalNumber() == (person.getPersonalNumber())){
                    System.out.println("Vartotojas jau egzistuoja");
                }
            }
            return person;
        }


        private void menu() {
            System.out.println("""
                1 - Prideti useri
                2 - Visi useriai
                """);
        }
    }
