package com.example.plandsSite.Controller;

import com.example.plandsSite.Query.ServerListPing17;
import com.example.plandsSite.Query.StatusResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.net.InetSocketAddress;
import java.io.IOException;

@RestController
public class MinecraftController {

    private final ServerListPing17 serverListPing17;

    public MinecraftController(ServerListPing17 serverListPing17) {
        this.serverListPing17 = serverListPing17;
    }

    @GetMapping("/pingServer")
    public StatusResponse pingServer() {
        try {
            InetSocketAddress address = new InetSocketAddress("plands.ru", 25575);
            return serverListPing17.fetchData(address, 7000);
        } catch (IOException e) {
            // Handle exception
            e.printStackTrace();
        }
        return null;
    }
}
