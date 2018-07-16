package de.stormfox2.compass.listener;

import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;
import org.bukkit.entity.Player;
import org.bukkit.plugin.messaging.PluginMessageListener;

public class PluginMessaging implements PluginMessageListener {
    public void onPluginMessageReceived(String s, Player player, byte[] bytes) {
        if(!s.equals("BungeeCord")){
            return;
        }

        ByteArrayDataInput in = ByteStreams.newDataInput(bytes);
        String subchannel = in.readUTF();


    }
}
