package mystikos.phonelookup;

import android.net.Uri;
import android.support.customtabs.CustomTabsIntent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.PhoneNumberFormattingTextWatcher;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText Jphone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Jphone = findViewById(R.id.number);
        Jphone.addTextChangedListener(new PhoneNumberFormattingTextWatcher());
    }

    public void lookup(View v) {
        Uri uri = Uri.parse("http://www.whitepages.com/phone/" + Jphone.getText().toString());
        CustomTabsIntent.Builder intentBuilder = new CustomTabsIntent.Builder();
        CustomTabsIntent customTabsIntent = intentBuilder.build();
        customTabsIntent.launchUrl(this, uri);
    }
}
