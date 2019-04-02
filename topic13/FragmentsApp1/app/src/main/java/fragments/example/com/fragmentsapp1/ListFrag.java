package fragments.example.com.fragmentsapp1;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.app.ListFragment;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.view.View;
import android.widget.Toast;

public class ListFrag extends ListFragment {
    String[] entries = {"Tim Berners-Lee", "John Lennon", "Linus Torvalds", "Barack Obama"},
            entryValues = {"Inventor of the World Wide Web.", "Singer and songwriter from the Beatles whose life was cut tragically short in 1980.",
                    "Original developer of Linux.", "Current president of the US."};

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_list_item_1, entries);
        setListAdapter(adapter);
    }


    public void onListItemClick(ListView lv, View v, int index, long id) {
        // get the person Details fragment
        PersonDetailsFragment personDetailsFragment = (PersonDetailsFragment)getFragmentManager().findFragmentById(R.id.personDetailsFrag);

        personDetailsFragment.setText(entries[index]+"\n"+entryValues[index]);

        Toast.makeText(getActivity(), entryValues[index], Toast.LENGTH_LONG).show();
    }
}