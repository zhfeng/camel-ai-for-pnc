package io.quarkiverse.langchain4j.sample.chatbot;

import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import io.quarkiverse.langchain4j.RegisterAiService;
import io.smallrye.mutiny.Multi;
import jakarta.enterprise.context.SessionScoped;

//@RegisterAiService(retrievalAugmentor = AugmentorExample.class, tools = BaconTools.class)
@RegisterAiService(tools = BaconTools.class)
@SessionScoped
public interface Bot {

    @SystemMessage("""
            You are an export to a PNC build system and you can help people to build Red Hat product.
            """)
    // Using Multi enable streaming.
    String chat(@UserMessage String question);
}
