package com.example.t21p_222181313;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

//Student Name : Henry Xiao
//Student ID : 222181313
// Assignment : Pass Task 2.1
public class MainActivity extends Activity {

    private Spinner convertFromSpinner, convertToSpinner;
    private EditText inputEditValue;
    private TextView convertResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize UI components
        convertFromSpinner = (Spinner) findViewById(R.id.convert_from);
        convertToSpinner = (Spinner) findViewById(R.id.convert_to);
        inputEditValue = (EditText) findViewById(R.id.convert_value);
        convertResult = (TextView) findViewById(R.id.view_result_text);
        Button convertButton = (Button) findViewById(R.id.convert_button);

        // set the spinners according to arrays.xml
        ArrayAdapter<CharSequence> convertFromAdapter = ArrayAdapter.createFromResource(this, R.array.conversionUnits, android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> convertToAdapter = ArrayAdapter.createFromResource(this, R.array.conversionUnits, android.R.layout.simple_spinner_item);
        convertFromAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        convertToAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        convertFromSpinner.setAdapter(convertFromAdapter);
        convertToSpinner.setAdapter(convertToAdapter);

        // Set the default selection and display the selction
        convertFromSpinner.setSelection(0);
        convertToSpinner.setSelection(0);

        // Set the listeners for the button click
        convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Get the convert units
                String convertFromUnit = convertFromSpinner.getSelectedItem().toString();
                String convertToUnit = convertToSpinner.getSelectedItem().toString();

                // Get value which needs to be converted
                String valueString = inputEditValue.getText().toString();

                //Validate to ensure that the value is not empty
                if (valueString.isEmpty() || Double.parseDouble(valueString)==0) {
                    Toast.makeText(getApplicationContext(), "Kindly choose valid convert-from/to units. Kindly input an appropriate number for conversion(No '0')", Toast.LENGTH_SHORT).show();
                    return;
                }
                //Validate to ensure that the source unit and destination unit are not the same
                if (convertFromUnit.equals(convertToUnit)) {
                    Toast.makeText(getApplicationContext(), "Please select a different destination/convert-to unit.", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Convert the value and display the result
                double value = 0;
                try {
                    value = Double.parseDouble(valueString);
                } catch (NumberFormatException e) {
                    Toast.makeText(getApplicationContext(), "Kindly input an appropriate number for conversion", Toast.LENGTH_SHORT).show();
                    return;
                }

                // set result value and catch exception
                double result = 0;

                //convert from one length unit to other length units, from one weight unit to other weight units, from one temperature unit to other temperature units
                if (convertFromUnit.equals("centimeter")) {
                    if (convertToUnit.equals("centimeter")) {
                        result = value;
                    } else if (convertToUnit.equals("yard")) {
                        result = value / 91.44;
                    } else if (convertToUnit.equals("foot")) {
                        result = value / 30.48;
                    } else if (convertToUnit.equals("inch")) {
                        result = value / 2.54;
                    }
                } else if (convertFromUnit.equals("yard")) {
                    if (convertToUnit.equals("centimeter")) {
                        result = value * 91.44;
                    } else if (convertToUnit.equals("yard")) {
                        result = value;
                    } else if (convertToUnit.equals("foot")) {
                        result = value * 3;
                    } else if (convertToUnit.equals("inch")) {
                        result = value * 36;
                    }
                } else if (convertFromUnit.equals("foot")) {
                    if (convertToUnit.equals("centimeter")) {
                        result = value * 30.48;
                    } else if (convertToUnit.equals("yard")) {
                        result = value / 3;
                    } else if (convertToUnit.equals("foot")) {
                        result = value;
                    } else if (convertToUnit.equals("inch")) {
                        result = value * 12;
                    }
                } else if (convertFromUnit.equals("inch")) {
                    if (convertToUnit.equals("centimeter")) {
                        result = value * 2.54;
                    } else if (convertToUnit.equals("yard")) {
                        result = value / 2.54;
                    } else if (convertToUnit.equals("foot")) {
                        result = value * 12;
                    } else if (convertToUnit.equals("inch")) {
                        result = value;
                    }
                }   //convert from one weight unit to other weight units
                else if (convertFromUnit.equals("kilogram")) {
                    if (convertToUnit.equals("kilogram")) {
                        result = value;
                    } else if (convertToUnit.equals("gram")) {
                        result = value * 1000;
                    } else if (convertToUnit.equals("pound")) {
                        result = value * 2.205;
                    } else if (convertToUnit.equals("ounce")) {
                        result = value * 35.274;
                    }
                } else if (convertFromUnit.equals("gram")) {
                    if (convertToUnit.equals("kilogram")) {
                        result = value / 1000;
                    } else if (convertToUnit.equals("gram")) {
                        result = value;
                    } else if (convertToUnit.equals("pound")) {
                        result = value / 453.592;
                    } else if (convertToUnit.equals("ounce")) {
                        result = value / 28.35;
                    }
                } else if (convertFromUnit.equals("pound")) {
                    if (convertToUnit.equals("kilogram")) {
                        result = value / 2.205;
                    } else if (convertToUnit.equals("gram")) {
                        result = value * 453.592;
                    } else if (convertToUnit.equals("pound")) {
                        result = value;
                    } else if (convertToUnit.equals("ounce")) {
                        result = value * 16;
                    }
                } else if (convertFromUnit.equals("ounce")) {
                    if (convertToUnit.equals("kilogram")) {
                        result = value / 35.274;
                    } else if (convertToUnit.equals("gram")) {
                        result = value * 28.35;
                    } else if (convertToUnit.equals("pound")) {
                        result = value / 16;
                    } else if (convertToUnit.equals("ounce")) {
                        result = value;
                    }
                }   //convert from one temperature unit to other temperature units
                else if (convertFromUnit.equals("celsius")) {
                    if (convertToUnit.equals("celsius")) {
                        result = value;
                    } else if (convertToUnit.equals("fahrenheit")) {
                        result = value * 1.8 + 32;
                    }
                } else if (convertFromUnit.equals("fahrenheit")) {
                    if (convertToUnit.equals("celsius")) {
                        result = (value - 32) / 1.8;
                    } else if (convertToUnit.equals("fahrenheit")) {
                        result = value;
                    }
                }

                //if there is no result after calculation, display an error message
                if (result == 0) {
                    Toast.makeText(getApplicationContext(), "Please choose valid convert-from/to units. Don't convert one type of units to another type of units", Toast.LENGTH_SHORT).show();
                    return;
                }

                //Display the result
                convertResult.setText(String.valueOf(result));
                Toast.makeText(getApplicationContext(), String.valueOf(result), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
