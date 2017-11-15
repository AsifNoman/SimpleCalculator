package asif.simple.calculator;

import java.util.Set;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class SimpleCalculatorActivity extends Activity  {
	
	Button history,memory,clear,erase;
	TextView allView;
	private calculate calculat = new calculate();
	Button buttons[] = new Button[20]; 
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        buttons[0] = (Button) findViewById(R.id.zero);
        buttons[1] = (Button) findViewById(R.id.one);
        buttons[2] = (Button) findViewById(R.id.two);
        buttons[3] = (Button) findViewById(R.id.three);
        buttons[4] = (Button) findViewById(R.id.four);
        buttons[5] = (Button) findViewById(R.id.five);
        buttons[6] = (Button) findViewById(R.id.six);
        buttons[7] = (Button) findViewById(R.id.seven);
        buttons[8] = (Button) findViewById(R.id.eight);
        buttons[9] = (Button) findViewById(R.id.nine);
        buttons[10] = (Button) findViewById(R.id.add);
        buttons[11] = (Button) findViewById(R.id.sub);
        buttons[12] = (Button) findViewById(R.id.mult);
        buttons[13] = (Button) findViewById(R.id.div);
        history = (Button) findViewById(R.id.history);
        memory = (Button) findViewById(R.id.memory);
        clear = (Button) findViewById(R.id.clear);
        erase = (Button) findViewById(R.id.erase);
        buttons[14] = (Button) findViewById(R.id.brace1);
        buttons[15] = (Button) findViewById(R.id.brace2);
        buttons[16] = (Button) findViewById(R.id.percent);
        buttons[17] = (Button) findViewById(R.id.square);
        buttons[18] = (Button) findViewById(R.id.point);
        buttons[19] = (Button) findViewById(R.id.equal);
        allView = (TextView) findViewById(R.id.allView);
    }

	@Override
	protected void onResume() {
		
		super.onResume();
		
		buttons[19].setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				
				String operation = allView.getText().toString();
				String[] matches = new String[] {"++","+-","+*","+/","--","-*","-/","**","*/","//","+%","-%","*%","/%","%%","%^","^^","^+",
						"^-","^*","^/",".+",".-",".*","./",".%",".^","(.)",")("};
				
				calculat.Calculation(operation.replaceAll("([-+*/%^()])", " $1 "));
				
				for (String s : matches)
				{
				  if (operation.contains(s))
				  {
					  Toast.makeText(getApplicationContext(),calculat.getError(),Toast.LENGTH_LONG).show();
				  }
				  else if (!operation.contains(s))
				  {
					  allView.setText(String.valueOf(calculat.getResult()));
				  }
				}
				
			}
		});
		
		memory.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				
				try
				{
					SharedPreferences saveInfo = getSharedPreferences( "View" , Context.MODE_PRIVATE);
					SharedPreferences.Editor editor = saveInfo.edit();
                    String values = saveInfo.getString("Result", "History: ");
                    String appendedValues = values + allView.getText().toString() + " , ";
                    editor.putString("Result", appendedValues);
                    editor.commit();
                    Toast.makeText(getApplicationContext(),"Saved",Toast.LENGTH_LONG).show();
				}
				catch(Exception e)
				{
					 Toast.makeText(getApplicationContext(),"Error",Toast.LENGTH_LONG).show();
				}
				
			}
		});
		
		history.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				
				try
				{
					SharedPreferences saveInfo = getSharedPreferences("View", Context.MODE_PRIVATE);
					
					String data = saveInfo.getString("Result","");
					allView.setText(data);
					
					for(int i = 0 ; i < 20 ; i++)
					{
						buttons[i].setEnabled(false);
					}
					
					memory.setEnabled(false);
					erase.setEnabled(true);
				}
				catch(Exception e)
				{
					 Toast.makeText(getApplicationContext(),"Error",Toast.LENGTH_LONG).show();
				}
				
			}
		});
		
		erase.setOnClickListener(new View.OnClickListener() {		
			public void onClick(View v) {
				
				try
				{
					SharedPreferences saveInfo = getSharedPreferences("View", Context.MODE_PRIVATE);
					saveInfo.edit().remove("Result").commit();
					Toast.makeText(getApplicationContext(),"Meomory Cleared",Toast.LENGTH_LONG).show();
				}
				catch( Exception e)
				{
					Toast.makeText(getApplicationContext(),"Error",Toast.LENGTH_LONG).show();
				}
			}
		});
		
		clear.setOnClickListener(new View.OnClickListener() {		
			public void onClick(View v) {
				allView.setText(null);
				
				for(int i = 0 ; i < 20 ; i++)
				{
					buttons[i].setEnabled(true);
				}
				
				erase.setEnabled(false);
				memory.setEnabled(true);
			}
		});
		
	}

	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		
		erase.setEnabled(false);
		
		buttons[0].setOnClickListener(new View.OnClickListener() {		
			public void onClick(View v) {
				allView.setText(allView.getText().toString() + "0");
			}
		});
		
		buttons[1].setOnClickListener(new View.OnClickListener() {		
			public void onClick(View v) {
				allView.setText(allView.getText().toString() + "1");
			}
		});
		
		buttons[2].setOnClickListener(new View.OnClickListener() {		
			public void onClick(View v) {
				allView.setText(allView.getText().toString() + "2");
			}
		});
		
		buttons[3].setOnClickListener(new View.OnClickListener() {		
			public void onClick(View v) {
				allView.setText(allView.getText().toString() + "3");
			}
		});
		
		buttons[4].setOnClickListener(new View.OnClickListener() {		
			public void onClick(View v) {
				allView.setText(allView.getText().toString() + "4");
			}
		});
		
		buttons[5].setOnClickListener(new View.OnClickListener() {		
			public void onClick(View v) {
				allView.setText(allView.getText().toString() + "5");
			}
		});
		
		buttons[6].setOnClickListener(new View.OnClickListener() {		
			public void onClick(View v) {
				allView.setText(allView.getText().toString() + "6");
			}
		});
		
		buttons[7].setOnClickListener(new View.OnClickListener() {		
			public void onClick(View v) {
				allView.setText(allView.getText().toString() + "7");
			}
		});
		
		buttons[8].setOnClickListener(new View.OnClickListener() {		
			public void onClick(View v) {
				allView.setText(allView.getText().toString() + "8");
			}
		});
		
		buttons[9].setOnClickListener(new View.OnClickListener() {		
			public void onClick(View v) {
				allView.setText(allView.getText().toString() + "9");
			}
		});
		
		buttons[10].setOnClickListener(new View.OnClickListener() {		
			public void onClick(View v) {
				allView.setText(allView.getText().toString() + "+");
			}
		});
		
		buttons[11].setOnClickListener(new View.OnClickListener() {		
			public void onClick(View v) {
				allView.setText(allView.getText().toString() + "-");
			}
		});
		
		buttons[12].setOnClickListener(new View.OnClickListener() {		
			public void onClick(View v) {
				allView.setText(allView.getText().toString() + "*");
			}
		});
		
		buttons[13].setOnClickListener(new View.OnClickListener() {		
			public void onClick(View v) {
				allView.setText(allView.getText().toString() + "/");
			}
		});
		
		buttons[14].setOnClickListener(new View.OnClickListener() {		
			public void onClick(View v) {
				allView.setText(allView.getText().toString() + "(");
			}
		});
		
		buttons[15].setOnClickListener(new View.OnClickListener() {		
			public void onClick(View v) {
				allView.setText(allView.getText().toString() + ")");
			}
		});
		
		buttons[16].setOnClickListener(new View.OnClickListener() {		
			public void onClick(View v) {
				allView.setText(allView.getText().toString() + "%");
			}
		});
		
		buttons[17].setOnClickListener(new View.OnClickListener() {		
			public void onClick(View v) {
				allView.setText(allView.getText().toString() + "^");
			}
		});
		
		buttons[18].setOnClickListener(new View.OnClickListener() {		
			public void onClick(View v) {
				allView.setText(allView.getText().toString() + ".");
			}
		});
	}
}
