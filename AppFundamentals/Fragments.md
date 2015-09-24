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

## Creating event callbacks to the activity
```java
public static class FragmentA extends ListFragment {
    ...
    // Container Activity must implement this interface
    public interface OnArticleSelectedListener {
        public void onArticleSelected(Uri articleUri);
    }
    ...
}

public static class FragmentA extends ListFragment {
    OnArticleSelectedListener mListener;
    ...
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnArticleSelectedListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implement OnArticleSelectedListener");
        }
    }
    ...
}
```

## Adding items to the Action Bar

Your fragments can contribute menu items to the activity's Options Menu (and, consequently, the Action Bar) by implementing **onCreateOptionsMenu()**. In order for this method to receive calls, however, you must call **setHasOptionsMenu()** during **onCreate()**, to indicate that the fragment would like to add items to the Options Menu (otherwise, the fragment will not receive a call to **onCreateOptionsMenu()**).

## Fragment Lifecycle
![Fragment Lifecycle Flowchart](http://developer.android.com/images/activity_fragment_lifecycle.png)

**Source:**
* [Android Developer: Fragment Example Code](http://developer.android.com/guide/components/fragments.html#Example)
