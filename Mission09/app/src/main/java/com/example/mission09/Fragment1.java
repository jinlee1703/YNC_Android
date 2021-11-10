package com.example.mission09;

import android.app.DatePickerDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class Fragment1 extends Fragment {
    EditText nameText;
    EditText ageText;
    Button birthButton;
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    Date selectedDate;
    Button confirmButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment1, container, false);

        nameText = rootView.findViewById(R.id.nameText);
        ageText = rootView.findViewById(R.id.ageText);

        birthButton = rootView.findViewById(R.id.birthButton);
        selectedDate = Calendar.getInstance().getTime();
        birthButton.setText(dateFormat.format(selectedDate));
        birthButton = rootView.findViewById(R.id.birthButton);
        birthButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("클릭 : ", "성공");
                showDateDialog();
            }
        });

        confirmButton = rootView.findViewById(R.id.button2);
        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "이름 : " + nameText.getText() + ", 나이 : " + ageText.getText() + ", 생년월일 : " + birthButton.getText(), Toast.LENGTH_SHORT).show();
            }
        });

        return rootView;
    }

    private void showDateDialog() {
        String birthDateStr = birthButton.getText().toString();

        Calendar calendar = Calendar.getInstance();
        Date curBirthDate = new Date();
        try {
            curBirthDate = dateFormat.parse(birthDateStr);
        } catch(Exception ex) {
            ex.printStackTrace();
        }

        calendar.setTime(curBirthDate);

        int curYear = calendar.get(Calendar.YEAR);
        int curMonth = calendar.get(Calendar.MONTH);
        int curDay = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog dialog = new DatePickerDialog(getContext(), birthDateSetListener,  curYear, curMonth, curDay);
        dialog.show();
    }

    private DatePickerDialog.OnDateSetListener birthDateSetListener = new DatePickerDialog.OnDateSetListener() {
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            Calendar selectedCal = Calendar.getInstance();
            selectedCal.set(Calendar.YEAR, year);
            selectedCal.set(Calendar.MONTH, monthOfYear);
            selectedCal.set(Calendar.DAY_OF_MONTH, dayOfMonth);

            Date curDate = selectedCal.getTime();
            birthButton.setText(dateFormat.format(curDate));
        }
    };
}