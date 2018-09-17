package fr.wildcodeschool.blablawild;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Date;

public class ItinerarySearchActivity extends AppCompatActivity {
    private static final String TAG =  "ItinerarySearchActivity";

    private EditText mDisplayDate;
    private DatePickerDialog.OnDateSetListener mDateSetListener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_itinerary_search);
        mDisplayDate = findViewById(R.id.edit_date);

        mDisplayDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        ItinerarySearchActivity.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        mDateSetListener,
                        year,month,day);

                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();

            }
        });


        mDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                month = month + 1;
                Log.d(TAG, "dd/mm/yyyy: " + dayOfMonth + "/" + month + "/" +year);

                String date = dayOfMonth + "/" + month + "/" +year;
                mDisplayDate.setText(date);

            }
        };











        Button buttonItinerary = findViewById(R.id.button_itinerary);
        buttonItinerary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText textDepart = findViewById(R.id.edit_departure);
                EditText textDestination = findViewById(R.id.edit_destination);
                EditText mDisplayDate = findViewById(R.id.edit_date);
                String departureValue = textDepart.getText().toString();
                String destinationValue = textDestination.getText().toString();
                String dateValue = mDisplayDate.getText().toString();
                if (departureValue.isEmpty() || destinationValue.isEmpty()){
                    Toast.makeText(ItinerarySearchActivity.this, R.string.toastText, Toast.LENGTH_LONG).show();
                }else{

                    Intent giveItinerary = new Intent(ItinerarySearchActivity.this, ItineraryListActivity.class);
                    giveItinerary.putExtra("Depart",textDepart.getText().toString());
                    giveItinerary.putExtra("Destination",textDestination.getText().toString());
                    startActivity(giveItinerary);
                }
            }
        });


    }

}
