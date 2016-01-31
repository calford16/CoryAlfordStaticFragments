package edu.westga.coryalfordstaticfragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class DataDisplayFragmentTwo extends Fragment {

    TextView sum;
    double number1;
    double number2;
    double sumDouble;

    public void setNumber1(double number1) {
        this.number1 = number1;
    }

    public void setNumber2(double number2) {
        this.number2 = number2;
    }
    public DataDisplayFragmentTwo() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View theView = inflater.inflate(R.layout.fragment_data_display_fragment_two, container, false);

        this.sum = (TextView) theView.findViewById(R.id.textView2);

        return theView;
    }

    public void add() {
        this.sumDouble = this.number1 + this.number2;
    }

    public void displaySum() {
        this.sum.setText(Double.toString(sumDouble));
    }
}
