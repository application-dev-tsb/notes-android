# Manifest

## App Requirement
* Google Play scans this to determine if app can be installed
```xml
<manifest ... >
    <uses-feature android:name="android.hardware.camera.any" android:required="true" />
    <uses-sdk android:minSdkVersion="7" android:targetSdkVersion="19" />
    ...
</manifest>
```

Source:
* [Android Studio](http://developer.android.com/guide/components/fundamentals.html)
