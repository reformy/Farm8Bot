package ybm.farm8bot;

import org.apache.commons.lang.WordUtils;
import org.telegram.telegrambots.api.methods.SendMessage;
import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;

public class ZainBot extends TelegramLongPollingBot
{
	
	@Override
	public String getBotUsername()
	{
		return "REUNBot";
	}
	
	@Override
	public void onUpdateReceived(Update update)
	{
		try
		{
			Message message = update.getMessage();
			if (message != null && message.hasText())
			{
				String res;
				if (message.getText().contains("���"))
				{
					res = "��� ���� �� ������ �� ��";
				}
				else if (message.getFrom().getUserName().equals("nikiBlade"))
				{
					res = "�� ������ ���� ����� ��������";
				}
				else
				{
					res = "���";
					for (int i = 2; i < WordUtils.initials(message.getText()).length(); i++)
					{
						res += " ���";
					}
				}
				
				SendMessage sendMessage = new SendMessage();
				sendMessage.setChatId(message.getChatId().toString());
				sendMessage.setText(res);
				
				sendMessage(sendMessage);
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	@Override
	public String getBotToken()
	{
		return "202652499:AAEa11WgmvqG1kGeYnGVBbOusJmBsXZxVYs";
	}
	
}
