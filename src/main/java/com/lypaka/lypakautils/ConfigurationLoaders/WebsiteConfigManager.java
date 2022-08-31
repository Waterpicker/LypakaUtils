package com.lypaka.lypakautils.ConfigurationLoaders;

import com.google.common.reflect.TypeToken;
import ninja.leaping.configurate.ConfigurationNode;
import ninja.leaping.configurate.hocon.HoconConfigurationLoader;
import ninja.leaping.configurate.loader.ConfigurationLoader;
import ninja.leaping.configurate.objectmapping.ObjectMappingException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;

public class WebsiteConfigManager {

    private final String url;
    private ConfigurationNode node = null;
    private ConfigurationLoader<? extends ConfigurationNode> loader = null;
    private Map<String, List<String>> map;

    public WebsiteConfigManager (String url) {

        this.url = url;
        this.map = new HashMap<>();

    }

    public void build() throws MalformedURLException {

        URL link = new URL(this.url);
        Callable<BufferedReader> reader = () -> new BufferedReader(new InputStreamReader(link.openStream()));
        this.loader = HoconConfigurationLoader.builder()
                .setSource(reader)
                .build();

        try {

            this.node = this.loader.load();

        } catch (IOException e) {

            e.printStackTrace();

        }

    }

    public ConfigurationNode getNode() {

        return this.node;

    }

    public Map<String, List<String>> getMap (Object... objectNode) throws ObjectMappingException {

        return this.node.getNode(objectNode).getValue(new TypeToken<Map<String, List<String>>>() {});

    }

}
