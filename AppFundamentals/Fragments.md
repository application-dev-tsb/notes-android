# Fragments
A Fragment represents a behavior or a portion of user interface in an Activity. You can combine multiple fragments in a single activity to build a multi-pane UI and reuse a fragment in multiple activities. You can think of a fragment as a modular section of an activity, which has its own lifecycle, receives its own input events, and which you can add or remove while the activity is running (sort of like a "sub activity" that you can reuse in different activities).
* you cannot remove a fragment from an activity if it's been declared in the XML layout

## Creating a Fragment
```java
public static class ExampleFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.example_fragment, container, false);
    }
}
```

## Commonly-used Fragments
* [Dialog Fragment](http://developer.android.com/reference/android/app/DialogFragment.html)
* [List Fragment](http://developer.android.com/reference/android/app/ListFragment.html)
* [PreferenceFragment](http://developer.android.com/reference/android/preference/PreferenceFragment.html)

## Managing Fragments
See [FragmentManager](http://developer.android.com/reference/android/app/FragmentManager.html) for more information regarding fragment stack management.
```java
// Create new fragment and transaction
Fragment newFragment = new ExampleFragment();
FragmentTransaction transaction = getFragmentManager().beginTransaction();

// Replace whatever is in the fragment_container view with this fragment,
// and add the transaction to the back stack
transaction.replace(R.id.fragment_container, newFragment);
transaction.addToBackStack(null);

// Commit the transaction
transaction.commit();
```
