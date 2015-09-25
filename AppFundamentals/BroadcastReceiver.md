# Broadcast Receiver
There are two major classes of broadcasts that can be received:
* **Normal broadcasts** (sent with Context.sendBroadcast) are completely asynchronous. All receivers of the broadcast are run in an undefined order, often at the same time. This is more efficient, but means that receivers cannot use the result or abort APIs included here.
* **Ordered broadcasts** (sent with Context.sendOrderedBroadcast) are delivered to one receiver at a time. As each receiver executes in turn, it can propagate a result to the next receiver, or it can completely abort the broadcast so that it won't be passed to other receivers. The order receivers run in can be controlled with the android:priority attribute of the matching intent-filter; receivers with the same priority will be run in an arbitrary order.

## Security
* In the < receiver > declaration use **android:exported="false"** to prevent other apps from sending broadcasts
* To enforce a permission when sending, you supply a non-null permission argument to sendBroadcast(Intent, String) or sendOrderedBroadcast(Intent, String, BroadcastReceiver, android.os.Handler, int, String, Bundle). Only receivers who have been granted this permission (by requesting it with the < uses-permission > tag in their AndroidManifest.xml) will be able to receive the broadcast.
* To enforce a permission when receiving, you supply a non-null permission when registering your receiver -- either when calling registerReceiver(BroadcastReceiver, IntentFilter, String, android.os.Handler) or in the static < receiver > tag in your AndroidManifest.xml. Only broadcasters who have been granted this permission (by requesting it with the < uses-permission > tag in their AndroidManifest.xml) will be able to send an Intent to the receiver.

## Notes
* [LocalBroadcastManager](http://developer.android.com/reference/android/support/v4/content/LocalBroadcastManager.html) - for sending and receiving in-app broadcast effectively
* If registering a receiver in your **Activity.onResume()** implementation, you should unregister it in **Activity.onPause()**

