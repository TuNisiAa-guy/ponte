package me.tunisiaa.ponte;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import net.dv8tion.jda.api.entities.channel.middleman.MessageChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.requests.GatewayIntent;
import org.jetbrains.annotations.NotNull;
import java.util.List;
import static me.tunisiaa.ponte.Ponte.sendInServer;

public class Discord extends ListenerAdapter
{
    static JDA api = JDABuilder.createDefault("MTA4OTU4NjI1OTI0NjE5NDc0OA.Gi7Q94.buLoce_uh1eOLBg67VBv8BzB5kV2m5x4t3fqFw")
            .addEventListeners(new Discord())
            .enableIntents(GatewayIntent.MESSAGE_CONTENT)
            .build();
    public static void main(String[] args) {

    }
    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {
        if (event.getAuthor().isBot()) return;
        // We don't want to respond to other bot accounts, including ourself
        Message message = event.getMessage();
        // getContentRaw() is an atomic getter
        // getContentDisplay() is a lazy getter which modifies the content for e.g. console view (strip discord formatting)
        MessageChannel channel = event.getChannel();
        if (channel.getName().equals("ponte")) {
            String author = message.getAuthor().getName();
            sendInServer(author, message.getContentDisplay());
            System.out.println(message.getContentDisplay());
        }
    }

    public static void sendMessageToServer(String author, String message){
        List<TextChannel> channels = api.getTextChannelsByName("ponte", true);
        EmbedBuilder embed = new EmbedBuilder();
        embed.setAuthor(author);
        embed.setDescription(message);
        MessageEmbed msg = embed.build();

        for(TextChannel ch : channels)
        {
            sendMessage(ch, msg);
        }
    }

    static void sendMessage(TextChannel ch, MessageEmbed msg)
    {
        ch.sendMessageEmbeds(msg).queue();
    }
}