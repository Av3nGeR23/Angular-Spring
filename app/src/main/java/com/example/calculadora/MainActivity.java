import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.calculadora.R;

public class MainActivity extends AppCompatActivity {

    private TextView resultTextView;
    private String currentInput = "";
    private double firstOperand = 0;
    private String operator = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultTextView = findViewById(R.id.resultTextView);
    }

    public void onDigitClick(View view) {
        Button button = (Button) view;
        currentInput += button.getText().toString();
        resultTextView.setText(currentInput);
    }

    public void onOperatorClick(View view) {
        Button button = (Button) view;
        operator = button.getText().toString();
        firstOperand = Double.parseDouble(currentInput);
        currentInput = "";
    }

    public void onEqualsClick(View view) {
        if (!currentInput.isEmpty()) {
            double secondOperand = Double.parseDouble(currentInput);
            double result = performOperation(firstOperand, secondOperand, operator);
            resultTextView.setText(String.valueOf(result));
            currentInput = "";
            operator = "";
        }
    }

    private double performOperation(double firstOperand, double secondOperand, String operator) {
        switch (operator) {
            case "+":
                return firstOperand + secondOperand;
            case "-":
                return firstOperand - secondOperand;
            case "*":
                return firstOperand * secondOperand;
            case "/":
                if (secondOperand != 0) {
                    return firstOperand / secondOperand;
                } else {
                    return Double.NaN; // Division by zero
                }
            default:
                return 0;
        }
    }

    public void onClearClick(View view) {
        currentInput = "";
        operator = "";
        resultTextView.setText("");
    }
}
