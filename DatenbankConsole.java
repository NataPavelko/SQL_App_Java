package Datenbanken;

import java.util.Scanner;

public class DatenbankConsole {

    public static void MainMenu() {


        System.out.println("Willkommen!");
        System.out.println("Was möchten Sie machen? (1) für READ, (2) für INSERT, (3) für UPDATE, (4) für DELETE, (5) für EXIT");
        Scanner scanner = new Scanner(System.in);
        int hauptWahl = scanner.nextInt();


        switch (hauptWahl) {
            case 1:
                Datenbank.Read();
                boolean read = true;

                do {
                    System.out.println("Wollten Sie zurück in Hauptmenu? (1) für Ja, (2) für Nein");
                    int antwort = scanner.nextInt();
                    switch (antwort) {
                        case 1:
                            MainMenu();
                            read = false;
                            break;

                        case 2:
                            Datenbank.Read();
                            break;
                    }

                } while (read == true);
                break;
            case 2:

                boolean insert = true;
                do {

                    System.out.println("Fügen Sie den Artikelnummer ein");
                    int artikelnummer = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Fügen Sie den Artikelname ein");
                    String artikelname = scanner.nextLine();

                    System.out.println("Fügen Sie den Preis ein");
                    double preis = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.println("Fügen Sie die Beschreibung ein");
                    String beschreibung = scanner.nextLine();

                    System.out.println("Fügen Sie den Anzahl der Produkte ein");
                    int anzahl = scanner.nextInt();
                    scanner.nextLine();
                    Produkte produkt = new Produkte(artikelnummer, artikelname, preis, beschreibung, anzahl);
                    Datenbank.Insert(produkt);
                    System.out.println("Neues Produkt: "+" | "+artikelnummer+" | "+preis+" | "+beschreibung+" | "+anzahl+" | ");

                    System.out.println("Wollen Sie noch ein Produkt einfügen? [1] für Ja, [2] für Hauptmenu");
                    int input = scanner.nextInt();
                    switch (input) {
                        case 1:
                            Datenbank.Insert(produkt);
                            break;
                        case 2:
                            MainMenu();
                            insert = false;
                            break;
                    }
                } while (insert == true);

                break;

            case 3:
                boolean update = true;
                boolean exist = true;
                int id = 0;

                do {

                    Produkte produkteToUpdate = null;

                    do {
                        System.out.println("Welchen Artikel wollen Sie ändern? (Fügen Sie ID ein.)");
                        id = scanner.nextInt();

                        produkteToUpdate = Datenbank.GetProductById(id);

                        if(produkteToUpdate == null){
                            System.out.println("Diese ID exestiert nicht!");
                        } else
                            exist = false;

                    } while (exist == true);

                    System.out.println("Aktulle Artikelnummer: " + produkteToUpdate.getArtikelnummer());
                    System.out.println("Fügen Sie einen neuen Artikelnummer ein");
                    int artikelnummer1 = scanner.nextInt();
                    produkteToUpdate.setArtikelnummer(artikelnummer1);
                    scanner.nextLine();

                    System.out.println("Aktulle Artikelnummer: " + produkteToUpdate.getProduktname());
                    System.out.println("Fügen Sie einen neuen Produktname ein");
                    String artikelname1 = scanner.nextLine();
                    produkteToUpdate.setProduktname(artikelname1);

                    System.out.println("Aktulle Preis: " + produkteToUpdate.getPreis());
                    System.out.println("Fügen Sie ein neuen Preis ein");
                    double preis1 = scanner.nextDouble();
                    produkteToUpdate.setPreis(preis1);
                    scanner.nextLine();

                    System.out.println("Aktulle Beschreibung: " + produkteToUpdate.getBeschreibung());
                    System.out.println("Fügen Sie eine neue Beschreibung ein");
                    String beschreibung1 = scanner.nextLine();
                    produkteToUpdate.setBeschreibung(beschreibung1);

                    System.out.println("Aktulle Anzahl der Produkte: " + produkteToUpdate.getAnzahl());
                    System.out.println("Fügen Sie eine neue Anzahl der Produkte ein");
                    int anzahl1 = scanner.nextInt();
                    produkteToUpdate.setAnzahl(anzahl1);
                    scanner.nextLine();

                    //Produkte produkt1 = new Produkte(id, artikelnummer1, artikelname1, preis1, beschreibung1, anzahl1);
                    Datenbank.UpdateProdukt(produkteToUpdate);

                    System.out.println("Wollen Sie noch ein Produkt ändern? [1] für Ja, [2] für Hauptmenu");
                    int input = scanner.nextInt();
                    switch (input) {
                        case 1:
                            Datenbank.UpdateProdukt(produkteToUpdate);
                            break;
                        case 2:
                            MainMenu();
                            update = false;
                            break;
                    }
                } while (update == true);

                break;
            case 4:
                boolean delete = true;
                boolean exist1 =true;
                int id2=0;
                do {
                    do {
                        System.out.println("Welchen Artikel wollen Sie löshen (Fügen Sie ID ein)");
                        id2 = scanner.nextInt();

                        if (Datenbank.CheckProductById(id2) == false) {
                            System.out.println("Diese ID exestiert nicht!");
                        }
                        else{
                            exist1=false;
                            Datenbank.Delete(id2);
                            System.out.println("Produkt mit dem ID: " + id2+" wurde gelöscht.");
                        }
                    }while(exist1==true);

                    System.out.println("Wollen Sie noch ein Produkt löschen? [1] für Ja, [2] für Hauptmenu");
                    int input = scanner.nextInt();
                    switch (input) {
                        case 1:
                            Datenbank.Delete(id2);
                            break;
                        case 2:
                            MainMenu();
                            delete = false;
                            break;
                    }

                } while (delete == true);
                break;
            case 5:
                System.exit(0);
                break;
        }

    }
}



