package info.lamatricexiste.network.Utils;

import android.annotation.TargetApi;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.sip.SipAudioCall;
import android.net.sip.SipProfile;
import android.os.Build;

import info.lamatricexiste.network.ActivityDiscovery;

/**
 * Created by piyush.khapekar on 3/2/2016.
 */
public class IncomingCallReceiver extends BroadcastReceiver {
    /**
     * Processes the incoming call, answers it, and hands it over to the
     * WalkieTalkieActivity.
     *
     * @param context The context under which the receiver is running.
     * @param intent  The intent being received.
     */
    @TargetApi(Build.VERSION_CODES.GINGERBREAD)
    @Override
    public void onReceive(Context context, Intent intent) {
        SipAudioCall incomingCall = null;
        try {
            SipAudioCall.Listener listener = new SipAudioCall.Listener() {
                @Override
                public void onRinging(SipAudioCall call, SipProfile caller) {
                    try {
                        call.answerCall(30);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            };
            ActivityDiscovery wtActivity = (ActivityDiscovery) context;
            incomingCall = wtActivity.mSipManager.takeAudioCall(intent, listener);
            incomingCall.answerCall(30);
            incomingCall.startAudio();
            incomingCall.setSpeakerMode(true);
            if (incomingCall.isMuted()) {
                incomingCall.toggleMute();
            }
            wtActivity.call = incomingCall;
            wtActivity.updateStatus(incomingCall);
        } catch (Exception e) {
            if (incomingCall != null) {
                incomingCall.close();
            }
        }
    }
}