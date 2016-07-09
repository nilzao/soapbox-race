package br.com.soapboxrace.definition;

import java.util.List;
import java.lang.reflect.Field;
import java.util.ArrayList;

import br.com.soapboxrace.jaxb.ChatRoomType;

@SuppressWarnings("unused")
public final class ChatRooms {
	private static ChatRoomType germanChat = new ChatRoomType(10, "TXT_CHAT_LANG_GERMAN", "DE");
	private static ChatRoomType frenchChat = new ChatRoomType(10, "TXT_CHAT_LANG_FRENCH", "FR");
	private static ChatRoomType englishChat = new ChatRoomType(10, "TXT_CHAT_LANG_ENGLISH", "EN");
	private static ChatRoomType spanishChat = new ChatRoomType(10, "TXT_CHAT_LANG_SPANISH", "ES");
	private static ChatRoomType polishChat = new ChatRoomType(10, "TXT_CHAT_LANG_POLISH", "PL");
	private static ChatRoomType brChat = new ChatRoomType(10, "TXT_CHAT_LANG_BRAZILIANPORTUGUESE", "BR");
	private static ChatRoomType russianChat = new ChatRoomType(10, "TXT_CHAT_LANG_RUSSIAN", "RU");
	private static ChatRoomType generalChat = new ChatRoomType(10, "TXT_CHAT_LANG_GENERAL", "GN");
	
	public static List<ChatRoomType> getRooms() {
		List<ChatRoomType> chatRooms = new ArrayList<ChatRoomType>();
        for(Field f : ChatRooms.class.getDeclaredFields())
        {
            try {
				chatRooms.add((ChatRoomType) f.get(null));
			} catch (IllegalArgumentException | IllegalAccessException e) {
				e.printStackTrace();
				chatRooms.add(englishChat);
				continue;
			}
        }
        return chatRooms;
	}
}