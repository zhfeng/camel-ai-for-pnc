package io.quarkiverse.langchain4j.sample.chatbot;

import dev.langchain4j.agent.tool.Tool;
import jakarta.enterprise.context.ApplicationScoped;

import java.io.BufferedReader;
import java.io.InputStreamReader;

@ApplicationScoped
public class BaconTools {
    
    @Tool("get build config with artifact name")
    String getBuildConfig(String name) {
        try {
            ProcessBuilder builder = new ProcessBuilder();
            builder.command("bacon", "pnc", "build-config", "list", "--query=name=like=%" + name + "%");
            Process process = builder.start();

            StringBuilder output = new StringBuilder();
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                output.append(line).append("\n");
            }
            
            return output.toString();
        } catch (Exception e) {
            return "Error in get build config of " + name;
        }
    }
}
