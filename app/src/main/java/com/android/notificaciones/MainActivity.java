package com.android.notificaciones;

import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn1:
                showToast();
                break;
            case R.id.btn2:
                showCustomToast();
                break;
            case R.id.btn3:
                showSnackbar(view);
                break;
            case R.id.btn4:
                showActionSnackbar(view);
                break;
            case R.id.btn5:
                showAlertDialog();
                break;
            case R.id.btn6:
                showAlertDialogConfirm();
                break;
            case R.id.btn7:
                showAlertDialogSelect();
                break;
            case R.id.btn8:
                showAlertDialogSelectSingle();
                break;
            case R.id.btn9:
                showAlertDialogSelectMultiple();
                break;
            case R.id.btn10:
                showAlertDialogCustom();
                break;
        }
    }

    // 5
    private void showAlertDialog() {
        new AlertDialog.Builder(MainActivity.this)
                .setTitle("Título")
                .setMessage("Lorem ipsum dolor sit ammet hbsh jsjsn qer ooori dkff lskfnf d ffskskdj lo.")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .show();
    }

    // 6
    private void showAlertDialogConfirm() {
        new AlertDialog.Builder(MainActivity.this)
                .setIcon(R.drawable.ic_warning)
                .setCancelable(false)
                .setTitle("Título")
                .setMessage("Lorem ipsum dolor sit ammet hbsh jsjsn qer ooori dkff lskfnf d ffskskdj lo.")
                .setPositiveButton("SI", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "SI", Toast.LENGTH_SHORT).show();
                    }
                })
                .setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                }).show();
    }

    // 7
    private void showAlertDialogSelect() {

        final String[] items = {"Español", "Inglés", "Francés"};

        new AlertDialog.Builder(MainActivity.this)
                .setTitle("Seleccione")
                .setItems(items, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int item) {
                        Toast.makeText(MainActivity.this, "Opción elegida: " + items[item], Toast.LENGTH_SHORT).show();
                    }
                })
                .show();
    }

    // 8
    private void showAlertDialogSelectSingle() {

        final String[] items = {"Español", "Inglés", "Francés"};

        new AlertDialog.Builder(MainActivity.this)
                .setTitle("Seleccione")
                .setSingleChoiceItems(items, -1, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int item) {
                        Toast.makeText(MainActivity.this, "Opción elegida: " + items[item], Toast.LENGTH_SHORT).show();
                    }
                })
                .show();
    }

    // 9
    private void showAlertDialogSelectMultiple() {

        final String[] items = {"Español", "Inglés", "Francés"};

        new AlertDialog.Builder(MainActivity.this)
                .setTitle("Seleccione")
                .setMultiChoiceItems(items, null, new DialogInterface.OnMultiChoiceClickListener() {
                    public void onClick(DialogInterface dialog, int item, boolean isChecked) {
                        Toast.makeText(MainActivity.this, "Opción elegida: " + items[item], Toast.LENGTH_SHORT).show();
                    }
                })
                .show();
    }

    // 10
    private void showAlertDialogCustom() {

        Dialog dia = new Dialog(MainActivity.this);
        dia.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dia.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dia.setContentView(R.layout.layout_alert);
        dia.show();

    }

    // 4
    private void showActionSnackbar(View view) {
        Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getApplicationContext(), "CLICK", Toast.LENGTH_SHORT).show();
                    }
                }).show();
    }

    // 3
    private void showSnackbar(View view) {
        Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
    }

    // 2
    private void showCustomToast() {
        Toast toast = new Toast(getApplicationContext());
        View layout = getLayoutInflater().inflate(R.layout.custom_toast,
                (ViewGroup) findViewById(R.id.lytLayout));
        TextView txtMsg = (TextView) layout.findViewById(R.id.txtMensaje);
        txtMsg.setText("Toast Personalizado");
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(layout);
        toast.show();
    }

    // 1
    private void showToast() {
        Toast.makeText(
                this,
                "Toast por defecto",
                Toast.LENGTH_SHORT).show();
    }

}
