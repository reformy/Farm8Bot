package ybm.farm8bot;

import org.telegram.telegrambots.api.objects.Update;
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
		System.out.println("got: " + update.getMessage().getText());
	}
}
