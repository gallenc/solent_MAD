package fragments.example.com.fragmentsapp1;

import android.app.Activity;
        import android.preference.PreferenceFragment;
        import android.os.Bundle;

public class PrefFragment extends PreferenceFragment
{
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preferences);
    }
}
