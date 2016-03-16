package ybm.farm8bot;

import org.apache.commons.lang.StringUtils;
import org.telegram.telegrambots.TelegramApiException;
import org.telegram.telegrambots.api.methods.SendMessage;
import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.api.objects.User;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;

public class Farm8Bot extends TelegramLongPollingBot
{
	@Override
	public String getBotUsername()
	{
		return "Farm8Bot";
	}
	
	@Override
	public String getBotToken()
	{
		return "185978768:AAE2t7tKm1yk2v81EKEMyA51v4IetWAjYT8";
	}
	
	@Override
	public void onUpdateReceived(Update update)
	{
		try
		{
			Message message = update.getMessage();
			if (message != null && message.hasText())
			{
				System.out.println("got: " + update.getMessage().getText());
				SendMessage sendMessage = new SendMessage();
				sendMessage.setChatId(message.getChatId().toString());
				//sendMessage.setReplayToMessageId(message.getMessageId());
				sendMessage.setText("got: " + update.getMessage().getText() + " from "
				    + getAgentNameIfPossible(message.getFrom()));
				
				sendMessage(sendMessage);
			}
		}
		catch (TelegramApiException tae)
		{
			System.err.println(tae.getApiResponse());
			tae.printStackTrace();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	private String getAgentNameIfPossible(User user)
	{
		String agentName = getAgentNameByBracket(user.getLastName());
		if (StringUtils.isNotEmpty(agentName))
			return "agent " + agentName;
		agentName = getAgentNameByBracket(user.getFirstName());
		if (StringUtils.isNotEmpty(agentName))
			return "agent " + agentName;
		agentName = getAgentNameByBracket(user.getUserName());
		if (StringUtils.isNotEmpty(agentName))
			return "agent " + agentName;
		return user.getUserName();
	}
	
	private String getAgentNameByBracket(String source)
	{
		if (source != null)
		{
			int opener = source.indexOf('(');
			if (opener > -1)
			{
				int closer = source.indexOf(')', opener);
				if (closer > -1)
				{
					return source.substring(opener + 1, closer);
				}
			}
		}
		return null;
	}
	
	private void createFarm()
	{
		
	}
}
