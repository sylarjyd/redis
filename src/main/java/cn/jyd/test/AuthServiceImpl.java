package cn.jyd.test;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import cn.jyd.inter.AuthService;

@Service("authService")
public class AuthServiceImpl implements AuthService {

	@Autowired
	private RedisUtil redisUtil; // 记得注入
	@Autowired
	private RedisTemplate redisTemplate; // 记得注入
	
	@Override
	public String verification(String tokenId) {
		String token = null;
		if (redisUtil.exists(tokenId)) {
			token = (String) redisUtil.get(tokenId); // 从缓存中查找token
		} else {
			token = tokenId + UUID.randomUUID().toString();
			redisUtil.set(tokenId, token); // 将token写入缓存
		}
		return token;
	}
	
	public void sendMessage(String channel, String message) {
	    redisTemplate.convertAndSend(channel, message);
	}
}
