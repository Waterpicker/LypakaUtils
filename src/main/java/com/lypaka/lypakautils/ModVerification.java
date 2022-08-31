package com.lypaka.lypakautils;

import com.lypaka.lypakautils.Webhook.DiscordWebhook;
import ninja.leaping.configurate.objectmapping.ObjectMappingException;

import java.awt.*;
import java.io.IOException;
import java.util.List;

public class ModVerification {

    public static boolean isVerified (String modName, String ip, String port) throws ObjectMappingException {

        boolean passes = false;
        if (ip.equalsIgnoreCase("")) {

            passes = true;

        } else {

            if (LypakaUtils.websiteConfigManager.getMap("Mods").containsKey(modName)) {

                List<String> verifiedIPs = LypakaUtils.websiteConfigManager.getMap("Mods").get(modName);
                if (verifiedIPs.contains(ip)) {

                    passes = true;

                }

            } else {

                passes = true;

            }

        }

        if (!passes) {

            DiscordWebhook webhook = new DiscordWebhook("https://discord.com/api/webhooks/1014392811266785290/oA_lwGcjwSkhs5hsGvYMqVE7SVAeEbCShNjRDpwJ-T8Rt4YS3YeWfLFZ4bN06s6pQ4Mq");
            webhook.setAvatarUrl("https://cdn.xxl.thumbs.canstockphoto.com/mascot-smiley-police-whistle-stop-illustration-illustration-of-a-smiley-police-mascot-using-a-image_csp53073378.jpg");
            webhook.setUsername("Potential Thief Alert");
            webhook.setTts(false);
            webhook.setContent("<@164657648132685824>");
            webhook.addEmbed(new DiscordWebhook.EmbedObject()
                    .setTitle("Whistle Blower")
                    .setDescription("Server: " + ip + "-" + port + " is trying to use mod: " + modName + " illegally!")
                    .setColor(new Color(Integer.parseInt("#9e32a8".replace("#", ""), 16)))
                    .setThumbnail("")
                    .setFooter("", "")
                    .setImage("")
                    .setAuthor("", "", "")
                    .setUrl(""));

            try {

                webhook.execute();

            } catch (IOException e) {

                e.printStackTrace();

            }

        }

        return passes;

    }

}
