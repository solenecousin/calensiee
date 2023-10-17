package com.example.calensiee;

import java.util.ArrayList;

public class Mois {
    ArrayList<Jour> listeJours = new ArrayList<>(31);
    ArrayList<Integer> listeEvents=new ArrayList<>();
    int tailleMois;
    int numeroMois;
    int annee;
    int premierJour;

    public Mois(int tailleMois, int numeroMois, int annee, int premierJour) {
        this.listeJours=listeJours;
        this.tailleMois=tailleMois;
        this.numeroMois=numeroMois;
        this.annee=annee;
        this.premierJour=premierJour;

        for(int k=0; k<tailleMois;k++ ){
            Jour jour = new Jour(false, k+1, numeroMois, annee, 0, 0, "", "", "", 0);
            listeJours.add(jour);

        }
    }

    public ArrayList<Jour> getListeJours() {
        return listeJours;
    }
    public int getTailleMois() {
        return tailleMois;
    }
    public int getNumeroMois() {
        return numeroMois;
    }
    public int getAnnee() {
        return annee;
    }
    public int getPremierJour() {
        return premierJour;
    }

    public ArrayList<Integer> getListeEvents(){
        return listeEvents;
    }

    public void setListeJours() {
        this.listeJours=listeJours;
    }
    public void setTailleMois() {
        this.tailleMois=tailleMois;
    }
    public void setNumeroMois(){
        this.numeroMois=numeroMois;
    }
    public void setAnnee() {
        this.annee=annee;
    }
    public void setPremierJour(){
        this.premierJour=premierJour;
    }



    public void setEvent(int dateJour, Jour jour) {
        listeJours.set(dateJour, jour);
        listeEvents.add(dateJour);
    }



}
