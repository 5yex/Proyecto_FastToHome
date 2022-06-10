package com.proyecto.fasttohome.vista.pedido;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.NumberPicker;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;

public class seleccionarCantidad extends DialogFragment
    {
        private NumberPicker.OnValueChangeListener valueChangeListener;
        int min, max, current;
        String title;

        public seleccionarCantidad(int min, int max, String title, int current)
        {
            this.min = min;
            this.max = max;
            this.title = title;
            this.current = current;
        }

        @NonNull
        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState)
        {

            final NumberPicker numberPicker = new NumberPicker(getActivity());

            numberPicker.setMinValue(min);
            numberPicker.setMaxValue(max);
            numberPicker.setValue(current);
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            builder.setTitle(title);
            builder.setCancelable(false); //this doesn't work
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener()
            {
                @Override
                public void onClick(DialogInterface dialog, int which)
                {
                    valueChangeListener.onValueChange(numberPicker,
                            numberPicker.getValue(), numberPicker.getValue());
                }
            });


            builder.setView(numberPicker);
            return builder.create();
        }

        void setValueChangeListener(NumberPicker.OnValueChangeListener valueChangeListener)
        {
            this.valueChangeListener = valueChangeListener;
        }
    }

