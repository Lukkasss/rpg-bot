/*
 * Created by IntelliJ IDEA.
 * User: Lucas Vilela
 * Date: 23/09/2018
 * Time: 00:25
 * To change this template use File | Settings | File and Code Templates.
 */
import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.MessageBuilder;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

import javax.security.auth.login.LoginException;

public class Main extends ListenerAdapter {
    public static void main(String[] args) throws LoginException {
        JDABuilder builder = new JDABuilder(AccountType.BOT);

        String token = "";
        builder.setToken(token);
        builder.addEventListener(new Main());
        builder.build();

    }

    @Override
    public void onMessageReceived(MessageReceivedEvent event){
        if(event.getAuthor().isBot())
            return;
        String message = event.getMessage().getContentRaw();
        System.out.printf("<%s> %s\n", event.getAuthor().getName(), event.getMessage().getContentDisplay());
        if(message.startsWith(".roll")){

            Dados dados = new Dados(Integer.valueOf(message.substring(message.indexOf(" ")).split(",")[0].trim()));
            Sabios eu = new Sabios(Integer.valueOf(message.substring(message.indexOf(" ")).split(",")[1].trim()));

            dados.rolar();

            dados.setQtdDados(eu.getQtdSabios());
            dados.rolar();

            event.getChannel().sendMessage(String.format("Faces: %s", eu.abencoa(dados.getResultado()))).queue();
            dados.transforma();
            event.getChannel().sendMessage(String.format("Valores: %s", dados.getResultado())).queue();
            dados.ordenar();
            event.getChannel().sendMessage(String.format("Resultados: %s", dados.somar(dados.getResultado()))).queue();

        }
    }
}
