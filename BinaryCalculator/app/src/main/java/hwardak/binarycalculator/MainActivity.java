//Hasib Wardak 

package hwardak.binarycalculator;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView hexTextView;
    TextView decTextView;
    TextView binTextView;
    TextView octTextView;
    TextView iEEETextView;

    TextView hexTitleTextView;
    TextView decTitleTextView;
    TextView binTitleTextView;
    TextView octTitleTextView;

    TextView focusedTextView;

    Button binaryDeleteButton;
    Button decimalDeleteButton;
    Button octalDeleteButton;
    Button hexDeleteButton;

    FrameLayout binaryKeyboardLayout;// = (FrameLayout) findViewById(R.id.binaryKeyboardLayout);
    FrameLayout decimalKeyboardLayout;// = (FrameLayout) findViewById(R.id.decimalKeyboardLayout);
    FrameLayout octalKeyboardLayout;
    FrameLayout hexKeyboardLayout;


    InputMethodManager inputMethodManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        hexTextView = (TextView) findViewById(R.id.HexEditText);
        decTextView = (TextView) findViewById(R.id.DecEditText);
        binTextView = (TextView) findViewById(R.id.BinaryEditText);
        octTextView = (TextView) findViewById(R.id.OctalEditText);
        iEEETextView = (TextView) findViewById(R.id.iEEEEditText);

        hexTitleTextView = (TextView) findViewById(R.id.hexTitleTextView);
        decTitleTextView = (TextView) findViewById(R.id.decTitleTextView);
        binTitleTextView = (TextView) findViewById(R.id.binTitleTextView);
        octTitleTextView = (TextView) findViewById(R.id.octTitleTextView);

        decimalDeleteButton = (Button) findViewById(R.id.decimalDeleteButton);
        binaryDeleteButton = (Button) findViewById(R.id.binaryDeleteButton);
        octalDeleteButton = (Button) findViewById(R.id.octalDeleteButton);
        hexDeleteButton = (Button) findViewById(R.id.hexDeleteButton);


        inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);

        binaryKeyboardLayout = (FrameLayout) findViewById(R.id.binaryKeyboardLayout);
        decimalKeyboardLayout = (FrameLayout) findViewById(R.id.decimalKeyboardLayout);
        octalKeyboardLayout = (FrameLayout) findViewById(R.id.octalKeyboardLayout);
        hexKeyboardLayout = (FrameLayout) findViewById(R.id.hexKeyboardLayout);

        hexTextView.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus)
                    Toast.makeText(getApplicationContext(), "onFocusChange", Toast.LENGTH_LONG).show();
                hexOnClick(hexTextView);
            }
        });


        decTextView.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus)
                    Toast.makeText(getApplicationContext(), "onFocusChange", Toast.LENGTH_LONG).show();
                decimalOnClick(decTextView);
            }
        });


        binTextView.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus)
                    Toast.makeText(getApplicationContext(), "onFocusChange", Toast.LENGTH_LONG).show();
                binaryOnClick(binTextView);
            }
        });


        octTextView.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus)
                    Toast.makeText(getApplicationContext(), "onFocusChange", Toast.LENGTH_LONG).show();
                octalOnClick(octTextView);
            }
        });


        iEEETextView.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus)
                    Toast.makeText(getApplicationContext(), "onFocusChange", Toast.LENGTH_LONG).show();
                iEEEOnClick(iEEETextView);
            }
        });

        resetBackgroundColors();

    }

    public void iEEEOnClick(View view) {
        hideAllKeyboards();
        binaryKeyboardLayout.setVisibility(View.VISIBLE);
        focusedTextView = (TextView) view;
        resetBackgroundColors();
        view.setBackgroundColor(0);
        if(((TextView) view).getText().toString().length() > 1 ){
            hexDeleteButton.setEnabled(true);
        } else {
            hexDeleteButton.setEnabled(false);
        }
    }

    public void hexOnClick(View view) {
        hideAllKeyboards();
        hexKeyboardLayout.setVisibility(View.VISIBLE);
        focusedTextView = (TextView) view;
        resetBackgroundColors();
        view.setBackgroundColor(0);
        if(((TextView) view).getText().toString().length() > 1 ){
            hexDeleteButton.setEnabled(true);
        } else {
            hexDeleteButton.setEnabled(false);
        }

    }


    public void octalOnClick(View view) {
        hideAllKeyboards();
        octalKeyboardLayout.setVisibility(View.VISIBLE);
        focusedTextView = (TextView) view;
        resetBackgroundColors();
        view.setBackgroundColor(0);
        if(((TextView) view).getText().toString().length() > 1 ){
            octalDeleteButton.setEnabled(true);
        } else {
            octalDeleteButton.setEnabled(false);
        }

    }

    public void binaryOnClick(View view) {
        hideAllKeyboards();
        binaryKeyboardLayout.setVisibility(View.VISIBLE);
        focusedTextView = (TextView) view;
        resetBackgroundColors();
        view.setBackgroundColor(0);
        if(((TextView) view).getText().toString().length() > 1 ){
            binaryDeleteButton.setEnabled(true);
        } else {
            binaryDeleteButton.setEnabled(false);
        }


    }

    private void surpressSoftKeyboard(View view){
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);

    }

    public void decimalOnClick(View view) {
//        surpressSoftKeyboard(view);
        hideAllKeyboards();
        decimalKeyboardLayout.setVisibility(View.VISIBLE);
        focusedTextView = (TextView) view;
        resetBackgroundColors();
        view.setBackgroundColor(0);
        if(((TextView) view).getText().toString().length() > 1 ){
            decimalDeleteButton.setEnabled(true);
        } else {
            decimalDeleteButton.setEnabled(false);
        }


    }

    private void resetBackgroundColors(){
        decTextView.setBackgroundColor(getResources().getColor(R.color.decBlue));
        binTextView.setBackgroundColor(getResources().getColor(R.color.binBlue));
        octTextView.setBackgroundColor(getResources().getColor(R.color.octBlue));
        hexTextView.setBackgroundColor(getResources().getColor(R.color.hexBlue));
        iEEETextView.setBackgroundColor(getResources().getColor((R.color.iEEE)));

    }



    public void inputChar(View view) {
        Button button = (Button) view;
        setDeleteButtonsEnabled(true);

        String s = focusedTextView.getText().toString();// + button.getText().toString();

        if(s == ""){
            s = button.getText().toString();
        } else {
            s = focusedTextView.getText().toString() + button.getText().toString();
        }

        focusedTextView.setText(s);
        sortForConversion(s);


    }

    public void deleteChar(View view){
        String s = "";

        if(focusedTextView.getText().toString().length() >= 1){
            Log.d("FocusedTextView: ", ""+ focusedTextView.getText().toString().length());
            s = focusedTextView.getText().toString().substring(0, focusedTextView.getText().toString().length() -1);
        } else {
            setDeleteButtonsEnabled(false);
            s ="";
        }

        focusedTextView.setText(s);
        sortForConversion(s);
    }


    private void setDeleteButtonsEnabled(boolean enabled){
        decimalDeleteButton.setEnabled(enabled);
        binaryDeleteButton.setEnabled(enabled);
        octalDeleteButton.setEnabled(enabled);
        hexDeleteButton.setEnabled(enabled);
    }
    private void hideAllKeyboards(){
        binaryKeyboardLayout.setVisibility(View.GONE);
        decimalKeyboardLayout.setVisibility(View.GONE);
        octalKeyboardLayout.setVisibility(View.GONE);
        hexKeyboardLayout.setVisibility(View.GONE);
    }


    private void loadOutOfFocusViews(String s){
        if (focusedTextView == decTextView) {
        }
        else if(focusedTextView == binTextView) {
        }
        else if(focusedTextView == hexTextView){
        }
        else if(focusedTextView == octTextView){
        }
        else if(focusedTextView == iEEETextView){

        }


    }

    private void sortForConversion(String s){
        if (focusedTextView == decTextView) {
            convertFromDecimal(s);
        }
        else if(focusedTextView == binTextView) {
            convertFromBinary(s);
        }
        else if(focusedTextView == hexTextView){
            convertFromHex(s);
        }
        else if(focusedTextView == octTextView){
            convertFromOctal(s);
        }
        else if(focusedTextView == iEEETextView){
            convertFromIEEE(s);
        }
    }

    private void convertFromIEEE(String s) {
        s = s.replaceAll(" - ", "");
        if(s.length() < 32){
            String dashes = "";
            for(int i = 32 - s.length(); i > 0; i--){
                dashes += " - ";
            }
            iEEETextView.setText(s + dashes);

            binTextView.setText("");
            hexTextView.setText("");
            octTextView.setText("");
//            iEEETextView.setText("");


        } else {
            s = s.replaceAll(" - ", "");

            int bits= Integer.parseInt(s, 2);
            iEEETextView.setText(s);
            binTextView.setText(Integer.toBinaryString(bits));
            octTextView.setText(Integer.toOctalString(bits));
            decTextView.setText(Float.floatToIntBits(bits));

        }
    }

    private boolean convertFromHex(String s) {
        if(!s.equals("")) {
            try {
                s = s.toLowerCase();
                long orignalValue = Long.parseLong(s,16);
                int intBits = Float.floatToIntBits(orignalValue);

                if(Long.toBinaryString(orignalValue).length() > 30){
                    binTextView.setTextSize(15);
                } else {
                    binTextView.setTextSize(25);
                }

                if(orignalValue > 0) {
                    iEEETextView.setText("0" + Integer.toBinaryString(intBits));
                } else {
                    iEEETextView.setText(Integer.toBinaryString(intBits));

                }

                binTextView.setText(Long.toBinaryString(orignalValue));
                octTextView.setText(Long.toOctalString(orignalValue));
                decTextView.setText(Long.toString(orignalValue));
                return true;
            } catch (NumberFormatException e) {
                Toast.makeText(getApplicationContext(), "Too large", Toast.LENGTH_SHORT).show();
                deleteChar(focusedTextView);
            }
        } else {
            binTextView.setText("");
            decTextView.setText("");
            octTextView.setText("");
            iEEETextView.setText("");
        }
        return false;
    }


    private boolean convertFromOctal(String s) {
        if(!s.equals("")) {
            try {
                long orignalValue = Long.parseLong(s,8);
                int intBits = Float.floatToIntBits(orignalValue);

                if(Long.toBinaryString(orignalValue).length() > 30){
                    binTextView.setTextSize(15);
                } else {
                    binTextView.setTextSize(25);
                }

                if(orignalValue > 0) {
                    iEEETextView.setText("0" + Integer.toBinaryString(intBits));
                } else {
                    iEEETextView.setText(Integer.toBinaryString(intBits));

                }

                binTextView.setText(Long.toBinaryString(orignalValue));
                hexTextView.setText(Long.toHexString(orignalValue));
                decTextView.setText(Long.toString(orignalValue));
                return true;
            } catch (NumberFormatException e) {
                Toast.makeText(getApplicationContext(), "Too large", Toast.LENGTH_SHORT).show();
                deleteChar(focusedTextView);
            }
        } else {
            binTextView.setText("");
            hexTextView.setText("");
            octTextView.setText("");
            iEEETextView.setText("");

        }
        return false;
    }

    private boolean convertFromDecimal(String s) {
        if(!s.equals("")) {
            try {
                long orignalValue = Long.parseLong(s);
                int intBits = Float.floatToIntBits(orignalValue);

                if(orignalValue > 0) {
                    iEEETextView.setText("0" + Integer.toBinaryString(intBits));
                } else {
                    iEEETextView.setText(Integer.toBinaryString(intBits));

                }

                if(Long.toBinaryString(orignalValue).length() > 30){
                    binTextView.setTextSize(15);
                } else {
                    binTextView.setTextSize(25);
                }

                binTextView.setText(Long.toBinaryString(orignalValue));
                hexTextView.setText(Long.toHexString(orignalValue));
                octTextView.setText(Long.toOctalString(orignalValue));
                return true;
            } catch (NumberFormatException e) {
                Toast.makeText(getApplicationContext(), "Too large", Toast.LENGTH_SHORT).show();
                deleteChar(focusedTextView);
            }
        } else {
            binTextView.setText("");
            hexTextView.setText("");
            octTextView.setText("");
            iEEETextView.setText("");

        }
        return false;
    }


    private boolean convertFromBinary(String s) {
        if(!s.equals("")) {
            try {
                long orignalValue = Long.parseLong(s,2);
                int intBits = Float.floatToIntBits(orignalValue);

                if(Long.toBinaryString(orignalValue).length() > 30){
                    binTextView.setTextSize(15);
                } else {
                    binTextView.setTextSize(25);
                }

                if(orignalValue > 0) {
                    iEEETextView.setText("0" + Integer.toBinaryString(intBits));
                } else {
                    iEEETextView.setText(Integer.toBinaryString(intBits));

                }

                decTextView.setText(Long.toString(orignalValue));
                hexTextView.setText(Long.toHexString(orignalValue));
                octTextView.setText(Long.toOctalString(orignalValue));
                return true;
            } catch (NumberFormatException e) {
                Toast.makeText(getApplicationContext(), "Too large", Toast.LENGTH_SHORT).show();
                deleteChar(focusedTextView);
            }
        }  else {
            decTextView.setText("");
            hexTextView.setText("");
            octTextView.setText("");
            iEEETextView.setText("");

        }
        return false;

    }


    public void positiveNegativeOnClick(View view) {
        if(Integer.parseInt(focusedTextView.getText().toString()) > 0 ){
            focusedTextView.setText("-" + focusedTextView.getText().toString());
        } else {
            focusedTextView.setText(focusedTextView.getText().toString().substring(1));
        }

        sortForConversion(focusedTextView.getText().toString());
    }
}
