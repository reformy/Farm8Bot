package ybm.farm8bot;

import org.telegram.telegrambots.TelegramBotsApi;

public class Main
{
	public static void main(String[] args) throws Exception
	{
		TelegramBotsApi telegramBotsApi = new TelegramBotsApi();
		telegramBotsApi.registerBot(new Farm8Bot());
		telegramBotsApi.registerBot(new ZainBot());
	}
}
