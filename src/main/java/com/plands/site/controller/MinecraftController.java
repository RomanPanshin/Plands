package com.plands.site.controller;

import com.plands.site.query.MCQuery;
import com.plands.site.query.QueryResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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
