package com.example.calensiee;

import android.content.Context;
import android.graphics.Color;
import android.graphics.fonts.Font;
import android.os.Build;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class MoisFragment extends Fragment implements AdapterView.OnItemClickListener{


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private GridView gridView;


    // TODO: Rename and change types of parameters


    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

    }


    interface OnItemClickListener {
        void onItemSelectedJour(int position, ArrayList<Integer> dayEvent);
    }

    private MoisFragment.OnItemClickListener callback;

    public MoisFragment() {
        // Required empty public constructor
    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        // This makes sure that the host activity has implemented the callback interface
        // If not, it throws an exception
        try {
            callback = (MoisFragment.OnItemClickListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + " must implement OnItemClickListener");
        }
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.

     * @return A new instance of fragment MoisFragment.
     */
    // TODO: Rename and change types and number of parameters



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View myView = inflater.inflate(R.layout.fragment_mois, container, false);
        this.gridView = (GridView)myView.findViewById(R.id.gridView);
        ListeMois listeMois = new ListeMois();
        Mois mois = listeMois.getDatalist().get(0);
        ArrayList<String> Annee = new ArrayList<String>(12){{
            for(int i=0; i<10; i++) add("");
            add("Novembre");
            add("Decembre");
        }};

        TextView nomMois = (TextView)myView.findViewById(R.id.Nom_Mois);
        nomMois.setText(Annee.get(mois.getNumeroMois()-1));


        //Toast.makeText(getActivity(), mois.getListeJours().get(0).getJour(), Toast.LENGTH_SHORT).show();

        //tableau d'entiers pour afficher dans le calendrier
        ArrayList<String > numerosMois = new ArrayList<>(mois.getTailleMois());
        for(int k=0; k<mois.getPremierJour(); k++){
            numerosMois.add("");
        }
        for(int k=0; k<=mois.getTailleMois();k++){
            numerosMois.add(String.valueOf(k+1));
        }


        //Afficher le calendrier
        //ArrayAdapter<String> arrayAdapter
        //= new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1,numerosMois );
        ArrayAdapter<String> arrayAdapter
                = new ArrayAdapter<String>(getActivity(), R.layout.grid_view_item_1,numerosMois );

        gridView.setAdapter(arrayAdapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                callback.onItemSelectedJour(i, mois.getListeEvents());
            }
            /*@Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }*/
        });
        gridView.getViewTreeObserver().addOnGlobalLayoutListener(
                new ViewTreeObserver.OnGlobalLayoutListener() {
                    @Override
                    public void onGlobalLayout() {
                        //Changer la couleur de l'element si il y a un evenement ce jour là
                        for (int k = 0; k < mois.tailleMois; k++) {
                            if (mois.getListeJours().get(k).isEvent()) {
                                //gridView.getChildAt(k).setBackgroundColor(Color.parseColor("#18A608"));
                                gridView.getChildAt(k).setBackgroundColor(0xFF0000FF);
                                //Toast.makeText(getActivity(), Novembre.get(k).getNom(), Toast.LENGTH_SHORT).show();

                            }
                        }
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                            gridView.getViewTreeObserver()
                                    .removeOnGlobalLayoutListener(this);
                        } else {
                            gridView.getViewTreeObserver()
                                    .removeGlobalOnLayoutListener(this);
                        }

                    }
                }
        );
        return myView;
    }
}