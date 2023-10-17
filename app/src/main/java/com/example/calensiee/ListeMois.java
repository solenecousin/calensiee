package com.example.calensiee;

import java.util.ArrayList;

public class ListeMois{
    static ArrayList<Mois> listeMois = new ArrayList<>(2);

    //creation d'un mois pour le test

    public ListeMois(){
        Mois novembre = new Mois(30, 11, 2022, 1);
        Mois decembre = new Mois(31, 12, 2022, 3);
        Jour karaoke = new Jour(true, 6, 11, 2022, 18, 2, "Karaoke", "Amphi 210", "Karaoke organisé par le Club Chorale", 5);
        Jour jpo = new Jour(true, 15, 11, 2022, 13, 4, "JPO", "ESIEE", "JPO", 0);
        Jour blindtest = new Jour(true, 15, 11, 2022, 19, 1, "BlindTest", "Foyer", "Blindtest organisé au foyer", 0);
        //ajouter l'evenement au mois
        novembre.setEvent(karaoke.getJour(), karaoke);
        novembre.setEvent(jpo.getJour(), jpo);
        decembre.setEvent(blindtest.getJour(), blindtest);

        listeMois.add(novembre);
        listeMois.add(decembre);
    }


    public static ArrayList<Mois> getDatalist() {
        return listeMois;
    }
}
