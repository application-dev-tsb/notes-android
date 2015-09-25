# Broadcast Receiver
There are two major classes of broadcasts that can be received:
* **Normal broadcasts** (sent with Context.sendBroadcast) are completely asynchronous. All receivers of the broadcast are run in an undefined order, often at the same time. This is more efficient, but means that receivers cannot use the result or abort APIs included here.
* **Ordered broadcasts** (sent with Context.sendOrderedBroadcast) are delivered to one receiver at a time. As each receiver executes in turn, it can propagate a result to the next receiver, or it can completely abort the broadcast so that it won't be passed to other receivers. The order receivers run in can be controlled with the android:priority attribute of the matching intent-filter; receivers with the same priority will be run in an arbitrary order.


## Notes
* [LocalBroadcastManager](http://developer.android.com/reference/android/support/v4/content/LocalBroadcastManager.html) - for sending and receiving in-app broadcast effectively
* If registering a receiver in your **Activity.onResume()** implementation, you should unregister it in **Activity.onPause()**

