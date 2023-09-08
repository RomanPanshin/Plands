package com.example.plandsSite.Controller;
import com.example.plandsSite.Query.*;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.net.InetSocketAddress;
import java.io.IOException;

@RestController
public class MinecraftController {
    @GetMapping("/pingServer")
    public int pingServer() {

        MCQuery mcQuery = new MCQuery("plands.ru", 25565);
        QueryResponse response = mcQuery.basicStat();
        int players = response.getOnlinePlayers();
        return players;
    }
}
