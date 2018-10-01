package fr.wildcodeschool.blablawild;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import org.fabiomsr.moneytextview.MoneyTextView;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;

public class TripAdapter extends ArrayAdapter<TripModel> {

    public TripAdapter(Context context, ArrayList<TripModel> trips) {
        super(context, 0, trips);



    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // Get the data item for this position
        TripModel trip = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_trip, parent, false);
        }
        // Lookup view for data population
        TextView firstname = convertView.findViewById(R.id.text_firstname);
        TextView lastname = convertView.findViewById(R.id.text_lastname);
        TextView dateHours = convertView.findViewById(R.id.date_date);
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy-kk:mm", Locale.FRANCE);
        MoneyTextView money = convertView.findViewById(R.id.money_price);
        // Populate the data into the template view using the data object
        firstname.setText(trip.getFirstname());
        lastname.setText(trip.getLastname());
        dateHours.setText(sdf.format(trip.getDate()));
        money.setAmount(trip.getPrice());


        // Return the completed view to render on screen
        return convertView;
    }
}