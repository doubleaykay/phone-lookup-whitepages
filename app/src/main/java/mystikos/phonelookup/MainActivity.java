package mystikos.phonelookup;

import android.content.Intent;
import android.net.Uri;
import android.support.customtabs.CustomTabsIntent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.PhoneNumberFormattingTextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.Phonenumber;

import static android.R.attr.phoneNumber;

public class MainActivity extends AppCompatActivity {

    private EditText Jphone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Jphone = (EditText) findViewById(R.id.number);
        Jphone.addTextChangedListener(new PhoneNumberFormattingTextWatcher());
    }

    public void lookup(View v) {
//        Intent intent = new Intent();
//        intent.setAction(Intent.ACTION_VIEW);
//        intent.addCategory(Intent.CATEGORY_BROWSABLE);
//        intent.setData(Uri.parse("http://www.whitepages.com/phone/" + Jphone.getText().toString()));
//        startActivity(intent);
        Uri uri = Uri.parse("http://www.whitepages.com/phone/" + Jphone.getText().toString());
        CustomTabsIntent.Builder intentBuilder = new CustomTabsIntent.Builder();
        CustomTabsIntent customTabsIntent = intentBuilder.build();
        customTabsIntent.launchUrl(this, uri);
    }
}
