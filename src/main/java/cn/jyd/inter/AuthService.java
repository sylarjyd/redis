package cn.jyd.inter;

public interface AuthService {
	  public abstract String verification(String tokenId);
	  public void sendMessage(String channel, String message);
}
