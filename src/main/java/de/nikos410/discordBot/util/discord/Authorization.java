package de.nikos410.discordBot.util.discord;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sx.blah.discord.api.ClientBuilder;
import sx.blah.discord.api.IDiscordClient;
import sx.blah.discord.util.DiscordException;

/**
 * Contains helper method to authorize and log in a bot
 */
public class Authorization {
    private final static Logger log = LoggerFactory.getLogger(Authorization.class);

    /**
     * Create a client instance using a token as the login information.
     *
     * @param token The token to use when authorizing.
     * @param login Choose whether to log in the client after authorizing.
     * @return The created client instance.
     */
    public static IDiscordClient createClient(final String token, final boolean login) {
        final ClientBuilder clientBuilder = new ClientBuilder();
        clientBuilder.withToken(token);
        try {
            if (login) {
                return clientBuilder.login();
            } else {
                return clientBuilder.build();
            }
        } catch (DiscordException e) {
            log.error("Could not authorize the bot. Please make sure your token is correct.", e);
            throw e;
        }
    }
}