package ctec.savingstate.controller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import ctec.savingstate.model.AndroidSaveState;

public class BackActivity extends AppCompatActivity
{
    private AndroidSaveState saveState;
    private Button backButton;
    private TextView userText;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_back);

        saveState = (AndroidSaveState) getApplication();
        backButton = (Button) findViewById(R.id.BackButton);
        userText = (TextView) findViewById(R.id.BackText);

        loadContent();
        setupListeners();
    }

    private void loadContent()
    {
        userText.setText(saveState.getUserName() + " is " + saveState.getAge() + " years old and it is " + saveState.getIsTired() + " that they are tired.");
    }

    private void setupListeners()
    {
        backButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View buttonView)
            {
                Intent returnIntent = new Intent();
                setResult(RESULT_OK, returnIntent);
                finish();
            }
        });
    }
}
