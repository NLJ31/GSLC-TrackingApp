package com.example.gslc_nelsonjonathan;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class DialogUtils {
    public interface AddEntryListener {
        void onAddEntry(String name, int amount, double calories);
    }

    public static void openAddEntryDialog(Context context, final AddEntryListener listener) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        LayoutInflater inflater = LayoutInflater.from(context);
        View dialogView = inflater.inflate(R.layout.add_dialog, null);

        final EditText editTextName = dialogView.findViewById(R.id.editTextName);
        final EditText editTextAmount = dialogView.findViewById(R.id.editTextAmount);
        final EditText editTextCalories = dialogView.findViewById(R.id.editTextCalories);
        builder.setView(dialogView)
                .setTitle("Add New Entry")
                .setPositiveButton("Save", new DialogInterface.OnClickListener() {
                    String foodName = editTextName.getText().toString().trim();
                    String caloriesText = editTextCalories.getText().toString().trim();
                    String amountText = editTextAmount.getText().toString().trim();

                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String foodName = editTextName.getText().toString().trim();
                        String caloriesText = editTextCalories.getText().toString().trim();
                        String amountText = editTextAmount.getText().toString().trim();
                        if(TextUtils.isEmpty(foodName) || TextUtils.isEmpty(caloriesText) || TextUtils.isEmpty(amountText)) {
                            Toast.makeText(context, "Fill all fields", Toast.LENGTH_SHORT).show();
                        } else {
                            double cal = Double.parseDouble(caloriesText);
                            int amt = Integer.parseInt(amountText);
                            if (listener != null) {
                                listener.onAddEntry(foodName, amt, cal);
                            }
                        }
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });

        builder.create().show();
    }


}
