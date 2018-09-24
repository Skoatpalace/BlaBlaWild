package fr.wildcodeschool.blablawild;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Calendar;

public class DateDialog extends DialogFragment implements DatePickerDialog.OnDateSetListener {

    EditText edit_date;
    public DateDialog(View view){
        edit_date = (EditText)view;
    }
    public Dialog onCreateDialog(Bundle saveInstanceState){
        final Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);
        return new DatePickerDialog(getActivity(),this,year,month,day);


    }

    public void onDateSet(DatePicker view, int year, int month, int day){
        String date = day + "-" + (month+1) + "-" + year;
        edit_date.setText(date);
    }
}
