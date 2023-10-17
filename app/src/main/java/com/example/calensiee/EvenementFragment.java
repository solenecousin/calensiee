package com.example.calensiee;

import android.os.Bundle;

import android.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link EvenementFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class EvenementFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER


    // TODO: Rename and change types of parameters

    public EvenementFragment() {
        // Required empty public constructor
    }



    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment EvenementFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static EvenementFragment newInstance(String param1, String param2) {
        EvenementFragment fragment = new EvenementFragment();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View myView = inflater.inflate(R.layout.fragment_evenement, container, false);

        ListeMois listeMois = new ListeMois();
        Mois mois = listeMois.getDatalist().get(Integer.parseInt(getArguments().getString("monthEvent"))-11);
        ArrayList <Jour> listeJours = mois.getListeJours();
        Jour jour = listeJours.get(Integer.parseInt(getArguments().getString("dayEvent")));

        TextView nomEvent = (TextView)myView.findViewById(R.id.Nom_Event);
        nomEvent.setText(jour.getNom());

        TextView dateHeureDetail = (TextView)myView.findViewById(R.id.Date_et_Heure_detail);
        dateHeureDetail.setText("Le "+jour.getJour()+"/"+jour.getMois()+"/"+jour.getAnnee()+", à "+jour.getHeure()+"H");

        TextView localisationDetail = (TextView)myView.findViewById(R.id.Localisation_detail);
        localisationDetail.setText(jour.getLieu());

        TextView commentairesDetail = (TextView)myView.findViewById(R.id.Commentaires_detail);
        commentairesDetail.setText(jour.getCommentaire());

        TextView prixDetail = (TextView)myView.findViewById(R.id.Prix_detail);
        float prix=jour.getPrix();
        if (prix>0){
            prixDetail.setText(prix+"€");
        }
        else{
            prixDetail.setText("Gratuit !");
        }


        Toast.makeText(getActivity(), listeJours.get(Integer.parseInt(getArguments().getString("dayEvent"))).getNom(), Toast.LENGTH_SHORT).show();
        return myView;
    }
}