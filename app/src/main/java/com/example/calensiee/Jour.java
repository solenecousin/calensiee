package com.example.calensiee;

public class Jour {
    boolean event;
    int jour;
    int mois;
    int annee;
    int heure;
    int duree;
    String nom;
    String lieu;
    String commentaire;
    float prix;

    public Jour(boolean event, int jour, int mois, int annee, int heure, int duree, String nom, String lieu, String commentaire, float prix) {
        this.event = event;
        this.jour = jour;
        this.mois = mois;
        this.annee = annee;
        //heure
        this.heure = heure;
        this.duree = duree;
        this.nom = nom;
        this.lieu = lieu;
        this.commentaire = commentaire;
        this.prix = prix;
    }





    public void setEvent(boolean event) {
        this.event = event;
    }

    public void setJour(int jour) {
        this.jour = jour;
    }

    public void setMois(int mois) {
        this.mois = mois;
    }

    public void setAnnee(int annee) {
        this.annee = annee;
    }

    public void setHeure(int heure) {
        this.heure = heure;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public boolean isEvent() {
        return event;
    }

    public int getJour() {
        return jour;
    }

    public int getMois() {
        return mois;
    }

    public int getAnnee() {
        return annee;
    }

    public int getHeure() {
        return heure;
    }

    public int getDuree() {
        return duree;
    }

    public String getNom() {
        return nom;
    }

    public String getLieu() {
        return lieu;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public float getPrix() {
        return prix;
    }


}
