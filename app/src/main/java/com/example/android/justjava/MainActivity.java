package com.example.android.justjava;

/**
 * IMPORTANT: Make sure you are using the correct package name.
 * This example uses the package name:
 * package com.example.android.justjava
 * If you get an error when copying this code into Android studio, update it to match the package name found
 * in the project's AndroidManifest.xml file.
 **/

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {
    String subject = "Internship";
    String body = "Hi Hannah,\nGreat work! When would you like to start your internship?";
    String[] recipient = { "hannahghoover@gmail.com" };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //onClickEmail();
    }

    /**
     * This method opens email application and fills out subject and body.
     */
    public void sendEmail(View view) {

        // Build the intent
        //Uri data = Uri.parse("mailto:recipient@example.com?subject=" + subject + "&body=" + body);
        Intent emailIntent = new Intent(Intent.ACTION_MAIN);
        emailIntent.addCategory(Intent.CATEGORY_APP_EMAIL);
        //emailIntent.setData(data);

        emailIntent.putExtra(Intent.EXTRA_EMAIL, recipient);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, subject);
        emailIntent.putExtra(Intent.EXTRA_TEXT, body);

        emailIntent.setType("plain/text");
        startActivity(Intent.createChooser(emailIntent, "Send your email in:"));

/*
        // Verify the app exists to handle the intent
        PackageManager packageManager = getPackageManager();
        List<ResolveInfo> activities = packageManager.queryIntentActivities(emailIntent, 0);
        boolean isIntentSafe = activities.size() > 0;

        // Start activity if it is safe to do so
        if (isIntentSafe) {
            startActivity(emailIntent);
        }
            */
        /*
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_APP_EMAIL);
        startActivity(intent);
        */
        /*
        Intent intent = getPackageManager().getLaunchIntentForPackage("com.android.email");
        startActivity(intent);
        */
    }
}