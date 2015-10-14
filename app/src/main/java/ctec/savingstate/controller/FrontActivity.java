package ctec.savingstate.controller;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.CheckBox;
import ctec.savingstate.model.AndroidSaveState;
import android.content.Intent;

public class FrontActivity extends Activity
{

    private Button sendToOtherScreenButton;
    private EditText nameText;
    private EditText ageText;
    private CheckBox tiredBox;

    private AndroidSaveState saveState;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_front);

        saveState = (AndroidSaveState) getApplication();

        sendToOtherScreenButton = (Button) findViewById(R.id.SubmitButton);
        nameText = (EditText) findViewById(R.id.NameText);
        ageText = (EditText) findViewById(R.id.AgeText);
        tiredBox = (CheckBox) findViewById(R.id.IsTiredBox);

        setupListeners();
    }

    private void setupListeners()
    {
        sendToOtherScreenButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View clickView)
            {
                //Grab user input
                String name = nameText.getText().toString();
                int age = Integer.parseInt(ageText.getText().toString());
                boolean tired = tiredBox.isChecked();

                //Save user input to the Save State
                saveState.setAge(age);
                saveState.setUserName(name);
                saveState.setIsTired(tired);

                Intent newScreenIntent = new Intent(clickView.getContext(), BackActivity.class);
                startActivityForResult(newScreenIntent, 0);
            }
        });
    }
}
