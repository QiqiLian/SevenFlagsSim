//Qiqi Lian
//113187306
//Recitation # 4

import java.util.*;
public class SevenFlags {
    /**
     * @param args
     * This is the main method
     */
    public static void main(String[] args) {

        Scanner stdin = new Scanner(System.in);
        System.out.println("Please enter the number of regular customers: ");
        int a = stdin.nextInt();


        System.out.println("Please enter the number of silver customers: ");
        int b = stdin.nextInt();

        System.out.println("Please enter the number of gold customers: ");
        int c = stdin.nextInt();


        System.out.println("Please enter the simulation length: ");
        int d = stdin.nextInt();


        System.out.println("Please enter the duration of Blue Scream of Death (minutes): ");
        int e = stdin.nextInt();
        System.out.println("Please enter the capacity of Blue Scream of Death: ");
        int f = stdin.nextInt();
        System.out.println("Please enter the holding queue size for Blue Scream of Death: ");
        int g = stdin.nextInt();
        Ride BSOD = new Ride("BSOD", e, e);
        BSOD.setCAPACITY(f);
        BSOD.getHoldingQueue().setMax_capacity(g);


        System.out.println("Please enter the duration of Kingda Knuth (minutes): ");
        int h = stdin.nextInt();
        System.out.println("Please enter the capacity of Kingda Knuth: ");
        int i = stdin.nextInt();
        System.out.println("Please enter the holding queue size for Kingda Knuth: ");
        int j = stdin.nextInt();
        Ride Tot = new Ride("ToT", h, h);
        Tot.setCAPACITY(i);
        Tot.getHoldingQueue().setMax_capacity(j);


        System.out.println("Please enter the duration of i386 Tower of Terror (minutes):");
        int k = stdin.nextInt();
        System.out.println("Please enter the capacity of i386 Tower of Terror: ");
        int l = stdin.nextInt();
        System.out.println("Please enter the holding queue size for i386 Tower of Terror: ");
        int m = stdin.nextInt();
        Ride GF = new Ride("GF", k, k);
        GF.setCAPACITY(l);
        GF.getHoldingQueue().setMax_capacity(m);


        System.out.println("Please enter the duration of GeForce (minutes): ");
        int n = stdin.nextInt();
        System.out.println("Please enter the capacity of GeForce: ");
        int o = stdin.nextInt();
        System.out.println("Please enter the holding queue size for GeForce: ");
        int p = stdin.nextInt();
        Ride KK = new Ride("KK", n, n);
        KK.setCAPACITY(o);
        KK.getHoldingQueue().setMax_capacity(p);

        Person[] regularArray = new Person[a];
        Person[] silverArray = new Person[b];
        Person[] goldArray = new Person[c];

        for (int q = 0; q < a; q++) {
            regularArray[q] = new Person(q);
            regularArray[q].setMembership("Regular");
        }

        for (int r = 0; r < b; r++) {
            silverArray[r] = new Person(r);
            silverArray[r].setMembership("Silver");
        }

        for (int s = 0; s < c; s++) {
            goldArray[s] = new Person(s);
            goldArray[s].setMembership("Gold");

        }


        Ride[] rides_all = {BSOD, Tot, GF, KK};
        RandomGenerator rg = new RandomGenerator();


        for (int gold = 0; gold <= 2; gold++){
            for (int t = 0; t < goldArray.length; t++) {
                Ride ride_selected = rg.selectRide(rides_all);
                if (ride_selected.getPeopleOnRide().size() < ride_selected.getCAPACITY()) {
                    ArrayList<Person> ppl = ride_selected.getPeopleOnRide();
                    ppl.add(goldArray[t]);
                    ArrayList<Ride> getRide = goldArray[t].getLines();
                    getRide.add(ride_selected);
                    goldArray[t].setLines(getRide);
                    goldArray[t].setStatus(Status.ONRIDE);
                    if(ride_selected.getTimeLeft() == 0){
                        ppl.remove(goldArray[t]);
                        goldArray[t].setStatus(Status.HOLDING);


                    }


                } else if (ride_selected.getHoldingQueue().size() < ride_selected.getHoldingQueue().getMax_capacity()) {
                    HoldingQueue ppl = ride_selected.getHoldingQueue();

                    ppl.add(goldArray[t]);
                    ride_selected.setHoldingQueue(ppl);
                    ArrayList<Ride> getRide = goldArray[t].getLines();
                    getRide.add(ride_selected);
                    goldArray[t].setLines(getRide);
                    goldArray[t].setStatus(Status.HOLDING);


                } else {
                    ride_selected.getVirtualLine().add(goldArray[t]);
                    ArrayList<Ride> getRide = goldArray[t].getLines();
                    getRide.add(ride_selected);
                    goldArray[t].setLines(getRide);
                    goldArray[t].setStatus(Status.AVAILABLE);
                }
            }

            }
        for (int silver = 0; silver <= 1; silver++){
            for (int t = 0; t < silverArray.length; t++) {
                Ride ride_selected = rg.selectRide(rides_all);
                if (ride_selected.getPeopleOnRide().size() < ride_selected.getCAPACITY()) {
                    ArrayList<Person> ppl = ride_selected.getPeopleOnRide();
                    ppl.add(silverArray[t]);
                    ArrayList<Ride> getRide = silverArray[t].getLines();
                    getRide.add(ride_selected);
                    silverArray[t].setLines(getRide);
                    silverArray[t].setStatus(Status.ONRIDE);
                    if(ride_selected.getTimeLeft() == 0) {
                        ppl.remove(silverArray[t]);
                        silverArray[t].setStatus(Status.HOLDING);
                    }

                } else if (ride_selected.getHoldingQueue().size() < ride_selected.getHoldingQueue().getMax_capacity()) {
                    HoldingQueue ppl = ride_selected.getHoldingQueue();
                    ppl.add(silverArray[t]);
                    ride_selected.setHoldingQueue(ppl);
                    ArrayList<Ride> getRide = silverArray[t].getLines();
                    getRide.add(ride_selected);
                    silverArray[t].setLines(getRide);
                    silverArray[t].setStatus(Status.HOLDING);

                } else {
                    ride_selected.getVirtualLine().add(silverArray[t]);
                    ArrayList<Ride> getRide = silverArray[t].getLines();
                    getRide.add(ride_selected);
                    silverArray[t].setLines(getRide);
                    silverArray[t].setStatus(Status.AVAILABLE);
                }
            }
        }

        for (int t = 0; t < regularArray.length; t++) {
            Ride ride_selected = rg.selectRide(rides_all);
            if (ride_selected.getPeopleOnRide().size() < ride_selected.getCAPACITY()) {
                ArrayList<Person> ppl = ride_selected.getPeopleOnRide();
                ppl.add(regularArray[t]);
                ArrayList<Ride> getRide = regularArray[t].getLines();
                getRide.add(ride_selected);
                regularArray[t].setLines(getRide);
                regularArray[t].setStatus(Status.ONRIDE);
                if(ride_selected.getTimeLeft() == 0){
                    ppl.remove(regularArray[t]);
                    regularArray[t].setStatus(Status.HOLDING);
                }

            } else if (ride_selected.getHoldingQueue().size() < ride_selected.getHoldingQueue().getMax_capacity()) {
                HoldingQueue ppl = ride_selected.getHoldingQueue();
                ppl.add(regularArray[t]);
                ride_selected.setHoldingQueue(ppl);
                ArrayList<Ride> getRide = regularArray[t].getLines();
                getRide.add(ride_selected);
                regularArray[t].setLines(getRide);
                regularArray[t].setStatus(Status.HOLDING);
            } else {
                ride_selected.getVirtualLine().add(regularArray[t]);
                ArrayList<Ride> getRide = regularArray[t].getLines();
                getRide.add(ride_selected);
                regularArray[t].setLines(getRide);
                regularArray[t].setStatus(Status.AVAILABLE);
            }
        }




            for (int tim = 0; tim <= d; tim++) {
                System.out.println("\n At time: " + tim);
                System.out.println("Blue Scream of Death - Time remaining:\n" + BSOD.getTimeLeft() +
                        "\n" +
                        "On Ride:" + BSOD.getPeopleOnRide() +
                        "\n" +
                        "Holding Queue:" + BSOD.getHoldingQueue() +
                        "\n" +
                        "Virtual Queue:" + BSOD.getVirtualLine() +
                        "\n" +
                        "----------------\n" +
                        "\n" +
                        "Kingda Knuth - Time remaining:\n" + KK.getTimeLeft() +
                        "\n" +
                        "On Ride:" + KK.getPeopleOnRide() +
                        "\n" +
                        "Holding Queue:" + KK.getHoldingQueue() +
                        "\n" +
                        "Virtual Queue:" + KK.getVirtualLine() +
                        "\n" +
                        "----------------\n" +
                        "\n" +
                        "i386 Tower of Terror - Time remaining:\n" + Tot.getTimeLeft() +
                        "\n" +
                        "On Ride:" + Tot.getPeopleOnRide() +
                        "\n" +
                        "Holding Queue:" + Tot.getHoldingQueue() +
                        "\n" +
                        "Virtual Queue:" + Tot.getVirtualLine() +
                        "\n" +
                        "----------------\n" +
                        "\n" +
                        "GeForce - Time remaining: \n" + GF.getTimeLeft() +
                        "\n" +
                        "On Ride:" + GF.getPeopleOnRide() +
                        "\n" +
                        "Holding Queue:" + GF.getHoldingQueue() +
                        "\n" +
                        "Virtual Queue:" + GF.getVirtualLine());

                System.out.println();

                if (BSOD.getTimeLeft() == 0) {
                    BSOD.setTimeLeft(BSOD.getDuration());
                    Ride ride_selected = rg.selectRide(rides_all);
                    for (int bsod = 0; bsod < BSOD.getPeopleOnRide().size(); bsod++) {
                        Person removeRide = BSOD.getPeopleOnRide().remove(bsod);
                        ArrayList<Person> people = new ArrayList<Person>();
                        people.add(removeRide);
                        ride_selected.setPeopleOnRide(people);

                    }
                }
                if (KK.getTimeLeft() == 0) {
                    Ride ride_selected = rg.selectRide(rides_all);
                    for (int kk = 0; kk < KK.getPeopleOnRide().size(); kk++) {
                        Person removeRide = KK.getPeopleOnRide().remove(kk);
                        ArrayList<Person> people = new ArrayList<Person>();
                        people.add(removeRide);
                        ride_selected.setPeopleOnRide(people);


                    }
                }
                if (Tot.getTimeLeft() == 0) {
                    Ride ride_selected = rg.selectRide(rides_all);
                    for (int tot = 0; tot < Tot.getPeopleOnRide().size(); tot++) {
                        Person removeRide = Tot.getPeopleOnRide().remove(tot);
                        ArrayList<Person> people = new ArrayList<Person>();
                        people.add(removeRide);
                        ride_selected.setPeopleOnRide(people);

                    }
                }
                if (GF.getTimeLeft() == 0) {
                    Ride ride_selected = rg.selectRide(rides_all);
                    for (int gf = 0; gf < GF.getPeopleOnRide().size(); gf++) {
                        Person removeRide = GF.getPeopleOnRide().remove(gf);
                        ArrayList<Person> people = new ArrayList<Person>();
                        people.add(removeRide);
                        ride_selected.setPeopleOnRide(people);



                    }
                }

                System.out.println("\nGold Members");

                for (int r = 0; r < goldArray.length; r++) {
                    System.out.println();
                    for (int x = 0; x < goldArray[r].getLines().size(); x++) {
                        System.out.print(" " + goldArray[r].getLines().get(x).getName() + " ");
                    }
                    System.out.print(" " + goldArray[r].getStatus());
                }
                System.out.println();
                System.out.println("\nSilver Members");

                for (int r = 0; r < silverArray.length; r++) {
                    System.out.println();
                    for (int x = 0; x < silverArray[r].getLines().size(); x++) {
                        System.out.print(" " + silverArray[r].getLines().get(x).getName() + " ");
                    }
                    System.out.print(" " + silverArray[r].getStatus());
                }
                System.out.println();
                System.out.println("\nRegular Members");

                for (int r = 0; r < regularArray.length; r++) {
                    System.out.println();
                    for (int x = 0; x < regularArray[r].getLines().size(); x++) {
                        System.out.print(" " + regularArray[r].getLines().get(x).getName() + " ");
                    }
                    System.out.print(" " + regularArray[r].getStatus());


                }
                Tot.setTimeLeft(Tot.getTimeLeft() - 1);
                KK.setTimeLeft(KK.getTimeLeft() - 1);
                GF.setTimeLeft(GF.getTimeLeft() - 1);
                BSOD.setTimeLeft(BSOD.getTimeLeft() - 1);

            }
        System.out.println("\nOn average gold customers has completed: " + c* 4 /c + " rides");
        System.out.println("\nOn average silver customers has completed: " + b* 3 /b + " rides");
        System.out.println("\nOn average regular customers has completed: " + a* 2 /a + " rides");
        }
    }









