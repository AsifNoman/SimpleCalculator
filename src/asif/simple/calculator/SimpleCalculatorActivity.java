package asif.simple.calculator;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class SimpleCalculatorActivity extends Activity  {
	
	Button zero,one,two,three,four,five,six,seven,eight,nine;
	Button add,sub,mult,div;
	Button history,memory,clear,erase;
	Button brace1,brace2,percent,square;
	Button point,equal;
	TextView allView;
	private calculate calculat = new calculate();
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        zero = (Button) findViewById(R.id.zero);
        one = (Button) findViewById(R.id.one);
        two = (Button) findViewById(R.id.two);
        three = (Button) findViewById(R.id.three);
        four = (Button) findViewById(R.id.four);
        five = (Button) findViewById(R.id.five);
        six = (Button) findViewById(R.id.six);
        seven = (Button) findViewById(R.id.seven);
        eight = (Button) findViewById(R.id.eight);
        nine = (Button) findViewById(R.id.nine);
        add = (Button) findViewById(R.id.add);
        sub = (Button) findViewById(R.id.sub);
        mult = (Button) findViewById(R.id.mult);
        div = (Button) findViewById(R.id.div);
        history = (Button) findViewById(R.id.history);
        memory = (Button) findViewById(R.id.memory);
        clear = (Button) findViewById(R.id.clear);
        erase = (Button) findViewById(R.id.erase);
        brace1 = (Button) findViewById(R.id.brace1);
        brace2 = (Button) findViewById(R.id.brace2);
        percent = (Button) findViewById(R.id.percent);
        square = (Button) findViewById(R.id.square);
        point = (Button) findViewById(R.id.point);
        equal = (Button) findViewById(R.id.equal);
        allView = (TextView) findViewById(R.id.allView);
    }

	@Override
	protected void onResume() {
		
		super.onResume();
		
		equal.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				
				String operation = allView.getText().toString();
				calculat.Calculation(operation.replaceAll("([-+*/%^()])", " $1 "));
				
				allView.setText(allView.getText().toString() + " = " +  String.valueOf(calculat.getResult()));
			}
		});
		
		memory.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				
				SharedPreferences saveInfo = getSharedPreferences("operation", Context.MODE_PRIVATE);
				
				SharedPreferences.Editor editor = saveInfo.edit();
				editor.putString("value", allView.getText().toString());
				editor.commit();
				
			}
		});
		
		history.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				
				SharedPreferences saveInfo = getSharedPreferences("operation", Context.MODE_PRIVATE);
				
				String data = saveInfo.getString("value","");
				allView.setText(data);
				
			}
		});
		
	}

	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		
		zero.setOnClickListener(new View.OnClickListener() {		
			public void onClick(View v) {
				allView.setText(allView.getText().toString() + "0");
			}
		});
		
		one.setOnClickListener(new View.OnClickListener() {		
			public void onClick(View v) {
				allView.setText(allView.getText().toString() + "1");
			}
		});
		
		two.setOnClickListener(new View.OnClickListener() {		
			public void onClick(View v) {
				allView.setText(allView.getText().toString() + "2");
			}
		});
		
		three.setOnClickListener(new View.OnClickListener() {		
			public void onClick(View v) {
				allView.setText(allView.getText().toString() + "3");
			}
		});
		
		four.setOnClickListener(new View.OnClickListener() {		
			public void onClick(View v) {
				allView.setText(allView.getText().toString() + "4");
			}
		});
		
		five.setOnClickListener(new View.OnClickListener() {		
			public void onClick(View v) {
				allView.setText(allView.getText().toString() + "5");
			}
		});
		
		six.setOnClickListener(new View.OnClickListener() {		
			public void onClick(View v) {
				allView.setText(allView.getText().toString() + "6");
			}
		});
		
		seven.setOnClickListener(new View.OnClickListener() {		
			public void onClick(View v) {
				allView.setText(allView.getText().toString() + "7");
			}
		});
		
		eight.setOnClickListener(new View.OnClickListener() {		
			public void onClick(View v) {
				allView.setText(allView.getText().toString() + "8");
			}
		});
		
		nine.setOnClickListener(new View.OnClickListener() {		
			public void onClick(View v) {
				allView.setText(allView.getText().toString() + "9");
			}
		});
		
		add.setOnClickListener(new View.OnClickListener() {		
			public void onClick(View v) {
				allView.setText(allView.getText().toString() + "+");
			}
		});
		
		sub.setOnClickListener(new View.OnClickListener() {		
			public void onClick(View v) {
				allView.setText(allView.getText().toString() + "-");
			}
		});
		
		mult.setOnClickListener(new View.OnClickListener() {		
			public void onClick(View v) {
				allView.setText(allView.getText().toString() + "*");
			}
		});
		
		div.setOnClickListener(new View.OnClickListener() {		
			public void onClick(View v) {
				allView.setText(allView.getText().toString() + "/");
			}
		});
		
		brace1.setOnClickListener(new View.OnClickListener() {		
			public void onClick(View v) {
				allView.setText(allView.getText().toString() + "(");
			}
		});
		
		brace2.setOnClickListener(new View.OnClickListener() {		
			public void onClick(View v) {
				allView.setText(allView.getText().toString() + ")");
			}
		});
		
		percent.setOnClickListener(new View.OnClickListener() {		
			public void onClick(View v) {
				allView.setText(allView.getText().toString() + "%");
			}
		});
		
		square.setOnClickListener(new View.OnClickListener() {		
			public void onClick(View v) {
				allView.setText(allView.getText().toString() + "^");
			}
		});
		
		point.setOnClickListener(new View.OnClickListener() {		
			public void onClick(View v) {
				allView.setText(allView.getText().toString() + ".");
			}
		});
		
		clear.setOnClickListener(new View.OnClickListener() {		
			public void onClick(View v) {
				allView.setText(null);
			}
		});
		
		erase.setOnClickListener(new View.OnClickListener() {		
			public void onClick(View v) {
				
				int length = allView.getText().length();
				
				if (length > 0) {
					String text = allView.getText().toString();
					allView.setText(text.substring(0, text.length() - 1));
				}
			}
		});
	}
}
