package com.example.plandsSite.Service;

import com.github.t9t.minecraftrconclient.RconClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RconService {

    @Value("${rcon.password}")
    private String rconPassword;

    public void addWhitelist(String playerName) {
        try (RconClient client = RconClient.open("plands.ru", 25575, rconPassword)) {
            client.sendCommand(String.format("easywhitelist add %s", playerName));
        }
    }
}