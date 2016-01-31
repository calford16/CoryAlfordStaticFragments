package edu.westga.coryalfordstaticfragments;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class DataDisplayFragment extends Fragment {

    TextView product;
    double number1;
    double number2;
    double productDouble;
    DataAddListener listener;

    public interface DataAddListener {
        void onDataAdd(double number1, double number2);
    }

    public void setNumber1(double number1) {
        this.number1 = number1;
    }

    public void setNumber2(double number2) {
        this.number2 = number2;
    }

    public DataDisplayFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View theView = inflater.inflate(R.layout.fragment_data_display, container, false);

        Button addButton = (Button) theView.findViewById(R.id.add_button);
        addButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                addButtonClicked(v);
            }
        });

        this.product = (TextView) theView.findViewById(R.id.textView);

        return theView;
    }

    public void multiply() {
        this.productDouble = this.number1 * this.number2;
    }

    public void displayProduct() {
        this.product.setText(Double.toString(productDouble));
    }

    private void addButtonClicked(View v) {
        listener.onDataAdd(number1, number2);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.listener = (DataAddListener) context;
    }
}
