package fr.wildcodeschool.blablawild;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ItinerarySearchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_itinerary_search);

        Button buttonItinerary = findViewById(R.id.button_itinerary);
        buttonItinerary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText textDepart = findViewById(R.id.edit_departure);
                EditText textDestination = findViewById(R.id.edit_destination);
                EditText textdate = findViewById(R.id.edit_date);
                String departureValue = textDepart.getText().toString();
                String destinationValue = textDestination.getText().toString();
                String dateValue = textdate.getText().toString();
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
