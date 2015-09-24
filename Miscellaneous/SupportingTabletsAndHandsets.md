# Supporting Tablets and Handsets
The Android platform runs on a variety of screen sizes and the system gracefully resizes your application's UI to fit each one. 

![Tablets and Handsets](http://developer.android.com/images/fundamentals/fragments.png)

res/layout/main.xml for handsets:
```xml
<?xml version="1.0" encoding="utf-8"?>
<FrameLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent">
    <!-- "Fragment A" -->
    <fragment class="com.example.android.TitlesFragment"
              android:id="@+id/list_frag"
              android:layout_width="match_parent"
              android:layout_height="match_parent"/>
</FrameLayout>
```

res/layout-large/main.xml for tablets:
```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
  android:orientation="horizontal"
  android:layout_width="match_parent"
  android:layout_height="match_parent"
  android:id="@+id/frags">
    <!-- "Fragment A" -->
  <fragment class="com.example.android.TitlesFragment"
            android:id="@+id/list_frag"
            android:layout_width="@dimen/titles_size"
            android:layout_height="match_parent"/>
    <!-- "Fragment B" -->
  <fragment class="com.example.android.DetailsFragment"
            android:id="@+id/details_frag"
            android:layout_width="match_parent"
            android:layout_height="match_parent" />
</LinearLayout>
```

```java
public class MainActivity extends Activity implements TitlesFragment.OnItemSelectedListener {
    ...

    /** This is a callback that the list fragment (Fragment A)
        calls when a list item is selected */
    public void onItemSelected(int position) {
        DisplayFragment displayFrag = (DisplayFragment) getFragmentManager()
                                    .findFragmentById(R.id.display_frag);
        if (displayFrag == null) {
            // DisplayFragment (Fragment B) is not in the layout (handset layout),
            // so start DisplayActivity (Activity B)
            // and pass it the info about the selected item
            Intent intent = new Intent(this, DisplayActivity.class);
            intent.putExtra("position", position);
            startActivity(intent);
        } else {
            // DisplayFragment (Fragment B) is in the layout (tablet layout),
            // so tell the fragment to update
            displayFrag.updateContent(position);
        }
    }
}
```

## Split Action Bar (Android 4.0 / API 14)
![Split Action Bar](http://developer.android.com/images/practices/actionbar-phone-splitaction.png)

**Source:** [Android Developer: Supporting Tablets and Handsets](http://developer.android.com/guide/practices/tablets-and-handsets.html)
