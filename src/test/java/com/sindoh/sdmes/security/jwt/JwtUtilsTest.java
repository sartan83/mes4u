package com.sindoh.sdmes.security.jwt;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Base64;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.test.util.ReflectionTestUtils;

import com.sindoh.sdmes.model.Users;
import com.sindoh.sdmes.security.service.UserDetailsImpl;

class JwtUtilsTest {

	private JwtUtils jwtUtils;

	private static JwtUtils newJwtUtils(byte[] key, int expirationMs) {
		JwtUtils utils = new JwtUtils();
		ReflectionTestUtils.setField(utils, "jwtSecret", Base64.getEncoder().encodeToString(key));
		ReflectionTestUtils.setField(utils, "jwtExpirationMs", expirationMs);
		return utils;
	}

	private static UsernamePasswordAuthenticationToken authFor(String username) {
		Users user = new Users();
		user.setId(1L);
		user.setUsername(username);
		UserDetailsImpl principal = new UserDetailsImpl(user, List.of(new SimpleGrantedAuthority("ROLE_ADMIN")));
		return new UsernamePasswordAuthenticationToken(principal, null, principal.getAuthorities());
	}

	@BeforeEach
	void setUp() {
		jwtUtils = newJwtUtils(new byte[64], 60_000);
	}

	@Test
	void generatedTokenIsHs512AndRoundTrips() {
		String token = jwtUtils.generateJwtToken(authFor("administrator"));

		String header = new String(Base64.getUrlDecoder().decode(token.split("\\.")[0]));
		assertTrue(header.contains("\"alg\":\"HS512\""), header);
		assertTrue(jwtUtils.validateJwtToken(token));
		assertEquals("administrator", jwtUtils.getUserNameFromJwtToken(token));
	}

	@Test
	void tokenSignedWithAnotherKeyIsRejected() {
		byte[] otherKey = new byte[64];
		otherKey[0] = 1;
		String token = newJwtUtils(otherKey, 60_000).generateJwtToken(authFor("administrator"));

		assertFalse(jwtUtils.validateJwtToken(token));
	}

	@Test
	void expiredTokenIsRejected() {
		String token = newJwtUtils(new byte[64], -1_000).generateJwtToken(authFor("administrator"));

		assertFalse(jwtUtils.validateJwtToken(token));
	}

	@Test
	void malformedOrEmptyTokenIsRejected() {
		assertFalse(jwtUtils.validateJwtToken("not-a-jwt"));
		assertFalse(jwtUtils.validateJwtToken(""));
	}
}
